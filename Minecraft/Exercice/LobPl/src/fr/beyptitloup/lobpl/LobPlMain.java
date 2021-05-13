package fr.beyptitloup.lobpl;

import org.bukkit.plugin.java.JavaPlugin;

public class LobPlMain extends JavaPlugin {
	Manager manager = new Manager();
	
	@Override
	public void onEnable() {
		manager.load(this);
	}
	
	public void onDisable() {
		manager.unload();
	}
}
