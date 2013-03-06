package com.space.plugin;

public abstract class Validate {

	public static void notNull(Object o, String error) {
		if(o==null)
			try {
				throw new Throwable(error);
			} catch (Throwable e) {
				e.printStackTrace();
				//In case of plugin misconception, stop all.
				System.exit(1);
			}
	}

	public static void isTrue(boolean bool, String error) {
		if(!bool)
			try {
				throw new Throwable(error);
			} catch (Throwable e) {
				e.printStackTrace();
				//In case of plugin misconception, stop all.
				System.exit(1);
			}
	}

}
