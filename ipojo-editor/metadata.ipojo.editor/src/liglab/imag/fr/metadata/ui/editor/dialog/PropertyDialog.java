/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.dialog;

import org.apache.felix.FelixFactory;
import org.apache.felix.PropertyType;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
	private Text typeText;
		
	private PropertyType m_property;
	
	public PropertyDialog(EditingDomain editingDomain, PropertyType property) {
		super(editingDomain);
		if (property!=null)
			m_property = property;
		else
			m_property = FelixFactory.eINSTANCE.createPropertyType();

	}
	
	@Override
	protected void load() {
		if (m_property.getName()!=null)
			nameText.setText(m_property.getName());
		if (m_property.getField()!=null)
			fieldText.setText(m_property.getField());
		if (m_property.getType()!=null)
			typeText.setText(m_property.getType());		
		if (m_property.getValue()!=null)
			valueText.setText(m_property.getValue());		
	   
   }


	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Property Dialog Definition");
		// Set the message
		setMessage("Input the property definition information", IMessageProvider.INFORMATION);
		//setHelpAvailable(false);

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		// layout.horizontalAlignment = GridData.FILL;
		parent.setLayout(layout);

		// The text fields will grow with the size of the dialog
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		Label label1 = new Label(parent, SWT.NONE);
		label1.setText("Property Name");

		nameText = new Text(parent, SWT.BORDER);
		nameText.setLayoutData(gridData);
		nameText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				System.out.println("Listener was executed");
				fieldText.setText(nameText.getText());
			}
		});
		
		Label label2 = new Label(parent, SWT.NONE);
		label2.setText("Property Field");
				
		
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		fieldText = new Text(parent, SWT.BORDER);
		fieldText.setLayoutData(gridData);
		
		Label label3 = new Label(parent, SWT.NONE);
		label3.setText("Default Value");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		valueText = new Text(parent, SWT.BORDER);
		valueText.setLayoutData(gridData);

		Label label4 = new Label(parent, SWT.NONE);
		label4.setText("Property Type");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		typeText = new Text(parent, SWT.BORDER);
		typeText.setLayoutData(gridData);
		
		
		load();
		
		return parent;
	}

	@Override
	protected boolean isValidInput() {
		boolean valid = true;
		if (nameText.getText().isEmpty()) {
			setErrorMessage("Please insert the property name");
			valid = false;
		}
		if (fieldText.getText().isEmpty() && typeText.getText().isEmpty()) {
			setErrorMessage("Please insert a property fied or a property type");
			valid = false;
		}
		if (!fieldText.getText().isEmpty() && !typeText.getText().isEmpty()) {
			setErrorMessage("Please insert either a property fied or a property type");
			valid = false;
		}		
		return valid;
	}
	
	@Override
	protected void saveInput() {
		if (m_property!=null) {
			m_property.setName(nameText.getText());
			if (!fieldText.getText().isEmpty())
				m_property.setField(fieldText.getText());			
			if (!typeText.getText().isEmpty())
				m_property.setType(typeText.getText());
			if (!valueText.getText().isEmpty())
				m_property.setValue(valueText.getText());
			
		}
	}

	/**
    * @return the m_property
    */
   public PropertyType getProperty() {
   	return m_property;
   }
}
