package fr.beyptitloup.particules;

public class CommandsManager {

	public static void register(Particules instance) {
		instance.getCommand("do").setExecutor(new Do());
	}

}
