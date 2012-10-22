package liglab.imag.fr.metadata.emf;

import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

public class InstancePropertySourceProvider implements IPropertySourceProvider {

	private static InstancePropertySourceProvider instance;
		
	private InstancePropertySourceProvider() {
   }

	public static InstancePropertySourceProvider getInstance() {
		if (instance==null)
			instance = new InstancePropertySourceProvider();
		return instance;
	}

	@Override
	public IPropertySource getPropertySource(Object object) {
		if (object instanceof InstanceTypeItemProvider) {
	      return (IPropertySource) object;	      
      }
		return null;
	}

}
