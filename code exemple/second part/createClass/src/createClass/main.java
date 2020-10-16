package createClass;

public class main {
	public static void main(String[] args)
	{
		Personnage perso = new Personnage("Program", 'f', 18);
		
		System.out.println(perso.getName()); // Récupérer un nom 
		System.out.println(perso.getSexe()); // Récupérer le sexe
		System.out.println(perso.getAge()); // Récupérer l'âge
		
		Personnage perso2 = new Personnage( // Déclarer sur plusieurs lignes
				"Program#1807", // Le nom
				'm', //Le sexe du personnage
				50); // L'âge
		
		System.out.println(perso2.name); // Récupérer le nom du personnage
	}
}
