package fr.beyptitloup.plugintutoriel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

	public static void register(PluginTutorielMain instance) {
		// TODO Auto-generated method stub
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new PlayerJoin(), instance);
		pm.registerEvents(new Interaction(), instance);
		pm.registerEvents(new MenuInteraction(), instance);
	}
}
