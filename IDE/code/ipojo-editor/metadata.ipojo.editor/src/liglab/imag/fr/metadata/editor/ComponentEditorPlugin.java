package liglab.imag.fr.metadata.editor;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.core.project.IPackageExportDescription;
import org.eclipse.pde.core.project.IPackageImportDescription;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.core.target.TargetBundle;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;

/**
 * The activator class controls the plug-in life cycle
 */
public class ComponentEditorPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "metadata.ipojo.editor"; //$NON-NLS-1$

	// The shared instance
	private static ComponentEditorPlugin plugin;
	
	
	public static final String IMG_HORIZONTAL = "horizontal"; //$NON-NLS-1$
	public static final String IMG_VERTICAL = "vertical"; //$NON-NLS-1$
	public static final String IMG_COMPONENT = "component"; //$NON-NLS-1$
	public static final String IMG_INSTANCE = "instance"; //$NON-NLS-1$
	
	private ServiceReference<IBundleProjectService> bundleProjectServiceReference;
	private IBundleProjectService bundleProjectService;

	private ServiceReference<ITargetPlatformService> targetPlatformServiceReference;
	private ITargetPlatformService targetPlatformService;
	
	/**
	 * The constructor
	 */
	public ComponentEditorPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		this.bundleProjectServiceReference	= context.getServiceReference(IBundleProjectService.class);
		this.bundleProjectService			= context.getService(bundleProjectServiceReference);

		this.targetPlatformServiceReference	= context.getServiceReference(ITargetPlatformService.class);
		this.targetPlatformService			= context.getService(targetPlatformServiceReference);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		
		context.ungetService(bundleProjectServiceReference);
		
		bundleProjectService = null;
		bundleProjectServiceReference = null;

		context.ungetService(targetPlatformServiceReference);
		
		targetPlatformService = null;
		targetPlatformServiceReference = null;
		
		plugin = null;
		super.stop(context);		
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ComponentEditorPlugin getDefault() {
		return plugin;
	}

	protected void initializeImageRegistry(ImageRegistry registry) {
		registerImage(registry, IMG_HORIZONTAL, "th_horizontal.gif"); //$NON-NLS-1$
		registerImage(registry, IMG_VERTICAL, "th_vertical.gif"); //$NON-NLS-1$
		registerImage(registry, IMG_COMPONENT, "component.png");
		registerImage(registry, IMG_INSTANCE, "instance.gif");
	}

	private void registerImage(ImageRegistry registry, String key, String fileName) {
		try {
			IPath path = new Path("icons/" + fileName); //$NON-NLS-1$
			URL url = FileLocator.find(this.getBundle(), path, null);
			if (url != null) {
				ImageDescriptor desc = ImageDescriptor.createFromURL(url);
				registry.put(key, desc);
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * Returns a bundle project description that can be used to manipulate the artifacts associated
	 * with the bundle.
	 * 
	 */
	public IBundleProjectDescription getDescription(IProject project) throws CoreException {
		return bundleProjectService.getDescription(project);
	}

	
	public IPackageExportDescription getExportDescription(String name, Version version) {
		return bundleProjectService.newPackageExport(name, version, true, null);
	}

	public IPackageImportDescription getImportDescription(String name, Version version) {
		return bundleProjectService.newPackageImport(name, new org.eclipse.osgi.service.resolver.VersionRange(version,true,version,true), false);
	}

	public String getTargetPlatformBundleVersion(String bundle) throws CoreException {

		ITargetDefinition targetPlatform = targetPlatformService.getWorkspaceTargetHandle().getTargetDefinition();
		targetPlatform.resolve(null);
		for (TargetBundle targetBundle : optional(targetPlatform.getBundles())) {
			String name 	= targetBundle.getBundleInfo().getSymbolicName();
			String version 	= targetBundle.getBundleInfo().getVersion();
			
			if (name != null && name.equals(bundle)) {
				return version;
			}
		}
		
		return null;
	}
	
	private static <E> List<E> optional (E... args) {
		return args == null ? Collections.<E>emptyList() : Arrays.asList(args);
	}
	
}
