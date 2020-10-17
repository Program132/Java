public class Moto extends Vehicule{
	String n;
	int r;
	int v;
	
	// Principal
	
	public Moto()
	{	
		if (n != null)
		{
			affichage();
		}
		else
		{
			System.out.println("Waiting...");
		}
		
	}
	
	public void affichage()
	{
		getR();
		getName();
		getV();
		System.out.println("Le nom : " + n);
		System.out.println("Le nombre de roue : " + r);
		System.out.println("La vitesse maximal : " + v);
	}
	
	//Prendre
	
	public String getName()
	{
		return n;
	}
	
	public int getR()
	{
		return r;
	}
	
	public int getV()
	{
		return v;
	}
	
	
	// Mettre à jour
	
	public String setN(String na)
	{
		n = na;
		return n;
		
	}
	
	public int setV(int vi)
	{
		v = vi;
		return v;
	}
	
	public int setR(int ro)
	{
		r = ro;
		return r;
	}
}