package fr.beyptitloup.vanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Manager {
	
	private static VanishMain instance;
	private Manager manager;

	public void load(VanishMain instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Vanish]" + ChatColor.WHITE + " Vanish Plugin started !");
		
		CommandsManager.register(instance);
	}
	
	public static VanishMain getInstance() { return instance; }
	
	public Manager getManager() { return manager; }

	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[Vanish]" + ChatColor.WHITE + " Vanish Plugin closes !");
	}
}
