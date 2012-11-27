/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.dialog;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;

import org.apache.felix.FelixFactory;
import org.apache.felix.PropertyType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Gabriel
 * 
 */
public class PropertyDialog extends MetadataInputDialog {

	private Text nameText;
	private Text fieldText;
	private Text valueText;
	private Combo typeCombo;
	private boolean mandatoryField;

	private PropertyType m_property;

	public PropertyDialog(EditingDomain editingDomain, PropertyType property, boolean mandatoryField) {
		super(editingDomain);
		if (property != null)
			m_property = property;
		else
			m_property = FelixFactory.eINSTANCE.createPropertyType();
		this.mandatoryField = mandatoryField;

	}

	@Override
	protected void load() {
		if (m_property.getName() != null)
			nameText.setText(m_property.getName());
		if (m_property.getField() != null)
			fieldText.setText(m_property.getField());
		if (m_property.getType() != null)
			typeCombo.setText(m_property.getType());
		if (m_property.getValue() != null)
			valueText.setText(m_property.getValue());

	}

	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Property Dialog Definition");
		// Set the message
		setMessage("Input the property definition information", IMessageProvider.INFORMATION);
		// setHelpAvailable(false);

	}

	@Override
	protected Control createDialogArea(Composite parent) {

		GridLayout parentLayout = new GridLayout();
		parentLayout.numColumns = 1;
		parent.setLayout(parentLayout);

		// The text fields will grow with the size of the dialog
		GridData generalLayoutData = new GridData();
		generalLayoutData.grabExcessHorizontalSpace = true;
		generalLayoutData.horizontalAlignment = SWT.FILL;

		Group generalComposite = new Group(parent, SWT.NONE);
		GridLayout generalLayout = new GridLayout();
		generalLayout.numColumns = 2;
		generalComposite.setLayout(generalLayout);
		generalComposite.setLayoutData(generalLayoutData);

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		Label label1 = new Label(generalComposite, SWT.NONE);
		label1.setText("Property Name");

		nameText = new Text(generalComposite, SWT.BORDER);
		nameText.setLayoutData(gridData);
		nameText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				fieldText.setText(nameText.getText());
			}
		});

		Label label2 = new Label(generalComposite, SWT.NONE);
		label2.setText("Property Field");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		fieldText = new Text(generalComposite, SWT.BORDER);
		fieldText.setLayoutData(gridData);

		Label label3 = new Label(generalComposite, SWT.NONE);
		label3.setText("Default Value");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		valueText = new Text(generalComposite, SWT.BORDER);
		valueText.setLayoutData(gridData);

		Label label4 = new Label(generalComposite, SWT.NONE);
		label4.setText("Property Type");

		typeCombo = new Combo(generalComposite, SWT.NONE);
		typeCombo
		      .setItems(new String[] { "", "java.lang.String", "java.lang.Integer", "java.lang.Long",
		            "java.lang.Float", "java.lang.Double", "java.lang.Boolean", "java.util.Vector",
		            "java.util.Map" });
		typeCombo.setText("java.lang.String");
		typeCombo.setLayoutData(gridData);

		load();

		return parent;
	}

	@Override
	protected boolean isValidInput() {
		if (nameText.getText().isEmpty()) {
			setErrorMessage("Please insert the property name");
			return false;
		}
		
		String field = fieldText.getText().trim();
		String type = typeCombo.getText().trim();
		if (mandatoryField) {
			if (field.isEmpty()) {
				setErrorMessage("Please insert the property fied");
				return false;				
			}
		} else {
			if (field.isEmpty() && type.isEmpty()) {
				setErrorMessage("Please insert the property fied or the property type");
				return false;
			}			
		}

		return true;
	}

	@Override
	protected void saveInput() {
		if (m_property != null) {

			CompoundCommand compoundCommand = new CompoundCommand();
			Command command = null;

			String name = nameText.getText().trim();
			if (m_property.getName() != null) {
				if (!m_property.getName().equals(name)) {
					command = CommandFactory.createSetNamePropertyCommand(editingDomain, m_property, name);
					compoundCommand.append(command);
				}
			} else {
				command = CommandFactory.createSetNamePropertyCommand(editingDomain, m_property, name);
				compoundCommand.append(command);
			}

			String field = fieldText.getText().trim();
			if (m_property.getField() != null) {
				if (!m_property.getField().equals(field)) {
					command = CommandFactory.createSetFieldPropertyCommand(editingDomain, m_property, field);
					compoundCommand.append(command);
				}
			} else {
				if (!field.isEmpty()) {
					command = CommandFactory.createSetFieldPropertyCommand(editingDomain, m_property, field);
					compoundCommand.append(command);
				}
			}

			String value = valueText.getText().trim();
			if (m_property.getValue() != null) {
				if (m_property.getValue().equals(value)) {
					command = CommandFactory.createSetValuePropertyCommand(editingDomain, m_property, value);
					compoundCommand.append(command);
				}
			} else {
				if (!value.isEmpty()) {
					command = CommandFactory.createSetValuePropertyCommand(editingDomain, m_property, value);
					compoundCommand.append(command);
				}
			}

			String type = typeCombo.getText().trim();
			if (m_property.getType() != null) {
				if (!m_property.getType().equals(type)) {
					command = CommandFactory.createSetTypePropertyCommand(editingDomain, m_property, type);
					compoundCommand.append(command);
				}
			} else {
				if (!type.isEmpty()) {
					command = CommandFactory.createSetTypePropertyCommand(editingDomain, m_property, type);
					compoundCommand.append(command);
				}
			}

			ModelUtil.executeCommand(editingDomain, compoundCommand);
		}
	}

	/**
	 * @return the m_property
	 */
	public PropertyType getProperty() {
		return m_property;
	}
}
