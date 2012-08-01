/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.instance;

import java.util.List;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.ui.editor.MetadataEditor;
import liglab.imag.fr.metadata.ui.editor.dialog.PropertyDialog;

import org.apache.felix.ComponentType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.RequiresType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

/**
 * @author Gabriel
 * 
 */
public class InstanceDetailsPage implements IDetailsPage {

	private IManagedForm mform;

	private Text nameText;

	//private Text classNameText;

	private Button providesButton;


	private Viewer componentsViewer;

	private TableViewer propertiesViewer;

	private ComponentType input;

	// private IType selectedClass;


	private MetadataEditor editor;

	private ComponentModifyListener componentModifyListener;

	private ComponentSelectionListener componentSelectionListener;

	public InstanceDetailsPage(MetadataEditor editor, Viewer componentsViewer) {
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
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#isDirty()
	 */
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#commit(boolean)
	 */
	@Override
	public void commit(boolean onSave) {
		// TODO Auto-generated method stub
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

		//componentModifyListener = new ComponentModifyListener();
		//componentSelectionListener = new ComponentSelectionListener();
		//createGeneralSection(parent);
		//createPropertiesSection(parent);
		



	}

	private void createGeneralSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Component Details"); //$NON-NLS-1$
		s1.setDescription("Set the description of the selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		// td.grabHorizontal = true;
		// s1.setLayoutData(td);

		Composite client = toolkit.createComposite(s1);
		TableWrapLayout tableLayout = new TableWrapLayout();
		// tableLayout.makeColumnsEqualWidth = true;
		tableLayout.numColumns = 3;

		td.grabHorizontal = true;
		client.setLayout(tableLayout);

		toolkit.createLabel(client, "Component Name"); //$NON-NLS-1$

		td = new TableWrapData(TableWrapData.FILL_GRAB);
		nameText = toolkit.createText(client, "", SWT.SINGLE); //$NON-NLS-1$		
		nameText.addModifyListener(componentModifyListener);
		nameText.setLayoutData(td);

		providesButton = toolkit.createButton(client, "OSGi Service Provision", SWT.CHECK);
		providesButton.setData("providesService");
		providesButton.addSelectionListener(componentSelectionListener);

		Hyperlink link = toolkit.createHyperlink(client, "Implementation Class", SWT.WRAP);
		
		/*
		link.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				IJavaProject javaProject = getJavaProject();
				if (!classNameText.getText().equals("")) {

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
		*/
		

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}

	private void createPropertiesSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
		      | Section.EXPANDED);
		s1.marginWidth = 10;
		s1.setText("Component Properties"); //$NON-NLS-1$
		s1.setDescription("Set the properties of the selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		// td.grabHorizontal = true;
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
		addButton.addSelectionListener(componentSelectionListener);
		addButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editProperty");
		editButton.addSelectionListener(componentSelectionListener);
		editButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteProperty");
		deleteButton.addSelectionListener(componentSelectionListener);
		deleteButton.setLayoutData(td);

		propertiesViewer = new TableViewer(t);
		propertiesViewer.setContentProvider(new ArrayContentProvider());
		propertiesViewer.setLabelProvider(new ComponentLabelProvider());

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}

	/*
	private void createRequirementSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
		      | Section.EXPANDED);
		s1.marginWidth = 10;
		s1.setText("Component Requirements"); //$NON-NLS-1$
		s1.setDescription("Set the requirements of the selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		td.grabHorizontal = true;
		s1.setLayoutData(td);

		Composite client = toolkit.createComposite(s1);
		TableWrapLayout glayout = new TableWrapLayout();
		glayout.makeColumnsEqualWidth = true;
		glayout.numColumns = 2;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		Table t = toolkit.createTable(client, SWT.NULL);
		td.rowspan = 4;
		t.setLayoutData(td);

		Button addButton = toolkit.createButton(client, "Add (Field)", SWT.PUSH); //$NON-NLS-1$
		addButton.setData("addFieldRequirement");
		addButton.addSelectionListener(componentSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		addButton.setLayoutData(td);

		Button addMButton = toolkit.createButton(client, "Add (Method)", SWT.PUSH); //$NON-NLS-1$
		addMButton.setData("addMethodRequirement");
		addMButton.addSelectionListener(componentSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		addMButton.setLayoutData(td);

		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editRequirement");
		editButton.addSelectionListener(componentSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		editButton.setLayoutData(td);

		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteRequirement");
		deleteButton.addSelectionListener(componentSelectionListener);
		td = new TableWrapData(TableWrapData.FILL);
		deleteButton.setLayoutData(td);

		requirementsViewer = new TableViewer(t);
		requirementsViewer.setContentProvider(new ArrayContentProvider());
		requirementsViewer.setLabelProvider(new ComponentLabelProvider());

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}
	*/

