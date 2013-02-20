package gameEngine;

import java.util.UUID;

public class Plugin {

	String pluginName_;
	String pluginType_;
	Boolean hasLazyLoading_;
	Boolean hasSingleLoading_;
	Boolean isDefaultLoading_;
	
	UUID pluginUUID_;
	
	//constructors
	
	public Plugin(){
//		/pluginUUID = new UUID();
	}
	
	/**
	 * Complete constructor, setting class field from the property file
	 * 
	 * @param pName the plugin's name
	 * @param pType the plugin's type
	 * @param lazyLoading whether the plugin should be lazy loaded or not
	 * @param singleLoading whether the plugin should be a singleton or not
	 * @param defaultLoading whether
	 */
	public Plugin(String pName, String pType, Boolean lazyLoading, Boolean singleLoading, Boolean defaultLoading){
		pluginName_ = pName;
		pluginType_ = pType;
		hasLazyLoading_ = lazyLoading;
		hasSingleLoading_ = singleLoading;
		isDefaultLoading_ = defaultLoading;
	}
	
	
}
