/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.ui.editor.MetadataEditor;
import liglab.imag.fr.metadata.ui.editor.dialog.DependencyDialog;
import liglab.imag.fr.metadata.ui.editor.dialog.PropertyDialog;
import liglab.imag.fr.metadata.ui.editor.providers.DependencyLabelProvider;
import liglab.imag.fr.metadata.ui.editor.providers.PropertyLabelProvider;
import liglab.imag.fr.metadata.ui.editor.providers.SpecificationContentProvider;
import liglab.imag.fr.metadata.ui.editor.providers.SpecificationLabelProvider;
import liglab.imag.fr.metadata.util.JDTUtil;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.InstanceType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
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

/**
 * Component details definition page
 * 
 * @author Gabriel
 * 
 */
public class ComponentDetailsPage implements IDetailsPage {

	/**
	 * The form used to create GUI widgets
	 */
	private IManagedForm mform;

	/**
	 * The component type being modified by this page
	 */
	private ComponentType componentType;

	/**
	 * The editor (:S used only to refresh the component list)
	 */
	private MetadataEditor editor;

	/**
	 * Component name widget
	 */
	private Text nameText;

	/**
	 * Component class name widget
	 */
	private Text classNameText;
	
	/**
	 * Component invalidate method widget
	 */
	private Text invalidateText;

	/**
	 * Component validate method widget
	 */
	private Text validateText;
	
	/**
	 * The component list viewer (:S only to updated when the name changes) 
	 */
	private Viewer componentsViewer;

	/**
	 * The dependencies list viewer
	 */
	private TableViewer dependenciesViewer;

	/**
	 * The properties list viewer
	 */
	private TableViewer propertiesViewer;

	/**
	 * The specification list viewer
	 */
	private TreeViewer specificationsViewer;

	/**
	 * Text modify listener (actions on text widgets)
	 */
	private TextFieldModifyListener textFieldModifyListener;


	/**
	 * Default constructor
	 * @param editor
	 * @param componentsViewer
	 */
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
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#refresh()
	 */
	@Override
	public void refresh() {
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
			componentType = (ComponentType) ssel.getFirstElement();
		} else
			componentType = null;
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
		
