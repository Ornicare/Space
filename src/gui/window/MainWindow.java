/**
 * 
 */
package gui.window;

//import gui.component.ButtonPlay;

/**
 * @author CLEm
 *
 */
public class MainWindow extends javax.swing.JFrame {

	/**
	 * generated serial version ID 
	 */
	private static final long serialVersionUID = 3234852817461869766L;

	public MainWindow() {
		this.setTitle( "Space" ); 
		this.setSize( 800, 600 ); 
		this.setLocationRelativeTo( null ); 
		
		// *** components ***
			// top menu bar 
        	this.setJMenuBar( new gui.component.TopMenuBar(this).getMenuBar() );
        
        	// button: play
        	
        
        
		
        // exit 
        this.setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE ); 
        
        // draw 
		this.setVisible( true ); 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainWindow testMainWindow = new MainWindow();
	}

}
