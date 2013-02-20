package Console;
import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;


/**
 * Used to intercept System.out
 * 
 * @author Ornicare
 *
 */
public class ConsoleOut extends ConsoleInterceptor{
	
	public ConsoleOut(PrintStream originalPrintStream, ConsoleGUI console, Color color,Font font) {
		super(originalPrintStream,console,color,font);
		System.setOut(this);
	}
	
	public ConsoleOut(PrintStream originalPrintStream, ConsoleGUI console) {
		super(originalPrintStream,console,console.getDefaultColor(),console.getDefaultFont());
		System.setOut(this);
	}
	
	public ConsoleOut(PrintStream originalPrintStream, ConsoleGUI console, Color color) {
		super(originalPrintStream,console,color,console.getDefaultFont());
		System.setOut(this);
	}
	
	public ConsoleOut(PrintStream originalPrintStream, ConsoleGUI console, Font font) {
		super(originalPrintStream,console,Color.RED,font);
		System.setOut(this);
	}
	
	//Restore the old PrintStream.
	public void finalize()
    {
         System.setOut(originalPrintStream); 
    }

}
