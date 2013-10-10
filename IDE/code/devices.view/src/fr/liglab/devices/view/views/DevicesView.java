package fr.liglab.devices.view.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.core.project.IPackageImportDescription;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import fr.liglab.devices.view.Activator;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class DevicesView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "devices.view.views.DevicesView";

	private TreeViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view, or
	 * ignore it and always show the same content (like Task List, for example).
	 */

	class ViewContentProvider implements ITreeContentProvider {

		@Override
      public void dispose() {
	      // TODO Auto-generated method stub
	      
      }

		@Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	      // TODO Auto-generated method stub
	      
      }

		@Override
      public Object[] getElements(Object inputElement) {
	      // TODO Auto-generated method stub
	      return getChildren(inputElement);
      }

		@Override
      public Object[] getChildren(Object parentElement) {
	      if (parentElement instanceof List) {
	         List list = (List) parentElement;
	         return list.toArray();
         }
	      if (parentElement instanceof Category) {
	         Category category = (Category) parentElement;
	         return category.getDevices().toArray();	         
         }
	      return null;
      }

		@Override
      public Object getParent(Object element) {
	      if (element instanceof Device) {
	         Device device = (Device) element;
	         return device.getCategory();	         
         }
	      return null;
      }

		@Override
      public boolean hasChildren(Object element) {
			if (element instanceof List) 
				return (((List)element).size()>0);
			
			if (element instanceof Category) {
				Category category = (Category) element;
				return (category.getDevices().size()>0);
			}				
	      return false;
      }

	}

	class ViewLabelProvider extends LabelProvider implements ILabelProvider {
		@Override
		public Image getImage(Object element) {
		   // TODO Auto-generated method stub
			if (element instanceof Category) {
	         Category category = (Category) element;
	         if (category.getName().equals("Audio"))
	         	return Activator.getImageDescriptor("icons/sound.png").createImage();
	         if (category.getName().equals("Light"))
	         	return Activator.getImageDescriptor("icons/light.png").createImage();
	         if (category.getName().equals("Temperature"))
	         	return Activator.getImageDescriptor("icons/temperature.png").createImage();
	         if (category.getName().equals("Others"))
	         	return Activator.getImageDescriptor("icons/device.png").createImage();
         }
			return Activator.getImageDescriptor("icons/device.png").createImage();
		}
	}
	
	class ViewLabelProvider2 extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return Activator.getImageDescriptor("icons/device.png").createImage();
		}
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public DevicesView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		//viewer.setSorter(new NameSorter());
		viewer.setInput(createModel());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DevicesView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				//Activator.context


				BundleContext context = null;
				ServiceReference ref = null;

				try {
					
					String packageName = "";
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof Category) {
	               Category category = (Category) obj;
	               packageName = category.getPackageName();
               }
					if (obj instanceof Device) {
						 Device device = (Device) obj;
						 packageName = device.getCategory().getPackageName();
					}
					
					context = Activator.context;
					
					ref = context.getServiceReference(IBundleProjectService.class.getName());
					IBundleProjectService service = (IBundleProjectService) context.getService(ref);
					
					
					IEditorPart part =  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if (part!=null) {
						IFileEditorInput input = (IFileEditorInput)part.getEditorInput() ;
					    IFile file = input.getFile();
					    IProject activeProject = file.getProject();
					    if (activeProject!=null && !packageName.isEmpty()) {
					   	 IBundleProjectDescription desc = service.getDescription(activeProject);
					   	 IPackageImportDescription impo = service.newPackageImport(packageName, null, false);
					   	 
					   	 int length = 0;
					   	 IPackageImportDescription[] initialArray = desc.getPackageImports();					   	 
					   	 if (initialArray!=null)
					   		 length = initialArray.length;
					   	 IPackageImportDescription[] newArray = new IPackageImportDescription[length + 1];
					   	 
					   	 if (initialArray!=null)
					   		 System.arraycopy(initialArray, 0, newArray, 0, length);
					   	 newArray[length] = impo;
					   	 
					   	 desc.setPackageImports(newArray);
					   	 desc.apply(null);
					    }
					   	 

					}
					
					//IBundleProjectDescription
					
				} catch (OperationCanceledException e) {
					e.printStackTrace();
				} catch (CoreException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
            } finally {
					if (context != null && ref != null)
						context.ungetService(ref);
				}
				
			}
		};
		action1.setText("Add Device Declaration");
		action1.setToolTipText("Add Device Package to Manifes file");
		action1.setImageDescriptor(Activator.getImageDescriptor("icons/add_button.png"));

		action2 = new Action() {
			public void run() {
				String className = "";
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				if (obj instanceof Device) {
					 Device device = (Device) obj;
					 className = device.getInterface();
					 if (!className.isEmpty())
						 showMessage("Interface to use: " + className);
				}
			}
		};
		action2.setText("Device Java Interface");
		action2.setToolTipText("Device Java Interface");
		/*
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		      .getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		*/
		action2.setImageDescriptor(Activator.getImageDescriptor("icons/info_button.png"));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "Devices View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private List<Category> createModel() {
		List<Category> categories = new ArrayList<Category>();
		
		Category aCategory = null; 
		
		aCategory = new Category("Audio", "fr.liglab.adele.icasa.device.sound");
		aCategory.addDevice(new Device("AudioSource", "fr.liglab.adele.icasa.device.sound.AudioSource"));
		aCategory.addDevice(new Device("Speaker", "fr.liglab.adele.icasa.device.sound.Speaker"));
		categories.add(aCategory);
		
		aCategory = new Category("Light", "fr.liglab.adele.icasa.device.light");
		aCategory.addDevice(new Device("Binary Light", "fr.liglab.adele.icasa.device.light.BinaryLight"));
		aCategory.addDevice(new Device("Dimmer Light", "fr.liglab.adele.icasa.device.light.DimmerLight"));
		aCategory.addDevice(new Device("Photometer", "fr.liglab.adele.icasa.device.light.Photometer"));		
		categories.add(aCategory);
		
		aCategory = new Category("Presence", "fr.liglab.adele.icasa.device.presence");	
		aCategory.addDevice(new Device("Presence Detector", "fr.liglab.adele.icasa.device.presence.PresenceSensor"));
		categories.add(aCategory);

		aCategory = new Category("Temperature", "fr.liglab.adele.icasa.device.temperature");	
		aCategory.addDevice(new Device("Thermometer", "fr.liglab.adele.icasa.device.temperature.Thermometer"));
		aCategory.addDevice(new Device("Heater", "fr.liglab.adele.icasa.device.temperature.Heater"));
		aCategory.addDevice(new Device("Cooler", "fr.liglab.adele.icasa.device.temperature.Cooler"));
		categories.add(aCategory);

		
		return categories;
	}
}

class Device {
	private String name;
	private Category category;
	private String interfaze;

	public Device(String name, String interfaze) {
		this.name = name;
		this.interfaze = interfaze;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public Category getCategory() {
   	return category;
   }

	public void setCategory(Category category) {
   	this.category = category;
   }

	public String getInterface() {
   	return interfaze;
   }
	
}

class Category {
	
	private String name;
	private List<Device> devices;
	private String packageName;
	
	public Category(String name, String packageName) {
		this.name = name;
		this.packageName = packageName;
		devices = new ArrayList<Device>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public void addDevice(Device device) {
		devices.add(device);
		device.setCategory(this);
	}

	public List<Device> getDevices() {
   	return devices;
   }

	public String getPackageName() {
   	return packageName;
   }
	
	
}