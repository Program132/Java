import javax.swing.JFrame;

public class main {
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		int size = 400;
		
		f.setTitle("First Interface"); // Ajout d'un titre
		f.setSize(size, size); //On change la dimension
		f.setLocationRelativeTo(null); //On met au centre
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On termine le programe quand on ferme l'interface
		f.setVisible(true); // Rend visible
	}
}
