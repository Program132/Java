package fr.beyptitloup.fly;

public class CommandsManager {

	public static void register(Fly instance) {
		instance.getCommand("flying").setExecutor(new Flying());
	}

}
