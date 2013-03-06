package pluginEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cconsole.CConsole;
import cconsole.CConsoleErr;

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

	private String PLUGINS_PATH = "pluginsj";

	// constructors

	public PluginPlatform() {
		pluginList_ = new HashMap<String, Plugin>();
	}

	// getters

	public Map<String, Plugin> getPluginList() {
		constructPluginList();
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
				System.err.println(name + " wasn't found in the plugin list!");
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

	/**
	 * constructPluginList()
	 * <p>
	 * This method is used to construct the plugin's list by reading the folder
	 * "plugins". Create the directory if it doesn't exist
	 */
	private void constructPluginList() {
		File root = new File(PLUGINS_PATH);
		if(root == null){
			if(root.canWrite()){
				CConsole.println("path");
			}
			else{
				CConsole.warnln("directory "+PLUGINS_PATH+" are not writable! Check wether you have permission on this directory");
			}
		}
		File[] list = root.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				addPluginListElement(f);
			}
		}

	}

	/**
	 * 
	 * @param pluginPath a File matching a plugin directory
	 */
	private void addPluginListElement(File pluginPath) {
		System.out.println(pluginPath.getAbsolutePath());
	}

}
