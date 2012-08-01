package liglab.imag.fr.metadata.model.old;

import java.util.ArrayList;
import java.util.List;

public class PojoModel {
	
	//private boolean modified;

	private List<Component> components;

	public PojoModel() {
		components = new ArrayList<Component>();
	}

	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void removeComponent(Component component) {
		components.remove(component);
	}
	
	/**
    * @return the components
    */
   public List<Component> getComponents() {
   	return components;
   }
	
   
   public Object[] getContents() {
   	return components.toArray();
   }
	

	
}
