package fr.beyptitloup.brainffa;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CmdLeave implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			plr.getInventory().clear();
			
			Location loc = new Location(plr.getWorld(), 161, 76, 271);
			plr.teleport(loc);
		} else {
			sender.sendMessage(ChatColor.RED + "[BrainFFA]" + ChatColor.WHITE + " You must be a player!");
		}
		return false;
	}

}
