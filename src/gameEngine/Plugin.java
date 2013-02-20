package gameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Plugin is a storage class for 
 * <p>
 * Constructor
 * <li>public Plugin()
 * <li>public Plugin(String pName, String pType)
 * <li>public Plugin(String pName, String pType, ArrayList<String> pClass, Boolean lazyLoading, Boolean singleLoading, Boolean defaultLoading)
 * @author liebekinder
 *
 */
public class Plugin {

	private String pluginName;
	private String pluginType;
	private List<String> pluginClass;
	private Boolean hasLazyLoading;
	private Boolean hasSingleLoading;
	private Boolean isDefaultLoading;
	
	private UUID pluginUUID;
	private Boolean active;
	
	
	//constructors
	
	public Plugin(){
	}
	
	/**
	 * Plugin's constructor, setting the plugin's name and type
	 * All other parameters are set to default value
	 * @param pName the plugin's name
	 * @param pType the plugin's type
	 */
	public Plugin(String pName, String pType){
		pluginName = pName;
		pluginType = pType;
		pluginClass = new ArrayList<String>();
		hasLazyLoading = false;
		hasSingleLoading = false;
		isDefaultLoading = false;
		
		pluginUUID = UUID.randomUUID();
		active = false;
	}
	
	/**
	 * Complete constructor, setting class field from the property file
	 * 
	 * @param pName the plugin's name
	 * @param pType the plugin's type
	 * @param pClass the plugin's list of class to be loaded
	 * @param lazyLoading whether the plugin should be lazy loaded or not
	 * @param singleLoading whether the plugin should be a singleton or not
	 * @param defaultLoading whether
	 */
	public Plugin(String pName, String pType, ArrayList<String> pClass, Boolean lazyLoading, Boolean singleLoading, Boolean defaultLoading){
		pluginName = pName;
		pluginType = pType;
		pluginClass = pClass;
		hasLazyLoading = lazyLoading;
		hasSingleLoading = singleLoading;
		isDefaultLoading = defaultLoading;
		
		pluginUUID = UUID.randomUUID();
		active = false;
	}

	//getters
	
	public String getPluginName() {
		return pluginName;
	}

	public String getPluginType() {
		return pluginType;
	}

	public List<String> getPluginClass() {
		return pluginClass;
	}

	public Boolean getHasLazyLoading() {
		return hasLazyLoading;
	}

	public Boolean getHasSingleLoading() {
		return hasSingleLoading;
	}

	public Boolean getIsDefaultLoading() {
		return isDefaultLoading;
	}

	public UUID getPluginUUID() {
		return pluginUUID;
	}

	public Boolean getActive() {
		return active;
	}
	
	
	//method
	
	
	
	
}
