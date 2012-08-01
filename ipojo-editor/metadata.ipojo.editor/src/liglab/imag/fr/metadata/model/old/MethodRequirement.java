package liglab.imag.fr.metadata.model.old;

public class MethodRequirement {

	private String id;
	private String bindMethod;
	private String unbindMethod;
	/**
    * @return the id
    */
   public String getId() {
   	return id;
   }
	/**
    * @param id the id to set
    */
   public void setId(String id) {
   	this.id = id;
   }
	/**
    * @return the bindMethod
    */
   public String getBindMethod() {
   	return bindMethod;
   }
	/**
    * @param bindMethod the bindMethod to set
    */
   public void setBindMethod(String bindMethod) {
   	this.bindMethod = bindMethod;
   }
	/**
    * @return the unbindMethod
    */
   public String getUnbindMethod() {
   	return unbindMethod;
   }
	/**
    * @param unbindMethod the unbindMethod to set
    */
   public void setUnbindMethod(String unbindMethod) {
   	this.unbindMethod = unbindMethod;
   }
	
}
