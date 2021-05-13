package fr.beyptitloup.lobpl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
	
	private static LobPlMain instance;
	private Manager manager;

	public void load(LobPlMain instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[LobPl]" + ChatColor.WHITE + " Plugin lance!");
		
		CommandsManager.register(instance);
		
		instance.saveDefaultConfig();
	}

	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[LobPl]" + ChatColor.WHITE + " Plugin eteint!");
	}
	
	public static LobPlMain getInstance() { return instance; }
	
	public Manager getManager() { return manager; }

}