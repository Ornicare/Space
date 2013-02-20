package Console;
import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;


public abstract class ConsoleInterceptor extends PrintStream{

	protected PrintStream originalPrintStream;
	protected ConsoleGUI console;
	protected Color color;
	protected Font font;
	
	/** 
     * Class constructor.
     */
	public ConsoleInterceptor(PrintStream originalPrintStream, ConsoleGUI console, Color color,Font font) {
		super(originalPrintStream);
		this.originalPrintStream = originalPrintStream;
		this.console=console;
		this.color=color;
		this.font=font;
	}
	
	
	public void println(String o) {
		originalPrintStream.println(o);
		console.addText(o+"\n",font,color);
	}
	
	public void print(String o) {
		originalPrintStream.print(o);
		console.addText(o,font,color);
	}

	// Object
	public void println(Object o) {
		originalPrintStream.println(o);
		console.addText(o.toString()+'\n',font,color);

	}

	public void print(Object o) {
		originalPrintStream.print(o);
		console.addText(o.toString(),font,color);
	}

	// Char
	public void println(char o) {
		originalPrintStream.println(o);
		console.addText(o+"\n",font,color);
	}

	public void print(char o) {
		originalPrintStream.print(o);
		console.addText(String.valueOf(o),font,color);
	}

	// Double
	public void println(double o) {
		originalPrintStream.println(o);
		console.addText(String.valueOf(o+"\n"),font,color);
	}

	public void print(double o) {
		originalPrintStream.print(o);
		console.addText(String.valueOf(o),font,color);
	}

	// Float
	public void println(float o) {
		originalPrintStream.println(o);
		console.addText(String.valueOf(o+"\n"),font,color);
	}

	public void print(float o) {
		originalPrintStream.print(o);
		console.addText(String.valueOf(o),font,color);
	}

	// Long
	public void println(long o) {
		originalPrintStream.println(o);
		console.addText(String.valueOf(o+"\n"),font,color);
	}

	public void print(long o) {
		originalPrintStream.print(o);
		console.addText(String.valueOf(o),font,color);
	}

	// Int
	public void println(int o) {
		originalPrintStream.println(o);
		console.addText(String.valueOf(o+"\n"),font,color);
	}

	public void print(int o) {
		originalPrintStream.print(o);
		console.addText(String.valueOf(o),font,color);
	}

	// Boolean
	public void println(boolean o) {
		originalPrintStream.println(o);
		console.addText(String.valueOf(o+"\n"),font,color);
	}

	public void print(boolean o) {
		originalPrintStream.print(o);
		console.addText(String.valueOf(o),font,color);
	}

	// Vide
	public void println() {
		console.addText("\n",font,color);
		originalPrintStream.println();
	}

}
