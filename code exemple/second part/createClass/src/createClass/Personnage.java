package createClass;

public class Personnage {
	
	// Constructor
	
	String name;
	char sexe;
	int age;
	
	// Class principal
	
	public Personnage(String n, char s, int a)
	{
		System.out.println("Personnage in create...");
		name = n;
		sexe = s;
		age = a;
		
		if (sexe == 'f')
		{
			System.out.println("Nom : " + name + ", sexe : feminin" + ", age : " + age);
		}
		else if (sexe == 'm')
		{
			System.out.println("Nom : " + name + ", sexe : masculin" + ", age : " + age);
		}
		else
		{
			System.out.println("Le sexe est invalide, utilisé 'f' pour féminin ou 'm' pour masculin.");
		}
		
	}
	
	// Function
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getSexe()
	{
		if (sexe == 'f')
		{
			String s = "féminin";
			return s;
		}
		else if (sexe == 'm')
		{
			String m = "masculin";
			return m;
		}
		else
		{
			System.out.println("Sexe invalide.");;
		}
		
		return name;
		
	}
}
