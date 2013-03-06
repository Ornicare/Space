/**
 * 
 */
package controleur.handler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cconsole.CConsole;

/**
 * @author CLEm
 *
 */
public class HandleNouvellePartie implements ActionListener {
	public void actionPerformed( ActionEvent context ) { 
		
		CConsole.load();
		
		CConsole.println(getClass(), new Font("Courier", Font.PLAIN, 14), new Color(0,255,255));
		
	}
}
