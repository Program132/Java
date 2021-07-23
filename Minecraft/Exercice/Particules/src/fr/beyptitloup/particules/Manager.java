package fr.beyptitloup.particules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
	
	private static Particules instance;
	private Manager manager;

	public void load(Particules instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Particules]" + ChatColor.WHITE + " Plugin lance!");
		
		CommandsManager.register(instance);
	}
	
	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Particules]" + ChatColor.WHITE + " Plugin eteint!");
	}
	
	public static Particules getInstance() { return instance; }
	
	public Manager getManager() { return manager; }
}