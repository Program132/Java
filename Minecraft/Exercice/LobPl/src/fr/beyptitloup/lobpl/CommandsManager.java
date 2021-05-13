package fr.beyptitloup.lobpl;

public class CommandsManager {

	public static void register(LobPlMain instance) {
		instance.getCommand("setlobby").setExecutor(new CommandSetLobby());
		instance.getCommand("lobby").setExecutor(new CommandLobby());
	}
}
