package fr.beyptitloup.duelpl;

public class CommandsManager {

	public static void register(DuelPlMain instance) {
		instance.getCommand("join").setExecutor(new JoinDuel());
	}

}