	/*
	private void createLifeCycleSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Component Lifecycle Callbacks"); //$NON-NLS-1$
		s1.setDescription("Set Component lifecycle callbacks of selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		td.grabHorizontal = true;
		s1.setLayoutData(td);

		Composite client = toolkit.createComposite(s1);
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
		validateText.addModifyListener(componentModifyListener);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		Label invalidateLabel = toolkit.createLabel(client, "invalidate");
		invalidateLabel.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		invalidateText = toolkit.createText(client, "");
		invalidateText.setLayoutData(td);
		invalidateText.addModifyListener(componentModifyListener);

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}
  */
	
	private void update() {
		/*
		if (input != null) {

			removeListeners();

			nameText.setText(input.getName());
			
			
			providesButton.setSelection(!input.getProvides().isEmpty());

			//requirementsViewer.setInput(input.getRequires());

			List<PropertiesType> props = input.getProperties();
			if (props.size() > 0) {
				List<PropertyType> innerProps = props.get(0).getProperty();
				propertiesViewer.setInput(innerProps.toArray());
			} else {
				propertiesViewer.setInput(null);
			}

			addListeners();
		}
		*/
	}

	private void removeListeners() {
		nameText.removeModifyListener(componentModifyListener);
	}

	private void addListeners() {
		nameText.addModifyListener(componentModifyListener);
	}

	/*
	private IJavaProject getJavaProject() {
		IFileEditorInput editorInputFile = (IFileEditorInput) PlatformUI.getWorkbench()
		      .getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();
		IJavaProject javaProject = JavaCore.create(editorInputFile.getFile().getProject());
		return javaProject;
	}

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
	
	*/
	
	/*

	private IType openCreateJavaClassWizard(String qualifiedClassName, IJavaProject javaProject) {
		OpenNewClassWizardAction wizardAction = new OpenNewClassWizardAction();
		String className = "";
		NewClassWizardPage wizardPage = new NewClassWizardPage();

		if (qualifiedClassName != null && qualifiedClassName.length() > 0) {
			className = getJavaClassName(qualifiedClassName);
			wizardPage.setTypeName(className, true);
		}

		try {
			wizardPage.setPackageFragmentRoot(javaProject.getAllPackageFragmentRoots()[0], true);
		} catch (JavaModelException e1) {
			e1.printStackTrace();
		}
		wizardAction.setConfiguredWizardPage(wizardPage);
		wizardAction.run();
		IType newClass = (IType) wizardAction.getCreatedElement();
		return newClass;
	}

	private String getJavaClassName(String qualifiedClassName) {
		String className = "";
		// String name = implementationText.getText();
		if (qualifiedClassName.lastIndexOf('.') > 0) {
			className = qualifiedClassName.substring(qualifiedClassName.lastIndexOf('.') + 1); // Map$Entry
		}
		// The $ can be converted to a .
		className = className.replace('$', '.');
		return className;
	}

	*/

	private boolean isFieldRequirement(RequiresType requirement) {
		return requirement.getCallback().isEmpty();
	}

	class ComponentLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof RequiresType) {
				RequiresType requirement = (RequiresType) element;
				if (isFieldRequirement(requirement)) {
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

	class ComponentModifyListener implements ModifyListener {

		@Override
		public void modifyText(ModifyEvent event) {
			if (input != null) {
				EditingDomain editingDomain = editor.getEditingDomain();
				if (event.widget.equals(nameText)) {
					Command command = CommandFactory.createSetComponentNameCommand(editingDomain, input,
					      nameText.getText());
					executeCommand(command);
					componentsViewer.refresh();
				}
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
	class ComponentSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {
			if (input != null) {
				String data = (String) event.widget.getData();
				EditingDomain editingDomain = editor.getEditingDomain();
				if (data.equals("addProperty")) {
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
					// input.setProvides(providesButton.getSelection());
					editor.fireDirtyProperty();
				}

			}
		}
	}

	private void executeCommand(Command command) {
		ModelUtil.executeCommand(editor.getEditingDomain(), command);		
	}


	private void refreshPropertiesViewer() {
		if (input != null)
			propertiesViewer.setInput(input.getProperties().get(0).getProperty().toArray());
	}
}
