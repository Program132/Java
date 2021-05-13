package fr.beyptitloup.plugintutoriel;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoin implements Listener {
	
	private PluginTutorielMain main;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player plr = event.getPlayer();
		
		plr.getInventory().clear();
		
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta metaSword = sword.getItemMeta();
		metaSword.setDisplayName("L'épée du futur !");
		metaSword.setLore(Arrays.asList("1ère ligne", "2ème ligne", "la dernière ligne !"));
		sword.setItemMeta(metaSword);
		
		plr.getInventory().addItem(sword);	
		plr.updateInventory();
		
		event.setJoinMessage(ConfigBuild.getString("messages.welcome"));
	}
	
	public void onQuit(PlayerQuitEvent event) {
		Player plr = event.getPlayer();
		event.setQuitMessage(ConfigBuild.getString("messages.quit"));
	}
}
