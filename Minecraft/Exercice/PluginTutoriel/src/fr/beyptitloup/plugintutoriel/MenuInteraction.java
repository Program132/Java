package fr.beyptitloup.plugintutoriel;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuInteraction implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player plr = (Player) event.getWhoClicked();
		ItemStack item = event.getCurrentItem();
		
		if (inv.getName().equalsIgnoreCase("Menu"))
		{
			event.setCancelled(true);
			plr.closeInventory();
			
			if(item.getType() == Material.REDSTONE) {
				plr.getInventory().addItem(new ItemStack(Material.REDSTONE, 64));
			} else if(item.getType() == Material.GLASS) {
				plr.setGameMode(GameMode.SURVIVAL);
			}
		}
	}
}
