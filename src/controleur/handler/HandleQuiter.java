/**
 * 
 */
package controleur.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author CLEm
 *
 */
public class HandleQuiter implements ActionListener {
	
	private javax.swing.JFrame parentFrame;
	
	public HandleQuiter( javax.swing.JFrame parentFrame  ) {
		this.parentFrame = parentFrame; 
	}
	
	public void actionPerformed( ActionEvent context ) { 
		
		this.parentFrame.dispose();

//		System.exit(0); 
		
	}
}
