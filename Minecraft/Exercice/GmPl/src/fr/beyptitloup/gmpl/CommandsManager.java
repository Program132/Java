package fr.beyptitloup.gmpl;

import fr.beyptitloup.gmpl.commands.CommandCreative;

public class CommandsManager {

	public static void register(GmPl instance) {
		instance.getCommand("gm").setExecutor(new CommandCreative());
	}
}
