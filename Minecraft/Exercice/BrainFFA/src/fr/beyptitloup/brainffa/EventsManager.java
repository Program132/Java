package fr.beyptitloup.brainffa;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

	public static void register(BrainFFAMain instance) {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), instance);
	}

}