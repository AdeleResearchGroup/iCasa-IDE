/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor;

import java.util.List;

import liglab.imag.fr.metadata.editor.ComponentEditorPlugin;
import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.ui.editor.providers.ComponentLabelProvider;

import org.apache.felix.ComponentType;
import org.apache.felix.InstanceType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * Base class for the Master-Details Block using the component list as master
 * 
 * @author Gabriel
 * 
 */
public abstract class PojoMasterDetailBlock extends MasterDetailsBlock {

	protected FormPage page;

	protected TreeViewer componentsViewer;

	protected MetadataEditor editor;

	private SashForm form;

	public PojoMasterDetailBlock(MetadataEditor editor, FormPage page) {
		this.page = page;
		this.editor = editor;
	}

	@Override
	public void createContent(IManagedForm managedForm) {
		super.createContent(managedForm);
		// List component has 30% of space and details have 70%
		form.setWeights(new int[] { 3, 7 });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.MasterDetailsBlock#createMasterPart(org.eclipse.ui
	 * .forms.IManagedForm, org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		// final ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText(getPanelTitle()); //$NON-NLS-1$
		section.setDescription(getPanelMessage()); //$NON-NLS-1$
		section.marginWidth = 10;
		section.marginHeight = 5;

		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;

		client.setLayout(layout);
		Tree tree = toolkit.createTree(client, SWT.NULL);

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 20;
		gd.widthHint = 140;
		gd.verticalSpan = 2;

		tree.setLayoutData(gd);

		if (addEditionButtons()) {

			AddRemoveSelectionListener listener = new AddRemoveSelectionListener();

			Button addButton = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
			addButton.setData("add");
			addButton.addSelectionListener(listener);
			gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
			addButton.setLayoutData(gd);

			Button deleteButton = toolkit.createButton(client, "Delete", SWT.PUSH); //$NON-NLS-1$
			deleteButton.setData("remove");
			deleteButton.addSelectionListener(listener);
			gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
			deleteButton.setLayoutData(gd);
		}

		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);
		componentsViewer = new TreeViewer(tree);
		componentsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});
		componentsViewer.setContentProvider(getContentProvider());
		componentsViewer.setLabelProvider(new ComponentLabelProvider());
		MetadataEditor editor = (MetadataEditor) page.getEditor();
		componentsViewer.setInput(editor.getModel());

		toolkit.paintBordersFor(client);

		form = (SashForm) parent;

		page.getEditorSite().setSelectionProvider(componentsViewer);

		addContextMenu();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.MasterDetailsBlock#createToolBarActions(org.eclipse
	 * .ui.forms.IManagedForm)
	 */
	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		Action haction = new Action("hor", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText("Horizontal orientation"); //$NON-NLS-1$
		haction.setImageDescriptor(ComponentEditorPlugin.getDefault().getImageRegistry()
		      .getDescriptor(ComponentEditorPlugin.IMG_HORIZONTAL));
		Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText("Vertical orientation");
		vaction.setImageDescriptor(ComponentEditorPlugin.getDefault().getImageRegistry()
		      .getDescriptor(ComponentEditorPlugin.IMG_VERTICAL));
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}

	public void refreshComponentList() {
		if (componentsViewer != null)
			componentsViewer.refresh();
	}

	/**
	 * Subclasses have to define if editions buttons (Add, Delete) are available
	 * 
	 * @return true if buttons are available, false if not
	 */
	protected abstract boolean addEditionButtons();

	/**
	 * Subclasses have to define the message to be shown in the panel
	 * 
	 * @return
	 */
	protected abstract String getPanelMessage();

	/**
	 * Subclasses have to define the title to be shown in the panel
	 * 
	 * @return
	 */
	protected abstract String getPanelTitle();

	/**
	 * Subclasses have to provide the content provider use in the table
	 * 
	 * @return
	 */
	public abstract IContentProvider getContentProvider();

	/**
	 * Defines the context menu used in the component list
	 */
	protected abstract void addContextMenu();

	class AddRemoveSelectionListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent event) {
			String data = (String) event.widget.getData();
			EditingDomain editingDomain = editor.getEditingDomain();

			if (data.equals("add")) {
				MetadataEditor editor = (MetadataEditor) page.getEditor();
				Command command = CommandFactory.createAddComponentTypeCommand(editingDomain, editor.getModel());
				ModelUtil.executeCommand(editingDomain, command);
				componentsViewer.refresh();
			} else if (data.equals("remove")) {
				IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
				if (!selection.isEmpty()) {
					ComponentType componentType = (ComponentType) selection.getFirstElement();

					boolean eliminateConfirmation = true;
					List<InstanceType> instances = ModelUtil.getInstances(componentType);
					if (!instances.isEmpty()) {
						String message = componentType.getName()
						      + " component type has almost one instance defined, are you sure of remove it?";
						eliminateConfirmation = MessageDialog.openQuestion(null, "Remove Component Type Confirmation",
						      message);
					}

					if (eliminateConfirmation) {
						CompoundCommand command = new CompoundCommand();
						Command aCommand = CommandFactory.createRemoveComponentTypeCommand(editingDomain, componentType);
						command.append(aCommand);						
						for (InstanceType instance : instances) {
		               aCommand = CommandFactory.createRemoveInstanceCommand(editingDomain, instance);
		               command.append(aCommand);
	               }
						ModelUtil.executeCommand(editingDomain, command);
						componentsViewer.refresh();
					}
				}
			}
		}
	}

}
