package liglab.imag.fr.metadata.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.actions.OpenNewClassWizardAction;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.part.FileEditorInput;

public class JDTUtil {

	/**
	 * Gets the Java project that contains currently opened metadata file
	 * 
	 * @return
	 */
	public static IJavaProject getCurrentJavaProject() {
		IFileEditorInput editorInputFile = (IFileEditorInput) PlatformUI.getWorkbench()
		      .getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		IJavaProject javaProject = JavaCore.create(editorInputFile.getFile().getProject());
		return javaProject;
	}

	/**
	 * Displays a Java editor with the specified type (class or interface)
	 * 
	 * @param type
	 *           java type to open in the editor
	 */
	public static void openJavaEditor(IType type) {
		IPath path = type.getPath();
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		openFileInEditor(file);
	}
	
	public static void openFileInEditor(IFile file) {
		IEditorInput editorInput = new FileEditorInput(file);
		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			      .openEditor(editorInput, desc.getId());
		} catch (PartInitException e1) {
			e1.printStackTrace();
		}
	}
	

	/**
	 * Shows a Java Search dialog and returns the selection
	 * 
	 * @param includeMask
	 *           Defines where search (source code, application libraries, system
	 *           libraries or referenced projects)see
	 *           {@link org.eclipse.jdt.core.search.IJavaSearchScope}
	 * @param style
	 *           Defines what to search (classes, interfaces, etc) see
	 *           {@link IJavaElementSearchConstants}
	 * @param multipleSelection
	 *           determines if multiple selection is allowed in the search dialog
	 * @return
	 */
	public static IType openSearchJDTDialog(int includeMask, int style, boolean multipleSelection) {
		try {
			IJavaElement[] javaElements = new IJavaElement[] { getCurrentJavaProject() };
			IJavaSearchScope scope = SearchEngine.createJavaSearchScope(javaElements, includeMask);
			SelectionDialog dialog = JavaUI.createTypeDialog(null, null, scope, style, multipleSelection);
			// dialog.setTitle("Find type to use");
			// dialog.setMessage("Select the interface to add");
			dialog.open();
			Object[] result = dialog.getResult();
			if (result != null && result.length > 0) {
				IType selectedClass = (IType) result[0];
				return selectedClass;
			}
		} catch (JavaModelException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates a new package Fragment if it doest'n exist
	 * 
	 * @param packageName
	 * @param packageFragmentRoot
	 * @return
	 */
	public static IPackageFragment createPackageFragment(String packageName,
	      IPackageFragmentRoot packageFragmentRoot) {

		IPackageFragment fragment = null;
		try {
			if (packageFragmentRoot != null) {
				if (!packageName.isEmpty()) {
					fragment = packageFragmentRoot.getPackageFragment(packageName);
					if (!fragment.exists()) {
						packageFragmentRoot.createPackageFragment(packageName, true, null);
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		return fragment;
	}

	/**
	 * Opens the (OpenNewClassWizardAction) JDT wizard to create a new class into
	 * the project
	 * 
	 * @param qualifiedClassName
	 *           the qualified class name
	 * @param javaProject
	 *           the (java) project
	 * @return the created Class
	 */
	public static IType openCreateJavaClassWizard(String qualifiedClassName, IJavaProject javaProject,
	      List<String> interfaces) {

		OpenNewClassWizardAction wizardAction = new OpenNewClassWizardAction();
		String className = "";
		String packageName = "";
		NewClassWizardPage wizardPage = new NewClassWizardPage();
		IPackageFragmentRoot packageFragmentRoot = null;

		// Gets the default package fragment root
		packageFragmentRoot = JDTUtil.getDefaultSourcePackageFragmentRoot(javaProject);
		wizardPage.setPackageFragmentRoot(packageFragmentRoot, true);

		// Sets the java class and package name
		if (qualifiedClassName != null && !qualifiedClassName.isEmpty()) {
			className = JDTUtil.getJavaClassName(qualifiedClassName).trim();
			packageName = JDTUtil.getJavaPackageName(qualifiedClassName).trim();
			if (!className.isEmpty())
				wizardPage.setTypeName(className, true);				
			else
				wizardPage.setTypeName(qualifiedClassName + "Impl", true);
										
			if (packageFragmentRoot != null) {
				if (!packageName.isEmpty()) {
					IPackageFragment fragment = JDTUtil.createPackageFragment(packageName, packageFragmentRoot);
					wizardPage.setPackageFragment(fragment, true);
				}
			}
		}

		// Adds interfaces to wizard
		for (String interfaze : interfaces) {
			wizardPage.addSuperInterface(interfaze);
		}

		wizardPage.setMethodStubSelection(false, false, true, true);
		wizardAction.setConfiguredWizardPage(wizardPage);
		wizardAction.run();
		IType newClass = (IType) wizardAction.getCreatedElement();
		return newClass;
	}

	public static IPackageFragmentRoot getDefaultSourcePackageFragmentRoot(IJavaProject javaProject) {
		List<IPackageFragmentRoot> roots = JDTUtil.getSourcePackageFragmentRoots(javaProject);
		if (!roots.isEmpty())
			return roots.get(0);
		return null;
	}

	public static List<IPackageFragmentRoot> getSourcePackageFragmentRoots(IJavaProject javaProject) {
		List<IPackageFragmentRoot> fragmentRoots = new ArrayList<IPackageFragmentRoot>();
		try {
			for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots())
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE)
					fragmentRoots.add(root);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return fragmentRoots;
	}

	public static ICompilationUnit getCompilationUnit(IJavaProject javaProject, String fullClassName) {
		String packageName = JDTUtil.getJavaPackageName(fullClassName);
		String className = JDTUtil.getJavaClassName(fullClassName);
		List<IPackageFragmentRoot> roots = getSourcePackageFragmentRoots(javaProject);
		for (IPackageFragmentRoot root : roots) {
	      IPackageFragment fragment = root.getPackageFragment(packageName);
	      if (fragment.exists()) {
	      	ICompilationUnit unit = fragment.getCompilationUnit(className + ".java");
	      	if (unit.exists())
	      		return unit;
	      }
      }
		return null;
	}
	
	/**
	 * Formats a JDT compilation Unit
	 * @param compilationUnit the compilation unit
	 * @throws JavaModelException
	 */
	public static void formatCompilationUnit(ICompilationUnit compilationUnit) throws JavaModelException {
		CodeFormatter formatter = ToolFactory.createCodeFormatter(null);
		ISourceRange range = compilationUnit.getSourceRange();
		TextEdit edit = formatter.format(CodeFormatter.K_COMPILATION_UNIT, compilationUnit.getSource(),
		      range.getOffset(), range.getLength(), 0, null);
		compilationUnit.applyTextEdit(edit, null);
		compilationUnit.save(null, false);
	}
	
	/**
	 * Gets the java name of a class
	 * 
	 * @param qualifiedClassName
	 *           the qualified class name
	 * @return
	 */
	public static String getJavaClassName(String qualifiedClassName) {
		String className = "";
		if (qualifiedClassName.lastIndexOf('.') > 0) {
			className = qualifiedClassName.substring(qualifiedClassName.lastIndexOf('.') + 1); // Map$Entry
		}
		// The $ can be converted to a .
		className = className.replace('$', '.');
		return className;
	}

	
	public static String firstCharacterToLowerCase(String text) {
		char c[] = text.toCharArray();
		 c[0] = Character.toLowerCase(c[0]);
		 return new String(c);
	}
	
	/**
	 * Gets the package name
	 * 
	 * @param qualifiedClassName
	 * @return
	 */
	public static String getJavaPackageName(String qualifiedClassName) {
		int lastDot = qualifiedClassName.lastIndexOf('.');
		if (lastDot == -1) {
			return "";
		}
		return qualifiedClassName.substring(0, lastDot);
	}

}
