package fr.beyptitloup.gmpl.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCreative implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("1")) {
					plr.setGameMode(GameMode.CREATIVE);
					return false;
				} else if (args[0].equalsIgnoreCase("2")) {
					plr.setGameMode(GameMode.ADVENTURE);
					return false;
				} else if (args[0].equalsIgnoreCase("0")) {
					plr.setGameMode(GameMode.SURVIVAL);
					return false;
				} else {
					plr.sendMessage(ChatColor.DARK_RED + "[GmPl]" + ChatColor.WHITE + " Gamemode not found !");
					return false;
				}
			} else {
				plr.sendMessage(ChatColor.DARK_RED + "[GmPl]" + ChatColor.WHITE + " Give me an argument : 1, 2 or 3 !");
				return false;
			}
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "[GmPl]" + ChatColor.WHITE + " You must be a player !");
		}
		return false;
	}

}