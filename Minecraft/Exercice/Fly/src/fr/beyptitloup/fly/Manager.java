package fr.beyptitloup.fly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {

	private static Fly instance;
	private Manager manager;

	public void load(Fly instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Fly]" + ChatColor.WHITE + " Plugin lance!");
		
		CommandsManager.register(instance);
	}
	
	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Fly]" + ChatColor.WHITE + " Plugin eteint!");
	}
	
	public static Fly getInstance() { return instance; }
	
	public Manager getManager() { return manager; }
}
