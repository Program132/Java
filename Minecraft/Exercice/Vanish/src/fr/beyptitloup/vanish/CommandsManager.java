package fr.beyptitloup.vanish;

public class CommandsManager {

	public static void register(VanishMain instance) {
		instance.getCommand("vanish").setExecutor(new CmdVanish());
	}

}
