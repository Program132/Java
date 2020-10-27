import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	public Fenetre()
	{
		int size = 400;
		
		// JFrame
		
		this.setTitle("Fenetre avec un background");
		this.setSize(size, size);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// JPanel
		
		JPanel jp = new JPanel();
		jp.setBackground(Color.BLUE);
		
		
		// Affichage
		
		this.setContentPane(jp);
		this.setVisible(true);
	}
}
