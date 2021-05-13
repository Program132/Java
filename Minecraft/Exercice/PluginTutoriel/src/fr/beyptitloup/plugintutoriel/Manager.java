package fr.beyptitloup.plugintutoriel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
	
	private static PluginTutorielMain instance;
	private Manager manager;

	public void load(PluginTutorielMain instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[PluginTuto]" + ChatColor.WHITE + " Serveur lance!");
		
		instance.saveDefaultConfig();
		
		CommandsManager.register(instance);
		
		EventsManager.register(instance);
	}

	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[PluginTuto]" + ChatColor.WHITE + " Serveur eteint!");
	}
	
	public static PluginTutorielMain getInstance() { return instance; }
	
	public Manager getManager() { return manager; }

}
