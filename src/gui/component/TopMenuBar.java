/**
 * 
 */
package gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;


/**
 * @author CLEm
 *
 */
public class TopMenuBar {
	
	private JMenuBar menuBar; 
	private JMenu menu; 
	private JMenuItem menuItem; 
	
	private controleur.handler.HandleNouvellePartie handleNouvellePartie;
	private controleur.handler.HandleQuiter handleQuiter; 
	
	public TopMenuBar( javax.swing.JFrame parentFrame ){
        menuBar = new JMenuBar();

        //*/ Fichier 
        menu = new JMenu( "Fichier" ); 
        
        menu.setMnemonic( KeyEvent.VK_F ); 
        menu.getAccessibleContext().setAccessibleDescription( 
        	"Fichier de l'emploi du temps" 
        ); 
        menuBar.add( menu ); 
        {
	        // Nouveau 
			menuItem = new JMenuItem( "Nouvelle partie..." ); 
				
				handleNouvellePartie = new controleur.handler.HandleNouvellePartie(); 
				menuItem.addActionListener( handleNouvellePartie ); 
				
				menuItem.setMnemonic( KeyEvent.VK_N ); 
				menuItem.setAccelerator( 
					KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ) 
				); 
				menuItem.getAccessibleContext().setAccessibleDescription( 
					"Créer" 
				); 

			menu.add( menuItem );
			
			// Separator
			menu.add( new JSeparator() );
			
			// Quit 
			menuItem = new JMenuItem( "Quitter" ); 
				
				handleQuiter = new controleur.handler.HandleQuiter( parentFrame ); 
				menuItem.addActionListener( handleQuiter ); 
				
				menuItem.setMnemonic( KeyEvent.VK_Q );
				menuItem.setAccelerator( 
					KeyStroke.getKeyStroke( KeyEvent.VK_F4, ActionEvent.ALT_MASK ) 
				); 
				menuItem.getAccessibleContext().setAccessibleDescription( 
					"Quitter" 
				); 
				
			menu.add( menuItem ); 
        }
        //*/ 
        
	}
	
	public JMenuBar getMenuBar(){
		return menuBar; 
	}
	
}
