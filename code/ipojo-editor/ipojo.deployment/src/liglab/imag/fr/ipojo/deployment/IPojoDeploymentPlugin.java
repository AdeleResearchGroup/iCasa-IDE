package liglab.imag.fr.ipojo.deployment;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class IPojoDeploymentPlugin extends AbstractUIPlugin {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "ipojo.deployment"; //$NON-NLS-1$ 
		
	// The shared instance
	private static IPojoDeploymentPlugin plugin;
	
	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static IPojoDeploymentPlugin getDefault() {
		return plugin;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);		
	}

}
