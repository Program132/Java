package fr.beyptitloup.brainffa;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class Manager {
	
	private static BrainFFAMain instance;
	private Manager manager;

	public void load(BrainFFAMain instance) {
		this.instance = instance;
		this.manager = this;
		
		instance.saveDefaultConfig();
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[BrainFFA]" + ChatColor.WHITE + " BrainFFA loaded!");
		
		CommandsManager.register(instance);
		EventsManager.register(instance);
	}

	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[BrainFFA]" + ChatColor.WHITE + " BrainFFA closes!");
	}
	
	public static BrainFFAMain getInstance() { return instance; }
	
	public Manager getManager() { return manager; }
	
}
