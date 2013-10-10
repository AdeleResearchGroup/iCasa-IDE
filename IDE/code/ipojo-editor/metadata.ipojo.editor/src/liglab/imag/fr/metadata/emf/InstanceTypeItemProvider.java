package liglab.imag.fr.metadata.emf;

import java.util.ArrayList;
import java.util.List;

import org.apache.felix.ComponentType;
import org.apache.felix.FelixFactory;
import org.apache.felix.InstancePropertyType;
import org.apache.felix.InstanceType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * A wrapper class to provide properties information to properties view
 * 
 * @author Gabriel
 * 
 */
public class InstanceTypeItemProvider implements IPropertySource2 {

	private InstanceType instance;

	private static String INSTANCE_NAME = "instance.name";

	public InstanceTypeItemProvider(InstanceType instance) {
		this.instance = instance;
	}

	@Override
	public Object getEditableValue() {
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		List<PropertyDescriptor> descriptors = new ArrayList<PropertyDescriptor>();
		TextPropertyDescriptor nameDescriptor = new TextPropertyDescriptor(INSTANCE_NAME, "Instance Name");
		nameDescriptor.setDescription("Name");
		descriptors.add(nameDescriptor);

		ComponentType component = ModelUtil.getComponentFromInstance(instance);

		// Configuration Properties
		if (component.getProperties().size() > 0) {
			PropertiesType propertiesType = component.getProperties().get(0);
			List<PropertyType> properties = propertiesType.getProperty();
			for (PropertyType propertyType : properties) {
				descriptors.add(createDescriptor(propertyType.getName(), "Configuration"));
			}
		}

		// Services Properties
		List<ProvidesType> providesList = component.getProvides();
		for (ProvidesType provides : providesList) {
			List<PropertyType> properties = provides.getProperty();
			for (PropertyType propertyType : properties) {
				descriptors.add(createDescriptor(propertyType.getName(), "Service"));
			}
		}

		return descriptors.toArray(new IPropertyDescriptor[] {});
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(INSTANCE_NAME)) {
			String instName = instance.getName();
			if (instName != null)
				return instName;
			return "";
		}
		InstancePropertyType property = ModelUtil.getPropertyInstance(instance, (String) id);
		if (property != null)
			return property.getValue();
		return "";
	}

	@Override
	public void resetPropertyValue(Object id) {

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// EditingDomain editingDomain = editor.getEditingDomain();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor((EObject) instance);

		Command command = null;
		if (id.equals(INSTANCE_NAME)) { // The property to change is the instance
												  // Name
			command = CommandFactory.createSetInstanceNameCommand(editingDomain, instance, (String) value);
		} else { // The property to change is a component property
			InstancePropertyType property = ModelUtil.getPropertyInstance(instance, (String) id);
			if (!((String) value).isEmpty()) { // A value can be assigned to this
														  // property
				if (property != null) {
					command = CommandFactory.createSetPropertyInstanceValueCommand(editingDomain, property,
					      (String) value);

				} else {
					property = FelixFactory.eINSTANCE.createInstancePropertyType();
					property.setName((String) id);
					property.setValue((String) value);
					command = CommandFactory.createAddPropertyInstanceCommand(editingDomain, instance, property);
				}
			} else { // No value, the property must be eliminated from instance
						// definition
				if (property != null) {
					command = CommandFactory
					      .createRemovePropertyInstanceCommand(editingDomain, instance, property);
				}
			}
		}
		if (command != null && editingDomain != null)
			ModelUtil.executeCommand(editingDomain, command);
	}

	@Override
	public boolean isPropertyResettable(Object id) {
		return false;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	public InstanceType getInstance() {
		return instance;
	}

	private TextPropertyDescriptor createDescriptor(String name, String type) {
		TextPropertyDescriptor descriptor = new TextPropertyDescriptor(name, name);
		descriptor.setDescription(type);
		return descriptor;
	}
	
}
