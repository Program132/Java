package createClass;

public class main {
	public static void main(String[] args)
	{
		Personnage perso = new Personnage("Program", 'f', 18);
		
		System.out.println(perso.getName()); // R�cup�rer un nom 
		System.out.println(perso.getSexe()); // R�cup�rer le sexe
		System.out.println(perso.getAge()); // R�cup�rer l'�ge
		
		Personnage perso2 = new Personnage( // D�clarer sur plusieurs lignes
				"Program#1807", // Le nom
				'm', //Le sexe du personnage
				50); // L'�ge
		
		System.out.println(perso2.name); // R�cup�rer le nom du personnage
	}
}
