package fr.beyptitloup.armorstand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
	
	private static Armorstand instance;
	private Manager manager;

	public void load(Armorstand instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Armorstand]" + ChatColor.WHITE + " Plugin lance!");
		
		CommandsManager.register(instance);
		
	}

	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Armorstand]" + ChatColor.WHITE + " Plugin eteint!");
	}
	
	public static Armorstand getInstance() { return instance; }
	
	public Manager getManager() { return manager; }
}
