/**
 * 
 */
package gui.window;

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
		this.setSize( 1000, 700 ); 
		this.setLocationRelativeTo( null ); 
		
		 
        
        
        
        // exit 
        this.setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE ); 
        
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
