package com.space.plugin;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public abstract class PluginBase {

	
	private Properties config;
	protected PluginClassLoader classLoader;
	private String pluginJarName;
	private String name;
	protected boolean initialized = false;
	private PluginManager pluginManager;
	
	protected String mainClass;
	protected boolean lazy;
	protected boolean singleton;
	protected boolean isRunnable;
	
	public PluginBase(String pluginJarName, PluginManager pluginManager, Properties config) {
		Validate.notNull(pluginJarName, "Jar name cannot be null !");
		this.pluginJarName = pluginJarName;
		this.pluginManager=pluginManager;
		this.pluginManager.register(this);
		this.config = config;
		loadConfig(config);
	}

	public void initialize() {
		URL fileURL = null;
		try {
			fileURL = new URL("file:///"+System.getProperty("user.dir")+"/"+pluginJarName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		URL[] tabURL = new URL[]{fileURL};
		classLoader = pluginManager.getNewClassLoader(tabURL, getDependancies());
	}

	public Properties getConfig() {
		return config;
	}
	
	private void loadConfig(Properties config) {
    	mainClass = config.getProperty("main");
    	if(config.getProperty("runnable").equals("true")) Validate.notNull(mainClass, getName()+" : Invalid main class in the properties file");
    	
    	lazy = getPropertyBool("lazy");
    	singleton = getPropertyBool("singleton");
    	isRunnable = getPropertyBool("runnable");
		
	}
	
	private boolean getPropertyBool(String prop) {
		//default : false
		if(!config.containsKey(prop)) return false;
		Boolean value = Boolean.valueOf(config.getProperty(prop));
		return value;
	}
    
    
    public InputStream getResource(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        return getClass().getResourceAsStream(filename);
    }
    
    public final PluginClassLoader getClassLoader() throws Exception {
    	initialize();
        return classLoader;
    }
    
    public String getName() {
    	if(name==null) this.name = config.getProperty("name");
    	if(name==null) this.name = pluginJarName;
    	return name;
    }

	public String[] getDependancies() {
		String rawDependancies = config.getProperty("depend");
		String[] retour = null;
		if(rawDependancies!=null) retour = config.getProperty("depend").split(",");
		return retour==null?new String[0]:retour;
	}

	public Object getJarName() {
		return pluginJarName.substring(8).substring(0, pluginJarName.length()-12);
	}
	
	

}
