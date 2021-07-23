package fr.beyptitloup.armorstand;

import org.bukkit.plugin.java.JavaPlugin;

public class Armorstand extends JavaPlugin {
	
	Manager manager = new Manager();
	
	
	@Override
	public void onEnable() {
		manager.load(this);
	}
	
	@Override
	public void onDisable() {
		manager.unload();
	}
	
}
