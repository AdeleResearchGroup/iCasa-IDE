/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.component;

import java.util.List;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.ui.editor.MetadataEditor;
import liglab.imag.fr.metadata.ui.editor.dialog.DependencyDialog;
import liglab.imag.fr.metadata.ui.editor.dialog.PropertyDialog;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.RequiresType;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.actions.OpenNewClassWizardAction;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author Gabriel
 * 
 */
public class ComponentDetailsPage implements IDetailsPage {

	private IManagedForm mform;

	private ComponentType input;

	private MetadataEditor editor;

	private Text nameText;

	private Text classNameText;

	private Text invalidateText;

	private Text validateText;

	private Button providesButton;

	private Viewer componentsViewer;

	private TableViewer dependenciesViewer;

	private TableViewer propertiesViewer;

	private TextFieldModifyListener textFieldModifyListener;

	private ButtonSelectionListener buttonSelectionListener;

	public ComponentDetailsPage(MetadataEditor editor, Viewer componentsViewer) {
		this.editor = editor;
		this.componentsViewer = componentsViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.IFormPart#initialize(org.eclipse.ui.forms.IManagedForm
	 * )
	 */
	@Override
	public void initialize(IManagedForm form) {
		mform = form;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#dispose()
	 */
	@Override
	public void dispose() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#isDirty()
	 */
	@Override
	public boolean isDirty() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#commit(boolean)
	 */
	@Override
	public void commit(boolean onSave) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#isStale()
	 */
	@Override
	public boolean isStale() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#refresh()
	 */
	@Override
	public void refresh() {
		System.out.println("refrehs was invoked");
		update();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.IPartSelectionListener#selectionChanged(org.eclipse
	 * .ui.forms.IFormPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection) selection;
		if (ssel.size() == 1) {
			input = (ComponentType) ssel.getFirstElement();
		} else
			input = null;
		update();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.IDetailsPage#createContents(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createContents(Composite parent) {
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		parent.setLayout(layout);

		textFieldModifyListener = new TextFieldModifyListener();
		buttonSelectionListener = new ButtonSelectionListener();
		createGeneralSection(parent);
		createPropertiesSection(parent);
		createDependenciesSection(parent);
		createLifeCycleSection(parent);

	}

