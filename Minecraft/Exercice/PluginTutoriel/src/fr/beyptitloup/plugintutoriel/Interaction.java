package fr.beyptitloup.plugintutoriel;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Interaction implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent event)  {
		Player plr = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if (it == null) return;
		
		if (it.getType() == Material.DIAMOND_SWORD) {
			if (action == Action.RIGHT_CLICK_AIR) {
				plr.sendMessage("Vous vous protégez !");
			} else if (action == action.LEFT_CLICK_AIR) {
				plr.sendMessage("Vous balancez un laser !");
			}
		} else if (it.getType() == Material.ARROW) {
			if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
				Inventory menu = Bukkit.createInventory(null, 27, "Menu");
				
				ItemStack redstone = new ItemStack(Material.REDSTONE, 1);
				ItemMeta metaRed = redstone.getItemMeta();
				metaRed.setDisplayName("Give 64x Redstone");
				redstone.setItemMeta(metaRed);
				
				ItemStack spec = new ItemStack(Material.GLASS, 1);
				ItemMeta metaSpec = spec.getItemMeta();
				metaSpec.setDisplayName("Gamemode Survival");
				spec.setItemMeta(metaSpec);
				
				menu.setItem(11, redstone);
				menu.setItem(14, spec);
				
				plr.openInventory(menu);
			}
		}
	}
}
