/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.providers;

import java.util.ArrayList;
import java.util.List;

import liglab.imag.fr.metadata.emf.InstanceTypeItemProvider;
import liglab.imag.fr.metadata.emf.ModelUtil;

import org.apache.felix.ComponentType;
import org.apache.felix.InstanceType;
import org.apache.felix.IpojoType;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Gabriel
 *
 */
public class InstanceContentProvider implements ITreeContentProvider {

	//private MetadataEditor editor;
		
	public InstanceContentProvider() {
	   //this.editor = editor;
   }

	private static Object[] EMPTY_ARRAY = new Object[0];
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IpojoType) {
			IpojoType pojoModel = (IpojoType) parentElement;
			return pojoModel.getComponent().toArray();
      }
		if (parentElement instanceof ComponentType) {
	      ComponentType component = (ComponentType) parentElement;
	      List<InstanceType> instances = ModelUtil.getInstances(component);
	      List<InstanceTypeItemProvider> newInstances = new ArrayList<InstanceTypeItemProvider>();
	      for (InstanceType instance : instances) {
	      	newInstances.add(new InstanceTypeItemProvider(instance));
         }
	      return newInstances.toArray();	      
      }
		return EMPTY_ARRAY;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		if (element instanceof InstanceTypeItemProvider) {
			InstanceTypeItemProvider instanceItemProvider = (InstanceTypeItemProvider) element;
	      return ModelUtil.getComponentFromInstance(instanceItemProvider.getInstance());
      }
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ComponentType) {
	      ComponentType component = (ComponentType) element;
	      List<InstanceType> list = ModelUtil.getInstances(component);
	      return (list.size()>0);
      }
		return false;
	}

}
