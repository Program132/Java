package fr.beyptitloup.fly;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flying implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase("on")) {
					plr.sendMessage("Vous pouvez voler comme un oiseau !");
					plr.setAllowFlight(true);
				} else if (args[0].equalsIgnoreCase("off")) {
					plr.sendMessage("Vous ne pouvez plus voler !");
					plr.setAllowFlight(false);
				} else {
					plr.sendMessage("Vous devez utiliser ces arguments : " + ChatColor.BLUE + "on" + ChatColor.WHITE + " ou " + ChatColor.BLUE + "off" + ChatColor.WHITE + " !");
				}
			} else { 
				plr.sendMessage("Vous devez utiliser ces arguments : " + ChatColor.BLUE + "on" + ChatColor.WHITE + " ou " + ChatColor.BLUE + "off" + ChatColor.WHITE + " !");
			}
			
		} else {
			sender.sendMessage("Vous devez etre un joueur");
		}
		return false;
	}

}
