package fr.beyptitloup.brainffa;

public class CommandsManager {

	public static void register(BrainFFAMain instance) {
		instance.getCommand("join").setExecutor(new CmdJoin());
		instance.getCommand("leave").setExecutor(new CmdLeave());
	}

}
