package liglab.imag.fr.metadata.util;

import liglab.imag.fr.metadata.emf.InstanceTypeItemProvider;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class PropertyEditingSupport extends EditingSupport {

	private InstanceTypeItemProvider instanceProvider;
	private TreeViewer componentViewer;

	public PropertyEditingSupport(TableViewer viewer, InstanceTypeItemProvider instanceProvider, TreeViewer componentViewer) {
		super(viewer);
		this.instanceProvider = instanceProvider;
		this.componentViewer = componentViewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof IPropertyDescriptor) {
			IPropertyDescriptor propertyDescriptor = (IPropertyDescriptor) element;
			return propertyDescriptor.createPropertyEditor((Composite) getViewer().getControl());
		}
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof IPropertyDescriptor) {
			IPropertyDescriptor propertyDescriptor = (IPropertyDescriptor) element;
			if (instanceProvider!=null)
				return instanceProvider.getPropertyValue(propertyDescriptor.getId());
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof IPropertyDescriptor) {
			IPropertyDescriptor propertyDescriptor = (IPropertyDescriptor) element;
			if (instanceProvider!=null) {
				instanceProvider.setPropertyValue(propertyDescriptor.getId(), value);
				getViewer().refresh();
				componentViewer.update(instanceProvider, null);
				//ISelection selection = componentViewer.getSelection();
				//componentViewer.refresh();
				//componentViewer.setSelection(selection);
			}
		}
	}

	public void setInstanceProvider(InstanceTypeItemProvider instanceProvider) {
   	this.instanceProvider = instanceProvider;
   }
		
}
