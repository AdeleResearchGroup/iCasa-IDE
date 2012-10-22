package liglab.imag.fr.metadata.ui.editor.providers;

import liglab.imag.fr.metadata.editor.ComponentEditorPlugin;
import liglab.imag.fr.metadata.emf.InstanceTypeItemProvider;

import org.apache.felix.ComponentType;
import org.apache.felix.InstanceType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class ComponentLabelProvider extends LabelProvider {

	private Image componentImage;
	private Image instanceImage;
	
	
	
	public ComponentLabelProvider() {
	   super();
	   ImageDescriptor descriptor = ComponentEditorPlugin.getDefault().getImageRegistry().getDescriptor(ComponentEditorPlugin.IMG_COMPONENT);
	   componentImage = descriptor.createImage();
	   descriptor = ComponentEditorPlugin.getDefault().getImageRegistry().getDescriptor(ComponentEditorPlugin.IMG_INSTANCE);
	   instanceImage = descriptor.createImage();
   }

	@Override
	public Image getImage(Object element) {
		if (element instanceof ComponentType)
			return componentImage;		
		if (element instanceof InstanceType)
			return instanceImage;
		if (element instanceof InstanceTypeItemProvider)
			return instanceImage;
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ComponentType) {
			ComponentType component = (ComponentType) element;
			return component.getName();
		}
		if (element instanceof InstanceType) {
	      InstanceType instance = (InstanceType) element;
	      String name = instance.getName();
	      if (name!=null)
	      	return name;
	      return "no-name";
      }
		if (element instanceof InstanceTypeItemProvider) {
			InstanceTypeItemProvider instanceItemProvider = (InstanceTypeItemProvider) element;
	      String name = instanceItemProvider.getInstance().getName();
	      if (name!=null)
	      	return name;
	      return "no-name";
      }		
		return null;
	}

	
	
}
