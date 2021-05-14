package fr.beyptitloup.brainffa;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	private static BrainFFAMain instance = Manager.getInstance();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player plr = event.getPlayer();
		if(!instance.getConfig().isSet("player." + plr.getName() + ".kills")) {
			instance.getConfig().set("player." + plr.getName() + ".kills", 0);
			instance.saveConfig();
			plr.sendMessage("Config set!");
		}
	}
}