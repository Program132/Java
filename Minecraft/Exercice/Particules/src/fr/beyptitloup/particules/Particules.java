package fr.beyptitloup.particules;

import org.bukkit.plugin.java.JavaPlugin;

public class Particules extends JavaPlugin {
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
