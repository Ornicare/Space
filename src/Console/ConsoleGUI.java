package Console;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ConsoleGUI extends JFrame {

	/**
	 * 
	 */
	private Font defaultFont = new Font("Courrier",Font.PLAIN, 12);
	private Color defaultColor = Color.WHITE;
	private Color defaultColorBackground = Color.BLACK;
	
	private StyledDocument doc;
	
	private JPanel container = new JPanel();
	private ArrayList<String> LastMessageList = new ArrayList<String>();
	private JTextPane textPane = new JTextPane();
	private JScrollPane scroll = new JScrollPane(textPane);
	
	private static final long serialVersionUID = 1L;
	
	public Font getDefaultFont() {
		return defaultFont;
	}


	public void setDefaultFont(Font defaultFont) {
		this.defaultFont = defaultFont;
	}


	public Color getDefaultColor() {
		return defaultColor;
	}


	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
	}


	public Color getDefaultColorBackground() {
		return defaultColorBackground;
	}


	public void setDefaultColorBackground(Color defaultColorBackground) {
		this.defaultColorBackground = defaultColorBackground;
	}


	public ConsoleGUI() {
		this.setResizable(false);
		LastMessageList.add("");
		this.setTitle("Console");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		container.add(south, BorderLayout.SOUTH);
		doc = textPane.getStyledDocument();
		
		this.setContentPane(container);
		//textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(defaultColorBackground);
		textPane.setForeground(defaultColor);
		
		setDefaultCloseOperation(close());
		
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}

	
	public void addText(String text) {
		addText(text, defaultFont , defaultColor);
	}
	
	public void addText(String text, Color color) {
		addText(text, defaultFont, color);
	}
	
	public void addText(String text, Font font) {
		addText(text, font, defaultColor);
	}


	public void addText(String text, Font font, Color color) {
		//textPane.setFont(font);
		//setDefaultColor(color);
		//textPane.setForeground(color);
		//textPane.append(text+color.toString());
		Style style = textPane.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style, color);

        try { doc.insertString(doc.getLength(), text,style); }
        catch (BadLocationException e){}

	}


	public int close() {
		setVisible(false);
		dispose();
		return 1;
	}

}