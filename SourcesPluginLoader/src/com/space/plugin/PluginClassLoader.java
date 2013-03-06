package com.space.plugin;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader{
	private ClassLoader parent;
	private PluginManager pluginManager;
	private String[] dependancies;
	
    public PluginClassLoader( URL[] urls, ClassLoader parent, PluginManager pluginManager, String[] dependancies )
    {
        super(urls, null);
        this.parent = parent;
        this.pluginManager=pluginManager;
        this.dependancies = dependancies;
        
    }

    @Override
    public Class<?> findClass(String name)
    {
        try
        {
            // first try to use the URLClassLoader findClass
            return super.findClass(name);
        }
        catch( ClassNotFoundException e )
        {
            try
            {
            	// if that fails, we ask our real parent classloader to load the class (we give up)
            	return parent.loadClass(name);
            }
            catch( ClassNotFoundException e2 )
            {
                try
                {

                	// And then check dependancies
                    return pluginManager.findClass(name, dependancies);
                }
                catch( Exception e3 )
                {
                    // Finally.... kill the chicken.
                	try {
						throw new Throwable("Error in dependancies !");
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
            
        }
		return null;
        
    }
}
