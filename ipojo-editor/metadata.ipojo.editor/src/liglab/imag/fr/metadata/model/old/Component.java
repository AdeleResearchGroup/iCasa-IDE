package liglab.imag.fr.metadata.model.old;

import java.util.ArrayList;
import java.util.List;

public class Component {
	private String name;
	private String classname;

	private boolean provides;
	
	private String validate;
	
	private String invalidate;

	private List<Requirement> requirements;
	private List<MethodRequirement> methodRequirements;
	private List<Property> properties;

	public Component(String name, String classname) {
		super();
		this.name = name;
		this.classname = classname;
		requirements = new ArrayList<Requirement>();
		properties = new ArrayList<Property>();
		methodRequirements = new ArrayList<MethodRequirement>();
		validate = null;
		invalidate = null;
	}

	public Component() {
		this(null, null);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * @param classname
	 *           the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/**
	 * @return the provides
	 */
	public boolean isProvides() {
		return provides;
	}

	/**
	 * @param provides
	 *           the provides to set
	 */
	public void setProvides(boolean provides) {
		this.provides = provides;
	}

	public void addRequirement(Requirement requirement) {
		requirements.add(requirement);
	}

	public void removeRequirement(Requirement requirement) {
		requirements.remove(requirement);
	}
	
	public void addMethodRequirement(MethodRequirement requirement) {
		methodRequirements.add(requirement);
	}

	public void removeMethodRequirement(MethodRequirement requirement) {
		methodRequirements.remove(requirement);
	}

	public void addProperty(Property property) {
		properties.add(property);
	}

	public void removeProperty(Property property) {
		properties.remove(property);
	}

	/**
	 * @return the requirements
	 */
	public List<Requirement> getRequirements() {
		return requirements;
	}

	/**
	 * @return the properties
	 */
	public List<Property> getProperties() {
		return properties;
	}

	/**
    * @return the methodRequirements
    */
   public List<MethodRequirement> getMethodRequirements() {
   	return methodRequirements;
   }

	/**
    * @return the validate
    */
   public String getValidate() {
   	return validate;
   }

	/**
    * @param validate the validate to set
    */
   public void setValidate(String validate) {
   	this.validate = validate;
   }

	/**
    * @return the invalidate
    */
   public String getInvalidate() {
   	return invalidate;
   }

	/**
    * @param invalidate the invalidate to set
    */
   public void setInvalidate(String invalidate) {
   	this.invalidate = invalidate;
   }

   
   
}
