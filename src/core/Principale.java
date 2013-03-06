package core;

import pluginEngine.PluginPlatform;
import cconsole.CConsole;

public class Principale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CConsole.load();
		
		PluginPlatform p = new PluginPlatform();
		p.getPluginList();
	}

}
