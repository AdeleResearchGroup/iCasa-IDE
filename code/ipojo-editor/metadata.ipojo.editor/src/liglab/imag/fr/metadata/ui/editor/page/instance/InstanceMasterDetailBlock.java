/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.instance;

import java.util.ArrayList;
import java.util.List;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.InstanceTypeItemProvider;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.ui.editor.MetadataEditor;
import liglab.imag.fr.metadata.ui.editor.PojoMasterDetailBlock;
import liglab.imag.fr.metadata.ui.editor.providers.InstanceContentProvider;

import org.apache.felix.ComponentType;
import org.apache.felix.FelixFactory;
import org.apache.felix.InstanceType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.editor.FormPage;



/**
 * @author Gabriel
 * 
 */
public class InstanceMasterDetailBlock extends PojoMasterDetailBlock {


	private InstanceContentProvider instanceContentProvider;
	
	public InstanceMasterDetailBlock(MetadataEditor editor, FormPage page) {
		super(editor, page);
		instanceContentProvider = new InstanceContentProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.MasterDetailsBlock#registerPages(org.eclipse.ui.forms
	 * .DetailsPart)
	 */
	@Override
	protected void registerPages(DetailsPart detailsPart) {		
		detailsPart.registerPage(InstanceTypeItemProvider.class, new InstanceDetailsPage(componentsViewer));
	}

	@Override
   protected boolean addEditionButtons() {
	   return false;
   }

	@Override
   protected String getPanelMessage() {
	   return "The list contains configured components in bundle";
   }
	
	@Override
	protected String getPanelTitle() {
	   return "Bundle Component List";
	}

	@Override
   public IContentProvider getContentProvider() {
	   return instanceContentProvider;
   }
	
	@Override
	protected void addContextMenu() {
		final CreateInstanceAction newInstanceAction = new CreateInstanceAction("New Instance Declaration");
		final RemoveInstanceAction removeInstanceAction = new RemoveInstanceAction("Remove Instance Declaration");
		
		final MenuManager menuMng = new MenuManager();
		menuMng.setRemoveAllWhenShown(true);

		
		menuMng.addMenuListener(new IMenuListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse
			 * .jface.action.IMenuManager)
			 */
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
				if (!selection.isEmpty()) {
					// Add instance action is used on Component Types
					if (selection.getFirstElement() instanceof ComponentType) {	               
						menuMng.add(newInstanceAction);	               
               }
					// Delete instance is used on Instances Declaration
					if (selection.getFirstElement() instanceof InstanceTypeItemProvider) {
						menuMng.add(removeInstanceAction);
					}
				}
			}
		});
		componentsViewer.getControl().setMenu(menuMng.createContextMenu(componentsViewer.getControl()));
				
	}
	
	/**
	 * An action class used to add a new instance declaration
	 * @author Gabriel
	 *
	 */
	class CreateInstanceAction extends Action {
		
		private int seq = 1;
		
		public CreateInstanceAction(String text) {
	      super(text);
      }

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
			if (!selection.isEmpty()) {
				if (selection.getFirstElement() instanceof ComponentType) {	               
					ComponentType component = (ComponentType) selection.getFirstElement();
					InstanceType instance = FelixFactory.eINSTANCE.createInstanceType();					
					instance.setComponent(component.getName());					
					instance.setName(getInstanceName(component));
					Command command = CommandFactory.createAddInstanceCommand(editor.getEditingDomain(), component, instance);
					ModelUtil.executeCommand(editor.getEditingDomain(), command);
					componentsViewer.refresh();
            }					
			}
		}
		
		private String getInstanceName(ComponentType component) {
						
			
			List<String> instancesNames = new ArrayList<String>();
			List<InstanceType> instances = ModelUtil.getInstances(component);
			
			for (InstanceType instance : instances) {
				instancesNames.add(instance.getName());
         }
			
			String componentName =  component.getName();
			String newInstanceName = componentName + "-" + seq++;
			while (instancesNames.contains(newInstanceName)) {
				newInstanceName = componentName + "-" + seq++;
			}
						
			return newInstanceName;
		}
		
	}
	

	
	/**
	 * An action class used to remove an instance declaration
	 * @author Gabriel
	 *
	 */
	class RemoveInstanceAction extends Action {
				
		public RemoveInstanceAction(String text) {
	      super(text);
      }

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
			if (!selection.isEmpty()) {
				if (selection.getFirstElement() instanceof InstanceTypeItemProvider) {	               
					InstanceTypeItemProvider instanceItemProvider = (InstanceTypeItemProvider) selection.getFirstElement();
					Command command = CommandFactory.createRemoveInstanceCommand(editor.getEditingDomain(), instanceItemProvider.getInstance());
					ModelUtil.executeCommand(editor.getEditingDomain(), command);
					componentsViewer.refresh(false);
            }					
			}
		}
	}
}
