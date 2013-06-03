package liglab.imag.fr.ipojo.preferences;

import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */
public class IPojoPreferencesPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ipojo.preferences"; //$NON-NLS-1$

	// The shared instance
	private static IPojoPreferencesPlugin plugin;
		
	
	private BundleContext fBundleContext;
	
	/**
	 * The constructor
	 */
	public IPojoPreferencesPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		fBundleContext = context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		fBundleContext = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static IPojoPreferencesPlugin getDefault() {
		return plugin;				
	}
	
	/**
	 * Returns a service with the specified name or <code>null</code> if none.
	 * 
	 * @param serviceName name of service
	 * @return service object or <code>null</code> if none
	 */
	public Object acquireService(String serviceName) {
		ServiceReference reference = fBundleContext.getServiceReference(serviceName);
		if (reference == null)
			return null;
		Object service = fBundleContext.getService(reference);
		if (service != null) {
			fBundleContext.ungetService(reference);
		}
		return service;
	}

}
