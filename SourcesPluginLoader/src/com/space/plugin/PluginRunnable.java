package com.space.plugin;

import java.lang.reflect.Method;
import java.util.Properties;

public class PluginRunnable extends PluginBase implements IPluginRunnable {
	private Method method;
	private Object instance;
	
	public PluginRunnable(String path, PluginManager pluginManager, Properties config) {
		super(path, pluginManager, config);
	}

	@Override
	public void run() throws Exception   {
		if(instance == null || !singleton) createRunMethod();
		method.invoke(instance);
	}
	
	protected void createRunMethod() throws Exception {
		if(!initialized) initialize();
		
		if(lazy) this.initialized = true;
		
		Class<?> classToLoad = Class.forName(mainClass, true, classLoader);
		Validate.notNull(classToLoad, "Invalid main class.");
		
		method = classToLoad.getDeclaredMethod("run");
		instance = classToLoad.newInstance();
	}

}
