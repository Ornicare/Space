package core;

import gameEngine.PluginPlatform;
import Console.Console;

public class Principale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console.load();
		
		PluginPlatform p = new PluginPlatform();
		p.getPluginList();
	}

}
