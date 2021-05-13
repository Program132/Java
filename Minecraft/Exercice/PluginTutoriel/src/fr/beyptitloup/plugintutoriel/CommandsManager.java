package fr.beyptitloup.plugintutoriel;

public class CommandsManager {

	public static void register(PluginTutorielMain instance) {
		instance.getCommand("test").setExecutor(new CommandTest());
		instance.getCommand("broadcast").setExecutor(new CommandBroadCast());
		instance.getCommand("lobby").setExecutor(new CommandLobby());
	}

}
