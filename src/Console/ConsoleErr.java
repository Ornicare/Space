package Console;
import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;

/**
 * Used to intercept System.err
 * 
 * @author Ornicare
 *
 */
public class ConsoleErr extends ConsoleInterceptor{
	
	public ConsoleErr(PrintStream originalPrintStream, ConsoleGUI console, Color color,Font font) {
		super(originalPrintStream,console,color,font);
		System.setErr(this);
	}
	
	public ConsoleErr(PrintStream originalPrintStream, ConsoleGUI console) {
		super(originalPrintStream,console,Color.RED,console.getDefaultFont());
		System.setErr(this);
	}
	
	public ConsoleErr(PrintStream originalPrintStream, ConsoleGUI console, Color color) {
		super(originalPrintStream,console,color,console.getDefaultFont());
		System.setErr(this);
	}
	
	public ConsoleErr(PrintStream originalPrintStream, ConsoleGUI console, Font font) {
		super(originalPrintStream,console,Color.RED,font);
		System.setErr(this);
	}
	
	//Restore the old PrintStream.
	public void finalize()
    {
         System.setErr(originalPrintStream);
    }
}