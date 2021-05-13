package fr.beyptitloup.duelpl;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class Manager {
	
	private static DuelPlMain instance;
	private Manager manager;

	public void load(DuelPlMain instance) {
		this.instance = instance;
		this.manager = this;
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "[DuelPl]" + ChatColor.WHITE + " DuelPl loading...");
		
		CommandsManager.register(instance);
	}

	public void unload() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_BLUE + "[DuelPl]" + ChatColor.WHITE + " DuelPl closes...");
	}

}
