package fr.beyptitloup.vanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdVanish implements CommandExecutor {
	
	private void errorArgVanish(Player plr) {
		plr.sendMessage(ChatColor.DARK_RED + "[Vanish]" + ChatColor.WHITE + " You must give a argument : on or off !");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on"))
				{
					for (Player plrs : Bukkit.getOnlinePlayers()) {
						plrs.hidePlayer(plr);
						plr.sendMessage(ChatColor.DARK_RED + "[Vanish]" + ChatColor.WHITE + " You are now invisible !");
					}
				} else if (args[0].equalsIgnoreCase("off"))
				{
					for (Player plrs : Bukkit.getOnlinePlayers()) {
						plrs.showPlayer(plr);
						plr.sendMessage(ChatColor.DARK_RED + "[Vanish]" + ChatColor.WHITE + " You are now visible !");
					}
				} else {
					errorArgVanish(plr);
				}
			} else {
				errorArgVanish(plr);
			}
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "[Vanish]" + ChatColor.WHITE + " You must be a player !");
		}
		return false;
	}

}