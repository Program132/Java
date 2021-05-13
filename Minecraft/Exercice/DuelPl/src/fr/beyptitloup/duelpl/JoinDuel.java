package fr.beyptitloup.duelpl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class JoinDuel implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName("Fight Sword");
			swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
			sword.setItemMeta(swordMeta);
			
			Location loc = new Location(plr.getWorld(), 160, 83, 280);
			plr.teleport(loc);
			
			plr.getInventory().clear();
			plr.getInventory().addItem(sword);
			
			plr.sendMessage(ChatColor.DARK_BLUE + "[DuelPl]" + ChatColor.WHITE + " Good luck for the fight !");
		} else {
			sender.sendMessage(ChatColor.DARK_BLUE + "[DuelPl]" + ChatColor.WHITE + " You must be a player !");
		}
		return false;
	}
}