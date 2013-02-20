package Console;
import java.awt.Color;
import java.awt.Font;


public class Console {
	
	private static ConsoleGUI console;
	private static ConsoleOut outInterceptor;
	private static ConsoleErr errInterceptor;
	
	private static Color debugColor;
	private static Color warnColor;
	private static Font debugFont;
	private static Font warnFont;
	
	private static Boolean debug = true;
	
	public static void setDebug(Boolean debug) {
		Console.debug = debug;
	}

	public static Color getInfoColor() {
		return debugColor;
	}

	public static void setDebugColor(Color debugColor) {
		Console.debugColor = debugColor;
	}

	public static void setWarnColor(Color warnColor) {
		Console.warnColor = warnColor;
	}

	public static void setDebugFont(Font debugFont) {
		Console.debugFont = debugFont;
	}


	public static void setWarnFont(Font warnFont) {
		Console.warnFont = warnFont;
	}

	/**
	 * 
	 * @param o : 
	 * @param append : 
	 */
	private static void debug(Object o, String append) {
			
		String sortie = "";
		if(o.getClass()==Character.class || o.getClass()==Double.class || o.getClass()==Float.class || o.getClass()==Long.class || o.getClass()==Integer.class || o.getClass()==Boolean.class) {
			sortie = String.valueOf(o);
		}
		else {
			sortie = o.toString();
		}
		
		sortie+=append;
		if(debug) console.addText(sortie, debugFont, debugColor);
			
	}


	public static void debug(Object o) {
		debug(o,"");
	}
	
	public static void debugln(Object o) {
		debug(o,"\n");
	}
	
	
	private static void warn(Object o, String append) {
		
		String sortie = "";
		if(o.getClass()==Character.class || o.getClass()==Double.class || o.getClass()==Float.class || o.getClass()==Long.class || o.getClass()==Integer.class || o.getClass()==Boolean.class) {
			sortie = String.valueOf(o);
		}
		else {
			sortie = o.toString();
		}
		
		sortie+=append;
		console.addText(sortie, warnFont, warnColor);
			
	}

	public static void warn(Object o) {
		warn(o,"");
	}
	
	public static void warnln(Object o) {
		warn(o,"\n");
	}
	
	
	private static void print(Object o, String append, Font font, Color color) {
		
		String sortie = "";
		if(o.getClass()==Character.class || o.getClass()==Double.class || o.getClass()==Float.class || o.getClass()==Long.class || o.getClass()==Integer.class || o.getClass()==Boolean.class) {
			sortie = String.valueOf(o);
		}
		else {
			sortie = o.toString();
		}
		
		sortie+=append;
		console.addText(sortie,font,color);
			
	}

	public static void print(Object o) {
		print(o,"", console.getDefaultFont(), console.getDefaultColor());
	}
	
	public static void print(Object o, Color color) {
		print(o,"", console.getDefaultFont(), color);
	}
	
	public static void print(Object o, Font font) {
		print(o,"", font, console.getDefaultColor());
	}
	
	public static void print(Object o, Font font, Color color) {
		print(o,"",font, color);
	}
	

	public static void println(Object o) {
		print(o,"\n", console.getDefaultFont(), console.getDefaultColor());
	}
	
	public static void println(Object o, Color color) {
		print(o,"\n", console.getDefaultFont(), color);
	}
	
	public static void println(Object o, Font font) {
		print(o,"\n", font, console.getDefaultColor());
	}
	
	public static void println(Object o, Font font, Color color) {
		print(o,"\n",font, color);
	}
	
	
	/*
	 * Initialisation des variables
	 */
	private static void loadFontProperties() {
		debugColor = Color.CYAN;
		warnColor = Color.YELLOW;
		debugFont = console.getDefaultFont();
		warnFont = console.getDefaultFont();
		outInterceptor = new ConsoleOut(System.out,console);
		errInterceptor = new ConsoleErr(System.err,console);
		
	}

	public static void load() {
		console = new ConsoleGUI();
		loadFontProperties();
	}

	public static void close() {
		if(console != null) console.close();
		console = null;
	}
}
