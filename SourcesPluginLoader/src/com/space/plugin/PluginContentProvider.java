package com.space.plugin;

import java.util.Properties;

public class PluginContentProvider extends PluginBase implements IPluginContentProvider {

	public PluginContentProvider(String pluginJarName, PluginManager pluginManager, Properties config) {
		super(pluginJarName, pluginManager, config);
	}

}
