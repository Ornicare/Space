package gameEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * PluginPlatform is the plugin's management class.
 * <p>
 * It's supposed to manage call for plugin and respect their properties (default
 * loading, lazy loading, single loading)
 * <p>
 * Constructor
 * <li>public PluginPlatform()
 * 
 * @author liebekinder
 * @see Plugin
 */
public class PluginPlatform {

	// fields

	private Map<String, Plugin> pluginList_;

	// constructors

	public PluginPlatform() {
		pluginList_ = new HashMap<String, Plugin>();
	}

	// getters

	public Map<String, Plugin> getPluginList() {
		return pluginList_;
	}

	// methods

	/**
	 * Plugin getPlugin(String name)
	 * <p>
	 * This method find the plugin linked to the name. Check whether name is
	 * valid or not.
	 * 
	 * @param name
	 *            the name of the plugin you want
	 * @return the plugin associated to the name or null
	 * @see Plugin
	 */
	public Plugin getPlugin(String name) {
		Plugin retour = null;
		if (name != null) {
			retour = pluginList_.get(name);

			if (retour == null) {
				retour = getPluginAdvanced(name);
			} else {
				System.err.println(name
						+ " wasn't found in the plugin list!");
			}
		} else {
			System.err.println("plugin's name is null");
		}
		return retour;
	}

	/**
	 * Plugin getPluginAdvanced(String name)
	 * <p>
	 * This method find the plugin linked to the name. It is not case sensitive
	 * 
	 * @param name
	 *            nom du plugin
	 * @return the associated to the name or null
	 */
	private Plugin getPluginAdvanced(String name) {
		Plugin retour = null;
		Map<String, Plugin> clonePluginList = new HashMap<String, Plugin>();
		for (String s : pluginList_.keySet()) {
			clonePluginList.put(s.toLowerCase(), pluginList_.get(s));
		}
		retour = clonePluginList.get(name.toLowerCase());
		return retour;

	}
}
