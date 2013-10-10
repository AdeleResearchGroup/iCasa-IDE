/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.instance;

import liglab.imag.fr.metadata.emf.InstanceTypeItemProvider;
import liglab.imag.fr.metadata.util.PropertyEditingSupport;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.views.properties.IPropertyDescriptor;


/**
 * @author Gabriel
 * 
 */
public class InstanceDetailsPage implements IDetailsPage {

	private IManagedForm mform;

	private TreeViewer componentsViewer;

	private TableViewer propertiesViewer;

	private InstanceTypeItemProvider input;
	
	private PropertyEditingSupport myEditingSupport;

	public InstanceDetailsPage(TreeViewer componentsViewer) {
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
			input = (InstanceTypeItemProvider) ssel.getFirstElement();
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

		createPropertiesSection(parent);
	}

	

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
		glayout.numColumns = 1;

		td.grabHorizontal = true;
		client.setLayout(glayout);


		Table table = toolkit.createTable(client, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		table.setLayoutData(td);

		propertiesViewer = new TableViewer(table);
		propertiesViewer.setContentProvider(new ArrayContentProvider());
			
		TableViewerColumn propertyCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		propertyCol.getColumn().setWidth(250);
		propertyCol.getColumn().setText("Property");
		propertyCol.setLabelProvider(new ColumnLabelProvider(){
			
			@Override
			public String getText(Object element) {
				if (element instanceof IPropertyDescriptor) {
	            IPropertyDescriptor propertyDescriptor = (IPropertyDescriptor) element;
	            return propertyDescriptor.getDisplayName();
            }
				return null;
			}
		});
				
		
		TableViewerColumn valueCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		valueCol.getColumn().setWidth(250);
		valueCol.getColumn().setText("Value");
		valueCol.setLabelProvider(new ColumnLabelProvider(){
			
			@Override
			public String getText(Object element) {
				if (element instanceof IPropertyDescriptor) {
					IPropertyDescriptor propertyDescriptor = (IPropertyDescriptor) element;
					return (String) input.getPropertyValue(propertyDescriptor.getId());
            }
				return null;
			}
			
		});
		
		myEditingSupport = new PropertyEditingSupport(propertiesViewer, input, componentsViewer);
		valueCol.setEditingSupport(myEditingSupport);
		
		TableViewerColumn descriptionCol = new TableViewerColumn(propertiesViewer, SWT.NONE);
		descriptionCol.getColumn().setWidth(250);
		descriptionCol.getColumn().setText("Type");
		descriptionCol.setLabelProvider(new ColumnLabelProvider(){
			
			@Override
			public String getText(Object element) {
				if (element instanceof IPropertyDescriptor) {
					IPropertyDescriptor propertyDescriptor = (IPropertyDescriptor) element;
					return propertyDescriptor.getDescription();
            }
				return null;
			}
			
		});

		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}
	
	
	private void update() {		
		propertiesViewer.setInput(input.getPropertyDescriptors());
		myEditingSupport.setInstanceProvider(input);		
	}
	

}