	/**
	 * Creates the General section of component description (component name, classname and
	 * provides)
	 * 
	 * @param parent
	 */
	private void createGeneralSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Component Details"); //$NON-NLS-1$
		s1.setDescription("Set the description of the selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);


		Composite client = toolkit.createComposite(s1);
		TableWrapLayout tableLayout = new TableWrapLayout();
		tableLayout.numColumns = 3;

		td.grabHorizontal = true;
		client.setLayout(tableLayout);

		toolkit.createLabel(client, "Component Name"); //$NON-NLS-1$

		td = new TableWrapData(TableWrapData.FILL_GRAB);
		nameText = toolkit.createText(client, "", SWT.SINGLE); //$NON-NLS-1$		
		nameText.addModifyListener(textFieldModifyListener);
		nameText.setLayoutData(td);

		providesButton = toolkit.createButton(client, "OSGi Service Provision", SWT.CHECK);
		providesButton.setData("providesService");
		providesButton.addSelectionListener(buttonSelectionListener);

		Hyperlink link = toolkit.createHyperlink(client, "Implementation Class", SWT.WRAP);
		link.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				IJavaProject javaProject = getJavaProject();
				if (!classNameText.getText().equals("")) {
					IType selectedClass = null;
					try {
						selectedClass = javaProject.findType(classNameText.getText());
					} catch (JavaModelException e2) {
						e2.printStackTrace();
					}
					if (selectedClass != null) {
						openJavaEditor(selectedClass);
					} else {
						IType newClass = openCreateJavaClassWizard(classNameText.getText(), javaProject);
						if (newClass != null) {
							classNameText.setText(newClass.getFullyQualifiedName());
						}
					}
				} else {
					IType newClass = openCreateJavaClassWizard(classNameText.getText(), javaProject);
					if (newClass != null) {
						classNameText.setText(newClass.getFullyQualifiedName());
					}
				}				
			}
		});

		classNameText = toolkit.createText(client, "", SWT.SINGLE); //$NON-NLS-1$
		classNameText.setEditable(false);
		classNameText.addModifyListener(textFieldModifyListener);
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		classNameText.setLayoutData(td);

		Button browseButton = toolkit.createButton(client, "Browse", SWT.FLAT);
		browseButton.setData("browseClass");
		browseButton.addSelectionListener(buttonSelectionListener);

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}

	/**
	 * Creates the Properties section of component description
	 * 
	 * @param parent
	 */
	private void createPropertiesSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
		      | Section.EXPANDED);
		s1.marginWidth = 10;
		s1.setText("Component Properties"); //$NON-NLS-1$
		s1.setDescription("Set the properties of the selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		s1.setLayoutData(td);

		Composite client = toolkit.createComposite(s1);
		TableWrapLayout glayout = new TableWrapLayout();
		glayout.makeColumnsEqualWidth = true;
		glayout.numColumns = 2;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		td.rowspan = 3;
		Table t = toolkit.createTable(client, SWT.NULL);
		t.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button addButton = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addButton.setData("addProperty");
		addButton.addSelectionListener(buttonSelectionListener);
		addButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editProperty");
		editButton.addSelectionListener(buttonSelectionListener);
		editButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteProperty");
		deleteButton.addSelectionListener(buttonSelectionListener);
		deleteButton.setLayoutData(td);

		propertiesViewer = new TableViewer(t);
		propertiesViewer.setContentProvider(new ArrayContentProvider());
		propertiesViewer.setLabelProvider(new ComponentElementsLabelProvider());

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}

	/**
	 * Creates the Dependencies section of component description
	 * 
	 * @param parent
	 */
	private void createDependenciesSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
		      | Section.EXPANDED);
		section.marginWidth = 10;
		section.setText("Component Dependencies"); //$NON-NLS-1$
		section.setDescription("Set the service dependencies of the selected component"); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);

		Composite client = toolkit.createComposite(section);
		TableWrapLayout glayout = new TableWrapLayout();
		glayout.makeColumnsEqualWidth = true;
		glayout.numColumns = 2;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		Table table = toolkit.createTable(client, SWT.NULL);
		td.rowspan = 4;
		table.setLayoutData(td);

		Button addButton = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addButton.setData("addDependency");
		addButton.addSelectionListener(buttonSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		addButton.setLayoutData(td);

		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editDependency");
		editButton.addSelectionListener(buttonSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		editButton.setLayoutData(td);

		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteDependency");
		deleteButton.addSelectionListener(buttonSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		deleteButton.setLayoutData(td);

		dependenciesViewer = new TableViewer(table);
		dependenciesViewer.setContentProvider(new ArrayContentProvider());
		dependenciesViewer.setLabelProvider(new ComponentElementsLabelProvider());

		toolkit.paintBordersFor(section);
		section.setClient(client);
	}

	/**
	 * Creates the Life Cycle section of component description
	 * 
	 * @param parent
	 */
	private void createLifeCycleSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		section.marginWidth = 10;
		section.setText("Component Lifecycle Callbacks"); //$NON-NLS-1$
		section.setDescription("Set Component lifecycle callbacks of selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);

		Composite client = toolkit.createComposite(section);
		TableWrapLayout glayout = new TableWrapLayout();
		glayout.makeColumnsEqualWidth = true;
		glayout.horizontalSpacing = 10;
		glayout.leftMargin = 10;
		glayout.numColumns = 4;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		Label label = toolkit.createLabel(client, "validate");
		label.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		validateText = toolkit.createText(client, "");
		validateText.setLayoutData(td);
		validateText.addModifyListener(textFieldModifyListener);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		Label invalidateLabel = toolkit.createLabel(client, "invalidate");
		invalidateLabel.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		invalidateText = toolkit.createText(client, "");
		invalidateText.setLayoutData(td);
		invalidateText.addModifyListener(textFieldModifyListener);

		toolkit.paintBordersFor(section);
		section.setClient(client);
	}

	/**
	 * Updates the page widgets using the new component input 
	 * 
	 */
	private void update() {
		if (input != null) {

			removeListeners();

			nameText.setText(input.getName());

			classNameText.setText("");
						
			if (input.getClassname() != null)
				classNameText.setText(input.getClassname());

			providesButton.setSelection(!input.getProvides().isEmpty());

			dependenciesViewer.setInput(input.getRequires());

			List<PropertiesType> props = input.getProperties();
			if (props.size() > 0) {
				List<PropertyType> innerProps = props.get(0).getProperty();
				propertiesViewer.setInput(innerProps.toArray());
			} else {
				propertiesViewer.setInput(null);
			}

			validateText.setText("");
			invalidateText.setText("");
			CallbackType callback = ModelUtil.getValidateCallback(input);
			if (callback != null)
				validateText.setText(callback.getMethod());
			callback = ModelUtil.getInvalidateCallback(input);
			if (callback != null)
				invalidateText.setText(callback.getMethod());

			addListeners();
		}
	}

	/**
	 * Adds listeners to text fields
	 */
	private void removeListeners() {
		nameText.removeModifyListener(textFieldModifyListener);
		classNameText.removeModifyListener(textFieldModifyListener);
		validateText.removeModifyListener(textFieldModifyListener);
		invalidateText.removeModifyListener(textFieldModifyListener);
	}

	/**
	 * Removes listeners to text fields
	 */
	private void addListeners() {
		nameText.addModifyListener(textFieldModifyListener);
		classNameText.addModifyListener(textFieldModifyListener);
		validateText.addModifyListener(textFieldModifyListener);
		invalidateText.addModifyListener(textFieldModifyListener);
	}

	/**
	 * Gets the java project containing the actual metadata.xml file
	 * @return
	 */
	private IJavaProject getJavaProject() {
		IFileEditorInput editorInputFile = (IFileEditorInput) PlatformUI.getWorkbench()
		      .getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		IJavaProject javaProject = JavaCore.create(editorInputFile.getFile().getProject());
		return javaProject;
	}

	/**
	 * Opens the java editor with the specified IType
	 * @param type
	 */
	private void openJavaEditor(IType type) {
		IPath path = type.getPath();
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
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
	 * Opens the (OpenNewClassWizardAction) JDT wizard  to create a new class into
	 * the project
	 * 
	 * @param qualifiedClassName
	 *           the qualified class name
	 * @param javaProject
	 *           the (java) project
	 * @return the created Class
	 */
	private IType openCreateJavaClassWizard(String qualifiedClassName, IJavaProject javaProject) {
		OpenNewClassWizardAction wizardAction = new OpenNewClassWizardAction();
		String className = "";
		String packageName = "";
		NewClassWizardPage wizardPage = new NewClassWizardPage();
		IPackageFragmentRoot packageFragmentRoot = null;

		if (qualifiedClassName != null && qualifiedClassName.length() > 0) {
			className = getJavaClassName(qualifiedClassName);
			packageName = getJavaPackageName(qualifiedClassName);
			wizardPage.setTypeName(className, true);

			try {
				packageFragmentRoot = javaProject.getAllPackageFragmentRoots()[0];
				if (packageFragmentRoot != null) {
					if (!packageName.isEmpty()) {
						IPackageFragment fragment = createPackageFragment(packageName, javaProject);
						wizardPage.setPackageFragment(fragment, true);
					}
					wizardPage.setPackageFragmentRoot(packageFragmentRoot, true);
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}

		wizardAction.setConfiguredWizardPage(wizardPage);
		wizardAction.run();
		IType newClass = (IType) wizardAction.getCreatedElement();
		return newClass;
	}

	/**
	 * Creates a new package Fragment if it doest'n exist
	 * 
	 * @param packageName
	 * @param javaProject  
	 * @return
	 */
	private IPackageFragment createPackageFragment(String packageName, IJavaProject javaProject) {

		IPackageFragment fragment = null;
		try {
			IPackageFragmentRoot packageFragmentRoot = javaProject.getAllPackageFragmentRoots()[0];
			if (packageFragmentRoot != null) {
				if (!packageName.isEmpty()) {
					fragment = packageFragmentRoot.getPackageFragment(packageName);
					if (fragment != null)
						return fragment;
					// Creates the new fragment
					IFolder folder = javaProject.getProject().getFolder("src");
					IPackageFragmentRoot srcFolder = javaProject.getPackageFragmentRoot(folder);
					fragment = srcFolder.createPackageFragment(packageName, true, null);
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		return fragment;
	}

	/**
	 * Gets the java name of a class
	 * @param qualifiedClassName the qualified class name
	 * @return
	 */
	private String getJavaClassName(String qualifiedClassName) {
		String className = "";
		if (qualifiedClassName.lastIndexOf('.') > 0) {
			className = qualifiedClassName.substring(qualifiedClassName.lastIndexOf('.') + 1); // Map$Entry
		}
		// The $ can be converted to a .
		className = className.replace('$', '.');
		return className;
	}

	/**
	 * Gets the package name
	 * @param qualifiedClassName
	 * @return
	 */
	public String getJavaPackageName(String qualifiedClassName) {
		int lastDot = qualifiedClassName.lastIndexOf('.');
		if (lastDot == -1) {
			return "";
		}
		return qualifiedClassName.substring(0, lastDot);
	}

	/**
	 * Determines if the dependency is based on a field
	 * @param requirement
	 * @return
	 */
	private boolean isFieldDependency(RequiresType requirement) {
		return requirement.getCallback().isEmpty();
	}

	/**
	 * LabelProvider used for elements of a component(properties and
	 * dependencies)
	 * 
	 * @author Gabriel
	 * 
	 */
	class ComponentElementsLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof RequiresType) {
				RequiresType requirement = (RequiresType) element;
				if (isFieldDependency(requirement)) {
					return requirement.getField();
				} else { // Method Requirement
					if (requirement.getId() != null)
						return requirement.getId();
					return "anonymous";
				}
			}
			if (element instanceof PropertyType) {
				PropertyType property = (PropertyType) element;
				return property.getName();
			}
			return null;
		}
	}

	/**
	 * Handles modifications in text fields
	 * 
	 * @author Gabriel
	 *
	 */
	class TextFieldModifyListener implements ModifyListener {

		@Override
		public void modifyText(ModifyEvent event) {
			if (input != null) {
				EditingDomain editingDomain = editor.getEditingDomain();
				Command command = null;

				if (event.widget.equals(nameText)) {
					command = CommandFactory.createSetComponentNameCommand(editingDomain, input,
					      nameText.getText());
				} else if (event.widget.equals(classNameText)) {
					command = CommandFactory.createSetComponentClassCommand(editingDomain, input,
					      classNameText.getText());
				} else if (event.widget.equals(validateText)) {
					command = CommandFactory.createSetValidateTransitionCommand(editingDomain, input,
					      validateText.getText());
				} else if (event.widget.equals(invalidateText)) {
					command = CommandFactory.createSetInvalidateTransitionCommand(editingDomain, input,
					      invalidateText.getText());
				}
				if (command != null)
					executeCommand(command);
				if (event.widget.equals(nameText))
					componentsViewer.refresh();
			}
		}
	}

	/**
	 * 
	 * Handles all clicks action in buttons of details Section
	 * 
	 * @author Gabriel
	 * 
	 */
	class ButtonSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {
			if (input != null) {
				String data = (String) event.widget.getData();
				EditingDomain editingDomain = editor.getEditingDomain();
				if (data.equals("addDependency")) {
					DependencyDialog dialog = new DependencyDialog(editingDomain, null);
					if (dialog.open() == Window.OK) {
						Command command = CommandFactory.createAddRequirementCommand(editingDomain, input,
						      dialog.getRequirement());
						executeCommand(command);						
						refreshDependenciesViewer();
					}
				} else if (data.equals("editDependency")) {
					IStructuredSelection selection = (IStructuredSelection) dependenciesViewer.getSelection();
					if (selection.size() > 0) {
						RequiresType requirement = (RequiresType) selection.getFirstElement();
						DependencyDialog dialog = new DependencyDialog(editingDomain, requirement);
						if (dialog.open() == Window.OK)
							refreshDependenciesViewer();
					}
				} else if (data.equals("deleteDependency")) {
					IStructuredSelection selection = (IStructuredSelection) dependenciesViewer.getSelection();
					if (selection.size() > 0) {
						RequiresType requirement = (RequiresType) selection.getFirstElement();
						Command command = CommandFactory.createRemoveRequirementCommand(editingDomain, input,
						      requirement);
						executeCommand(command);
						refreshDependenciesViewer();
					}
				} else if (data.equals("addProperty")) {
					PropertyDialog dialog = new PropertyDialog(editingDomain, null);
					if (dialog.open() == Window.OK) {
						Command command = CommandFactory.createAddPropertyCommand(editingDomain, input,
						      dialog.getProperty());
						executeCommand(command);
						refreshPropertiesViewer();
					}
				} else if (data.equals("editProperty")) {
					IStructuredSelection selection = (IStructuredSelection) propertiesViewer.getSelection();
					if (selection.size() > 0) {
						PropertyType property = (PropertyType) selection.getFirstElement();
						PropertyDialog dialog = new PropertyDialog(editingDomain, property);
						if (dialog.open() == Window.OK) {
							propertiesViewer.setInput(input.getProperties().get(0).getProperty().toArray());
							editor.fireDirtyProperty();
						}
					}
				} else if (data.equals("deleteProperty")) {
					IStructuredSelection selection = (IStructuredSelection) propertiesViewer.getSelection();
					if (selection.size() > 0) {
						PropertyType property = (PropertyType) selection.getFirstElement();
						Command command = CommandFactory
						      .createRemovePropertyCommand(editingDomain, input, property);
						executeCommand(command);
						refreshPropertiesViewer();
					}
				} else if (data.equals("providesService")) {
					Command command;
					if (providesButton.getSelection())
						command = CommandFactory.createAddProvidesCommand(editingDomain, input);
					else
						command = CommandFactory.createRemoveProvidesCommand(editingDomain, input);
					executeCommand(command);
				} else if (data.equals("browseClass")) {					
					try {
						IJavaElement[] javaElements = new IJavaElement[] { getJavaProject() };
						IJavaSearchScope scope = SearchEngine.createJavaSearchScope(javaElements,
						      IJavaSearchScope.SOURCES);
						SelectionDialog dialog = JavaUI.createTypeDialog(null, null, scope,
						      IJavaElementSearchConstants.CONSIDER_CLASSES, false);
						dialog.open();
						Object[] result = dialog.getResult();
						if (result.length > 0) {
							IType selectedClass = (IType) result[0];
							classNameText.setText(selectedClass.getFullyQualifiedName());
						}
					} catch (JavaModelException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Executes a EMF command
	 * @param command
	 */
	private void executeCommand(Command command) {
		ModelUtil.executeCommand(editor.getEditingDomain(), command);
	}
	
	/**
	 * Refreshes the dependencies viewer
	 */
	private void refreshDependenciesViewer() {
		if (input != null)
			dependenciesViewer.setInput(input.getRequires().toArray());
	}

	/**
	 * Refreshes the properties viewer
	 */
	private void refreshPropertiesViewer() {
		if (input != null)
			propertiesViewer.setInput(input.getProperties().get(0).getProperty().toArray());
	}
}