		createGeneralSection(parent);
		createSpecificationsSection(parent);
		createDependenciesSection(parent);		
		createPropertiesSection(parent);
		createLifeCycleSection(parent);
		createImplementationSection(parent);

	}

	/**
	 * Creates the General section of component description (component name)
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

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}

	/**
	 * Creates the implementation section (classname)
	 * 
	 * @param parent
	 */
	private void createImplementationSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();

		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Component Type Implementation"); //$NON-NLS-1$
		s1.setDescription("Set or generate the component type implementation class."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);

		Composite client = toolkit.createComposite(s1);
		TableWrapLayout tableLayout = new TableWrapLayout();
		tableLayout.numColumns = 4;

		td.grabHorizontal = true;
		client.setLayout(tableLayout);

		Hyperlink link = toolkit.createHyperlink(client, "Implementation Class", SWT.WRAP);
		link.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				IJavaProject javaProject = JDTUtil.getCurrentJavaProject();
				String className = classNameText.getText();
				if (!className.isEmpty()) {
					IType selectedClass = null;
					try {
						selectedClass = javaProject.findType(className);
					} catch (JavaModelException e2) {
						e2.printStackTrace();
					}
					if (selectedClass != null) {
						JDTUtil.openJavaEditor(selectedClass);
					} else {
						MessageDialog.openWarning(null, "iCasa Environment", "The class " + className
						      + " does not exist");
					}
				}
			}
		});

		classNameText = toolkit.createText(client, "", SWT.SINGLE); //$NON-NLS-1$
		classNameText.setEditable(false);
		classNameText.addModifyListener(textFieldModifyListener);
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		classNameText.setLayoutData(td);

		ImplementationSelectionListener listener = new ImplementationSelectionListener();

		Button browseButton = toolkit.createButton(client, "Browse", SWT.FLAT);
		browseButton.setData("browseClass");
		browseButton.addSelectionListener(listener);

		Button clearButton = toolkit.createButton(client, "Clear", SWT.FLAT);
		clearButton.setData("clearClass");
		clearButton.addSelectionListener(listener);

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}

	/**
	 * Creates the Specification section of component description
	 * 
	 * @param parent
	 */
	private void createSpecificationsSection(Composite parent) {
		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
		      | Section.EXPANDED);
		s1.marginWidth = 10;
		s1.setText("Provided Services Specifications"); //$NON-NLS-1$
		s1.setDescription("Set the interfaces of the selected component."); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		s1.setLayoutData(td);

		Composite client = toolkit.createComposite(s1);
		TableWrapLayout glayout = new TableWrapLayout();
		glayout.makeColumnsEqualWidth = false;
		glayout.numColumns = 2;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		td.rowspan = 3;
		Tree tree = toolkit.createTree(client, SWT.V_SCROLL);
		tree.setLayoutData(td);

		SpecificationSelectionListener listener = new SpecificationSelectionListener();

		td = new TableWrapData(TableWrapData.FILL);
		Button addButton = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addButton.setData("addSpecification");
		addButton.addSelectionListener(listener);
		addButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editSpecification");
		editButton.addSelectionListener(listener);
		editButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteSpecification");
		deleteButton.addSelectionListener(listener);
		deleteButton.setLayoutData(td);

		specificationsViewer = new TreeViewer(tree);
		specificationsViewer.setContentProvider(new SpecificationContentProvider());
		specificationsViewer.setLabelProvider(new SpecificationLabelProvider());

		toolkit.paintBordersFor(s1);
		s1.setClient(client);

		// Adding menu to the specification view

		final MenuManager menuMng = new MenuManager();
		menuMng.setRemoveAllWhenShown(true);

		menuMng.addMenuListener(new IMenuListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse
			 * .jface.action.IMenuManager)
			 */
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) specificationsViewer.getSelection();
				if (!selection.isEmpty()) {
					// Add instance action is used on Component Types
					if (selection.getFirstElement() instanceof ProvidesType) {
						menuMng.add(new AddSpecificationProperty("Add property"));
						menuMng.add(new AddSpecificationInterface("Add interface"));
					}
					if (selection.getFirstElement() instanceof PropertyType) {
						menuMng.add(new RemoveSpecificationProperty("Delete property"));
					}
				}
			}
		});
		specificationsViewer.getControl().setMenu(menuMng.createContextMenu(specificationsViewer.getControl()));

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
		glayout.makeColumnsEqualWidth = false;
		glayout.numColumns = 2;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		td.rowspan = 3;
		Table table = toolkit.createTable(client, SWT.FULL_SELECTION);
		table.setLayoutData(td);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		PropertiesSelectionListener listener = new PropertiesSelectionListener();

		td = new TableWrapData(TableWrapData.FILL);
		Button addButton = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addButton.setData("addProperty");
		addButton.addSelectionListener(listener);
		addButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editProperty");
		editButton.addSelectionListener(listener);
		editButton.setLayoutData(td);

		td = new TableWrapData(TableWrapData.FILL);
		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteProperty");
		deleteButton.addSelectionListener(listener);
		deleteButton.setLayoutData(td);

		propertiesViewer = new TableViewer(table);
		propertiesViewer.setContentProvider(new ArrayContentProvider());
		//propertiesViewer.setLabelProvider(new ComponentElementsLabelProvider());
		
		TableViewerColumn nameCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		nameCol.getColumn().setWidth(80);
		nameCol.getColumn().setText("Name");
		nameCol.setLabelProvider(new PropertyLabelProvider(PropertyLabelProvider.NAME));

		TableViewerColumn fieldCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		fieldCol.getColumn().setWidth(100);
		fieldCol.getColumn().setText("Field");
		fieldCol.setLabelProvider(new PropertyLabelProvider(PropertyLabelProvider.FIELD));

		TableViewerColumn typeCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		typeCol.getColumn().setWidth(100);
		typeCol.getColumn().setText("Type");
		typeCol.setLabelProvider(new PropertyLabelProvider(PropertyLabelProvider.TYPE));

		TableViewerColumn valueCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		valueCol.getColumn().setWidth(100);
		valueCol.getColumn().setText("Value");
		valueCol.setLabelProvider(new PropertyLabelProvider(PropertyLabelProvider.VALUE));
		
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
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR
		      | Section.TWISTIE | Section.EXPANDED);
		section.marginWidth = 10;
		section.setText("Required Services"); //$NON-NLS-1$
		section.setDescription("Set the service dependencies of the selected component"); //$NON-NLS-1$

		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		td.grabHorizontal = true;
		section.setLayoutData(td);

		Composite client = toolkit.createComposite(section);
		TableWrapLayout glayout = new TableWrapLayout();
		glayout.makeColumnsEqualWidth = false;
		glayout.numColumns = 2;

		td.grabHorizontal = true;
		client.setLayout(glayout);

		td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.FILL_GRAB);
		Table table = toolkit.createTable(client, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		td.rowspan = 3;
		table.setLayoutData(td);

		DependenciesSelectionListener listener = new DependenciesSelectionListener();

		Button addButton = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addButton.setData("addDependency");
		addButton.addSelectionListener(listener);
		td = new TableWrapData(TableWrapData.FILL);
		addButton.setLayoutData(td);

		Button editButton = toolkit.createButton(client, "Edit", SWT.PUSH); //$NON-NLS-1$
		editButton.setData("editDependency");
		editButton.addSelectionListener(listener);
		td = new TableWrapData(TableWrapData.FILL);
		editButton.setLayoutData(td);

		Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
		deleteButton.setData("deleteDependency");
		deleteButton.addSelectionListener(listener);
		td = new TableWrapData(TableWrapData.FILL);
		deleteButton.setLayoutData(td);

		dependenciesViewer = new TableViewer(table);
		dependenciesViewer.setContentProvider(new ArrayContentProvider());
		// dependenciesViewer.setLabelProvider(new
		// ComponentElementsLabelProvider());

		TableViewerColumn nameCol = new TableViewerColumn(dependenciesViewer, SWT.NONE);
		nameCol.getColumn().setWidth(80);
		nameCol.getColumn().setText("Id");
		nameCol.setLabelProvider(new DependencyLabelProvider(DependencyLabelProvider.NAME));

		TableViewerColumn cardinalityCol = new TableViewerColumn(dependenciesViewer, SWT.NONE);
		cardinalityCol.getColumn().setWidth(100);
		cardinalityCol.getColumn().setText("Cardinality");
		cardinalityCol.setLabelProvider(new DependencyLabelProvider(DependencyLabelProvider.CARDINALITY));

		TableViewerColumn typeCol = new TableViewerColumn(dependenciesViewer, SWT.NONE);
		typeCol.getColumn().setWidth(200);
		typeCol.getColumn().setText("Type");
		typeCol.setLabelProvider(new DependencyLabelProvider(DependencyLabelProvider.TYPE));

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
		if (componentType != null) {

			removeListeners();

			nameText.setText(componentType.getName());

			classNameText.setText("");
			
			if (componentType.getClassname() != null)
				classNameText.setText(componentType.getClassname());

			specificationsViewer.setInput(componentType);

			dependenciesViewer.setInput(componentType.getRequires());

			List<PropertiesType> props = componentType.getProperties();
			if (props.size() > 0) {
				List<PropertyType> innerProps = props.get(0).getProperty();
				propertiesViewer.setInput(innerProps.toArray());
			} else {
				propertiesViewer.setInput(null);
			}

			validateText.setText("");
			invalidateText.setText("");
			CallbackType callback = ModelUtil.getValidateCallback(componentType);
			if (callback != null)
				validateText.setText(callback.getMethod());
			callback = ModelUtil.getInvalidateCallback(componentType);
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

	private String concatInterface(String list, String newInterface) {
		if (list.length() > 0)
			list = list + "," + newInterface;
		else
			list = newInterface;
		return list;
	}

	/**
	 * Executes a EMF command
	 * 
	 * @param command
	 */
	private void executeCommand(Command command) {
		ModelUtil.executeCommand(editor.getEditingDomain(), command);
	}

	/**
	 * Refreshes the dependencies viewer
	 */
	private void refreshDependenciesViewer() {
		if (componentType != null)
			dependenciesViewer.setInput(componentType.getRequires().toArray());
	}

	/**
	 * Refreshes the properties viewer
	 */
	private void refreshPropertiesViewer() {
		if (componentType != null)
			propertiesViewer.setInput(componentType.getProperties().get(0).getProperty().toArray());
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
			if (componentType != null) {
				EditingDomain editingDomain = editor.getEditingDomain();
				Command command = null;

				if (event.widget.equals(nameText)) {
					String componentNewName = nameText.getText();
					CompoundCommand compoundCommand = new CompoundCommand(); 
					Command aCommand = CommandFactory.createSetComponentNameCommand(editingDomain, componentType,
					      componentNewName);
					compoundCommand.append(aCommand);
					
					List<InstanceType> instances = ModelUtil.getInstances(componentType);
					for (InstanceType instance : instances) {
	               aCommand = CommandFactory.createSetInstanceComponentNameCommand(editingDomain, instance, componentNewName);
	               compoundCommand.append(aCommand);
               }
					
					command = compoundCommand;
					
				} else if (event.widget.equals(classNameText)) {
					command = CommandFactory.createSetComponentClassCommand(editingDomain, componentType,
					      classNameText.getText());
				} else if (event.widget.equals(validateText)) {
					command = CommandFactory.createSetValidateTransitionCommand(editingDomain, componentType,
					      validateText.getText());
				} else if (event.widget.equals(invalidateText)) {
					command = CommandFactory.createSetInvalidateTransitionCommand(editingDomain, componentType,
					      invalidateText.getText());
				}
				if (command != null)
					executeCommand(command);
				if (event.widget.equals(nameText))
					componentsViewer.refresh();
			}
		}
	}

	class DependenciesSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {
			if (componentType != null) {
				String data = (String) event.widget.getData();
				EditingDomain editingDomain = editor.getEditingDomain();

				if (data.equals("addDependency")) {
					DependencyDialog dialog = new DependencyDialog(editingDomain, null);
					if (dialog.open() == Window.OK) {
						Command command = CommandFactory.createAddRequirementCommand(editingDomain, componentType,
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
						Command command = CommandFactory.createRemoveRequirementCommand(editingDomain, componentType,
						      requirement);
						executeCommand(command);
						refreshDependenciesViewer();
					}
				}
			}
		}
	}

	class PropertiesSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {
			if (componentType != null) {
				String data = (String) event.widget.getData();
				EditingDomain editingDomain = editor.getEditingDomain();

				if (data.equals("addProperty")) {
					PropertyDialog dialog = new PropertyDialog(editingDomain, null, true);
					if (dialog.open() == Window.OK) {
						Command command = CommandFactory.createAddPropertyCommand(editingDomain, componentType,
						      dialog.getProperty());
						executeCommand(command);
						refreshPropertiesViewer();
					}
				} else if (data.equals("editProperty")) {
					IStructuredSelection selection = (IStructuredSelection) propertiesViewer.getSelection();
					if (selection.size() > 0) {
						PropertyType property = (PropertyType) selection.getFirstElement();
						PropertyDialog dialog = new PropertyDialog(editingDomain, property, true);
						if (dialog.open() == Window.OK) {
							refreshPropertiesViewer();
							//propertiesViewer.setInput(input.getProperties().get(0).getProperty().toArray());
							//editor.fireDirtyProperty();
						}
					}
				} else if (data.equals("deleteProperty")) {
					IStructuredSelection selection = (IStructuredSelection) propertiesViewer.getSelection();
					if (selection.size() > 0) {
						PropertyType property = (PropertyType) selection.getFirstElement();
						Command command = CommandFactory
						      .createRemovePropertyCommand(editingDomain, componentType, property);
						executeCommand(command);
						refreshPropertiesViewer();
					}
				}
			}
		}
	}

	class ImplementationSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {
			if (componentType != null) {
				String data = (String) event.widget.getData();
				// EditingDomain editingDomain = editor.getEditingDomain();
				if (data.equals("clearClass")) {
					classNameText.setText("");
				} else if (data.equals("browseClass")) {
					IType selectedType = JDTUtil.openSearchJDTDialog(IJavaSearchScope.SOURCES,
					      IJavaElementSearchConstants.CONSIDER_CLASSES, false);
					if (selectedType != null)
						classNameText.setText(selectedType.getFullyQualifiedName());
				}
			}
		}
	}

	class SpecificationSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {
			if (componentType != null) {
				String data = (String) event.widget.getData();
				EditingDomain editingDomain = editor.getEditingDomain();
				if (data.equals("addSpecification")) {
					IType selectedType = JDTUtil.openSearchJDTDialog(IJavaSearchScope.SOURCES
					      | IJavaSearchScope.APPLICATION_LIBRARIES | IJavaSearchScope.REFERENCED_PROJECTS,
					      IJavaElementSearchConstants.CONSIDER_INTERFACES, true);
					if (selectedType != null) {
						String spec = selectedType.getFullyQualifiedName();
						Command command = CommandFactory.createAddProvidesCommand(editingDomain, componentType, spec);
						executeCommand(command);
						specificationsViewer.refresh(false);
					}
				} else if (data.equals("editSpecification")) {
					IStructuredSelection selection = (IStructuredSelection) specificationsViewer.getSelection();
					if (selection.size() > 0) {
						Object element = selection.getFirstElement();
						if (element instanceof PropertyType) {
							PropertyType property = (PropertyType) element;
							PropertyDialog dialog = new PropertyDialog(editingDomain, property, false);
							if (dialog.open() == Window.OK) {
								specificationsViewer.refresh();
							}
						}
					}
					
				} else if (data.equals("deleteSpecification")) {
					IStructuredSelection selection = (IStructuredSelection) specificationsViewer.getSelection();
					if (selection.size() > 0) {
						Object element = selection.getFirstElement();
						if (element instanceof ProvidesType) {
							ProvidesType provides = (ProvidesType) element;
							Command command = CommandFactory.createRemoveProvidesCommand(editingDomain, provides);
							executeCommand(command);
							specificationsViewer.refresh(false);
						}
						if (element instanceof PropertyType) {
							PropertyType property = (PropertyType) element;
							Command command = CommandFactory.createRemoveSpecPropertyCommand(editingDomain, property);
							executeCommand(command);
							specificationsViewer.refresh(false);
						}
					}
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
	class ButtonSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent event) {

			if (componentType != null) {
				String data = (String) event.widget.getData();
				EditingDomain editingDomain = editor.getEditingDomain();
				if (data.equals("addInterface")) {

					IType selectedType = JDTUtil.openSearchJDTDialog(IJavaSearchScope.SOURCES
					      | IJavaSearchScope.APPLICATION_LIBRARIES | IJavaSearchScope.REFERENCED_PROJECTS,
					      IJavaElementSearchConstants.CONSIDER_INTERFACES, true);

					if (selectedType != null) {

						String specsStr = "";

						// List<String> specsList = (List<String>)
						// interfacesViewer.getInput();
						List<String> specsList = new ArrayList<String>();
						for (String spec : specsList)
							specsStr = concatInterface(specsStr, spec);
						specsStr = concatInterface(specsStr, selectedType.getFullyQualifiedName());

						Command command = CommandFactory.createAddSpecification(editingDomain, componentType, specsStr);
						executeCommand(command);

						List<String> specs = Arrays.asList(specsStr.split("\\s*,\\s*"));

					}

				} else if (data.equals("deleteInterface")) {

					//String interfaze = (String) selection.getFirstElement();
					String interfaze = "";
					// List<String> specsListRO = (List<String>)
					// interfacesViewer.getInput();
					List<String> specsListRO = new ArrayList<String>();
					ArrayList<String> specsList = new ArrayList<String>(specsListRO);
					specsList.remove(interfaze);

					String specsStr = "";
					for (String spec : specsList) {
						specsStr = concatInterface(specsStr, spec);
					}

					Command command = CommandFactory.createAddSpecification(editingDomain, componentType, specsStr);
					executeCommand(command);

					List<String> specs = Arrays.asList(specsStr.split("\\s*,\\s*"));
					// interfacesViewer.setInput(specs);

				}
			}
		}
	}

	class AddSpecificationProperty extends Action {

		public AddSpecificationProperty(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) specificationsViewer.getSelection();
			if (!selection.isEmpty()) {
				if (selection.getFirstElement() instanceof ProvidesType) {
					ProvidesType provides = (ProvidesType) selection.getFirstElement();
					EditingDomain editingDomain = editor.getEditingDomain();
					PropertyDialog dialog = new PropertyDialog(editingDomain, null, false);
					if (dialog.open() == Window.OK) {
						PropertyType prop = dialog.getProperty();
						Command command = CommandFactory
						      .createAddSpecPropertyCommand(editingDomain, provides, prop);
						executeCommand(command);
						specificationsViewer.refresh(false);
					}
				}
			}
		}
	}

	class RemoveSpecificationProperty extends Action {

		public RemoveSpecificationProperty(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) specificationsViewer.getSelection();
			if (!selection.isEmpty()) {
				if (selection.getFirstElement() instanceof PropertyType) {
					PropertyType property = (PropertyType) selection.getFirstElement();

					EditingDomain editingDomain = editor.getEditingDomain();
					Command command = CommandFactory.createRemoveSpecPropertyCommand(editingDomain, property);
					executeCommand(command);
					specificationsViewer.refresh(false);
				}
			}
		}
	}

	class AddSpecificationInterface extends Action {

		public AddSpecificationInterface(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) specificationsViewer.getSelection();
			if (!selection.isEmpty()) {
				if (selection.getFirstElement() instanceof ProvidesType) {
					ProvidesType provides = (ProvidesType) selection.getFirstElement();
					EditingDomain editingDomain = editor.getEditingDomain();

					IType selectedType = JDTUtil.openSearchJDTDialog(IJavaSearchScope.SOURCES
					      | IJavaSearchScope.APPLICATION_LIBRARIES | IJavaSearchScope.REFERENCED_PROJECTS,
					      IJavaElementSearchConstants.CONSIDER_INTERFACES, true);
					if (selectedType != null) {
						String newInterface = selectedType.getFullyQualifiedName();
						String interfaces = provides.getSpecifications() + "," + newInterface;

						Command command = CommandFactory.createSetInterfacesProvidesCommand(editingDomain,
						      provides, interfaces);
						executeCommand(command);
						specificationsViewer.refresh();
					}
				}
			}
		}
	}

}
