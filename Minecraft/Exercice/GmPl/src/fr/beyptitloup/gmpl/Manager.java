package fr.beyptitloup.gmpl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
	
	private static GmPl instance;
	private Manager manager;

	public void load(GmPl instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[GmPl]" + ChatColor.WHITE + " Plugin lance!");
		
		CommandsManager.register(instance);
	}
	
	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[GmPl]" + ChatColor.WHITE + " Plugin eteint!");
	}
	
	public static GmPl getInstance() { return instance; }
	
	public Manager getManager() { return manager; }
}
