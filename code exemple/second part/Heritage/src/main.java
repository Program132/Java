public class main {
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Game jeu = new Game();
		ConfigGame config = new ConfigGame("ClavGame", "clavier");
		
		
		
		//Vehicule vehicule = new Vehicule();
		Moto moto1 = new Moto();
		moto1.setN("Moto");
		moto1.setR(4);
		moto1.setV(150);
		moto1.affichage();
	}
}
