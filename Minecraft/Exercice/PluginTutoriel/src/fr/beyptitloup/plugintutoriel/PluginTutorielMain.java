package fr.beyptitloup.plugintutoriel;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginTutorielMain extends JavaPlugin{
	Manager manager = new Manager();
	
	@Override
	public void onEnable() { 
		manager.load(this); 
	}
	
	@Override
	public void onDisable() { manager.unload(); }
}