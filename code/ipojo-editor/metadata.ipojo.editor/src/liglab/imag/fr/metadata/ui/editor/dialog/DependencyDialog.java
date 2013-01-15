/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.dialog;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.util.JDTUtil;

import org.apache.felix.DependencyCallbackType;
import org.apache.felix.FelixFactory;
import org.apache.felix.RequiresType;
import org.apache.felix.TypeType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Gabriel
 * 
 */
public class DependencyDialog extends MetadataInputDialog {

	private Button singleButton;
	private Button multipleButton;
	private Button optionalButton;

	/**
	 * Field Text
	 */
	private Text fieldText;

	/**
	 * Filter Text
	 */
	private Text filterText;

	/**
	 * Bind Method Text
	 */
	private Text bindText;

	/**
	 * Unbind Method Text
	 */
	private Text unbindText;

	/**
	 * Specification Class Text
	 */
	private Text specificationText;

	/**
	 * Model of the dependency
	 */
	private RequiresType dependency;

	public DependencyDialog(EditingDomain editingDomain, RequiresType requirement) {
		super(editingDomain);
		dependency = requirement;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		GridLayout parentLayout = new GridLayout();
		parentLayout.numColumns = 1;
		parent.setLayout(parentLayout);

		GridData cardinalityLayoutData = new GridData();
		cardinalityLayoutData.grabExcessHorizontalSpace = true;
		cardinalityLayoutData.horizontalAlignment = SWT.FILL;

		Group cardinalityComposite = new Group(parent, SWT.NONE);
		GridLayout cardinalityLayout = new GridLayout();
		cardinalityLayout.numColumns = 3;
		cardinalityComposite.setLayout(cardinalityLayout);
		cardinalityComposite.setLayoutData(cardinalityLayoutData);

		singleButton = new Button(cardinalityComposite, SWT.RADIO);
		singleButton.setText("Scalar (1..1)");

		singleButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				enableMethodsWidgets(false);
			}

		});

		multipleButton = new Button(cardinalityComposite, SWT.RADIO);
		multipleButton.setText("Multiple (1..n)");

		multipleButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				enableMethodsWidgets(true);
			}

		});

		optionalButton = new Button(cardinalityComposite, SWT.CHECK);
		optionalButton.setText("Optional Dependency");
		optionalButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				setDependencyTypeLabels();
			}

		});

		GridData dataLayoutData = new GridData();
		dataLayoutData.horizontalAlignment = SWT.FILL;

		Group generalComposite = new Group(parent, SWT.NONE);
		GridLayout dataLayout = new GridLayout();
		dataLayout.numColumns = 2;
		generalComposite.setLayout(dataLayout);
		generalComposite.setLayoutData(dataLayoutData);

		Label idLabel = new Label(generalComposite, SWT.NONE);
		idLabel.setText("Field Name");

		// The text fields will grow with the size of the dialog

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		fieldText = new Text(generalComposite, SWT.BORDER);
		fieldText.setLayoutData(gridData);

		Label filterLabel = new Label(generalComposite, SWT.NONE);
		filterLabel.setText("Filter");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		filterText = new Text(generalComposite, SWT.BORDER);
		filterText.setLayoutData(gridData);

		Label label3 = new Label(generalComposite, SWT.NONE);
		label3.setText("Bind Method");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		bindText = new Text(generalComposite, SWT.BORDER);
		bindText.setLayoutData(gridData);

		Label label4 = new Label(generalComposite, SWT.NONE);
		label4.setText("Unbind Method");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		unbindText = new Text(generalComposite, SWT.BORDER);
		unbindText.setLayoutData(gridData);

		// Specification section
		dataLayoutData = new GridData();
		dataLayoutData.horizontalAlignment = SWT.FILL;

		Group specComposite = new Group(parent, SWT.NONE);
		dataLayout = new GridLayout();
		dataLayout.numColumns = 4;
		specComposite.setLayout(dataLayout);
		specComposite.setLayoutData(dataLayoutData);

		Label specLabel = new Label(specComposite, SWT.NONE);
		specLabel.setText("Dependency Type");

		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		specificationText = new Text(specComposite, SWT.BORDER);
		specificationText.setLayoutData(gridData);

		Button searchButton = new Button(specComposite, SWT.FLAT);
		searchButton.setText("Search");

		searchButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IType selectedType = JDTUtil.openSearchJDTDialog(IJavaSearchScope.SOURCES
				      | IJavaSearchScope.SYSTEM_LIBRARIES | IJavaSearchScope.APPLICATION_LIBRARIES
				      | IJavaSearchScope.REFERENCED_PROJECTS, IJavaElementSearchConstants.CONSIDER_INTERFACES, true);
				if (selectedType != null)
					specificationText.setText(selectedType.getFullyQualifiedName());
			}
		});

		Button clearButton = new Button(specComposite, SWT.FLAT);
		clearButton.setText("Clear");

		load();

		return parent;
	}

	@Override
	public void create() {
		super.create();
		// Set the title
		setTitle("Dependency Dialog Definition");
		// Set the message
		setMessage("Input the dependency definition information", IMessageProvider.INFORMATION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see liglab.imag.fr.metadata.ui.editor.dialog.MetadataInputDialog#load()
	 */
	@Override
	protected void load() {

		if (dependency != null) {

			if (dependency.getField() != null)
				fieldText.setText(dependency.getField());

			if (ModelUtil.isFieldDependency(dependency)) {
				singleButton.setSelection(true);
				enableMethodsWidgets(false);

			} else {

				multipleButton.setSelection(true);
				enableMethodsWidgets(true);

				DependencyCallbackType callback = ModelUtil.getBindCallback(dependency);
				if (callback != null)
					bindText.setText(callback.getMethod());
				callback = ModelUtil.getUnbindCallback(dependency);
				if (callback != null)
					unbindText.setText(callback.getMethod());
			}
			// Sets the filter field
			if (dependency.getFilter() != null)
				filterText.setText(dependency.getFilter());

			// Sets the specification field
			if (dependency.getSpecification() != null)
				specificationText.setText(dependency.getSpecification());

			optionalButton.setSelection(dependency.isOptional());
			setDependencyTypeLabels();

		} else {
			dependency = FelixFactory.eINSTANCE.createRequiresType();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * liglab.imag.fr.metadata.ui.editor.dialog.MetadataInputDialog#isValidInput
	 * ()
	 */
	@Override
	protected boolean isValidInput() {
		if (singleButton.getSelection()) {
			if (fieldText.getText().length() == 0) {
				setErrorMessage("Please insert the requirement fied");
				return false;
			}
		}
		if (multipleButton.getSelection()) {
			/*
			 * if (fieldText.getText().length() == 0) {
			 * setErrorMessage("Please insert the requirement id"); return false; }
			 */
			if (bindText.getText().length() == 0) {
				setErrorMessage("Please insert the bind method");
				return false;
			}
			if (unbindText.getText().length() == 0) {
				setErrorMessage("Please insert the unbind method");
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * liglab.imag.fr.metadata.ui.editor.dialog.MetadataInputDialog#saveInput()
	 */
	@Override
	protected void saveInput() {

		CompoundCommand compoundCommand = new CompoundCommand();
		Command command = null;

		if (singleButton.getSelection()) {

			if (!fieldText.getText().equals(dependency.getField())) {
				command = CommandFactory.createSetFieldDependencyCommand(editingDomain, dependency, fieldText.getText());
				compoundCommand.append(command);
			}

			// Set the id to null
			if (dependency.getId() != null) {
				command = CommandFactory.createSetIDDependencyCommand(editingDomain, dependency, null);
				compoundCommand.append(command);
			}

			if (dependency.isAggregate()) {
				command = CommandFactory.createSetAggregateDependencyCommand(editingDomain, dependency, null);
				compoundCommand.append(command);
			}

			// Removes the callbacks
			DependencyCallbackType callback = ModelUtil.getRequirementCallback(dependency, TypeType.BIND);
			if (callback != null) {
				command = CommandFactory.createRemoveCallbackDependencyCommand(editingDomain, dependency, callback);
				compoundCommand.append(command);
			}
			callback = ModelUtil.getRequirementCallback(dependency, TypeType.UNBIND);
			if (callback != null) {
				command = CommandFactory.createRemoveCallbackDependencyCommand(editingDomain, dependency, callback);
				compoundCommand.append(command);
			}
		}

		if (multipleButton.getSelection()) {

			if (dependency != null) {
				// dependency.setId(idText.getText());

				/*
				 * if (!fieldText.getText().equals(dependency.getId())) { command =
				 * CommandFactory.createSetIDDependencyCommand(editingDomain,
				 * dependency, fieldText.getText());
				 * compoundCommand.append(command); }
				 */

				if (!dependency.isAggregate()) {
					command = CommandFactory.createSetAggregateDependencyCommand(editingDomain, dependency, true);
					compoundCommand.append(command);
				}

				if (!fieldText.getText().trim().isEmpty()) {
					command = CommandFactory.createSetFieldDependencyCommand(editingDomain, dependency, fieldText.getText());
					compoundCommand.append(command);
				} else {
					command = CommandFactory.createSetFieldDependencyCommand(editingDomain, dependency, null);
					compoundCommand.append(command);
				}

				/*
				 * // Set the field to null if (dependency.getField()!=null) {
				 * command =
				 * CommandFactory.createSetFieldDependencyCommand(editingDomain,
				 * dependency, null); compoundCommand.append(command); }
				 */

				/*
				 * DependencyCallbackType bindCallbackType =
				 * ModelUtil.getBindCallback(dependency); if
				 * (bindCallbackType!=null) { String bindMethodStr =
				 * bindText.getText().trim(); if
				 * (!bindMethodStr.equals(bindCallbackType.getMethod())) { command =
				 * CommandFactory.createSetCallbackDependencyCommand(editingDomain,
				 * dependency, bindMethodStr, TypeType.BIND);
				 * compoundCommand.append(command); } } else { command =
				 * CommandFactory.createSetCallbackDependencyCommand(editingDomain,
				 * dependency, bindText.getText(), TypeType.BIND);
				 * compoundCommand.append(command); }
				 */

				// Adds callbacks
				command = CommandFactory.createSetCallbackDependencyCommand(editingDomain, dependency, bindText.getText(),
				      TypeType.BIND);
				compoundCommand.append(command);
				command = CommandFactory.createSetCallbackDependencyCommand(editingDomain, dependency,
				      unbindText.getText(), TypeType.UNBIND);
				compoundCommand.append(command);
			}
		}

		String filterStr = filterText.getText().trim();
		// Filter has changed
		if (!filterStr.equals(dependency.getFilter())) {
			if (!filterStr.isEmpty())
				command = CommandFactory.createSetFilterDependencyCommand(editingDomain, dependency, filterStr);
			else
				command = CommandFactory.createSetFilterDependencyCommand(editingDomain, dependency, null);
			compoundCommand.append(command);
		}

		String specStr = specificationText.getText().trim();
		// Specification has changed
		if (!specStr.equals(dependency.getSpecification())) {
			if (!specStr.isEmpty())
				command = CommandFactory.createSetSpecificationDependencyCommand(editingDomain, dependency, specStr);
			else
				command = CommandFactory.createSetSpecificationDependencyCommand(editingDomain, dependency, specStr);
			compoundCommand.append(command);
		}

		if (optionalButton.getSelection()) {
			command = CommandFactory.createSetOptionalDependencyCommand(editingDomain, dependency, true);
			compoundCommand.append(command);
		} else { // Optional default value (false)
			command = CommandFactory.createSetOptionalDependencyCommand(editingDomain, dependency, null);
			compoundCommand.append(command);
		}

		ModelUtil.executeCommand(editingDomain, compoundCommand);
	}

	/**
	 * @return the m_requirement
	 */
	public RequiresType getRequirement() {
		return dependency;
	}

	private void enableMethodsWidgets(boolean enable) {
		bindText.setEnabled(enable);
		unbindText.setEnabled(enable);
	}

	private void setDependencyTypeLabels() {
		if (optionalButton.getSelection()) {
			singleButton.setText("Scalar (0..1)");
			multipleButton.setText("Multiple (0..n)");
		} else {
			singleButton.setText("Scalar (1..1)");
			multipleButton.setText("Multiple (1..n)");
		}
	}

}
