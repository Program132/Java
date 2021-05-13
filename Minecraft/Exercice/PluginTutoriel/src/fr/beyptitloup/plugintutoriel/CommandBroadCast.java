package fr.beyptitloup.plugintutoriel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBroadCast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender senders, Command cmd, String label, String[] args) {
		if(senders instanceof Player) {
			Player plr = (Player) senders;
			if (plr.hasPermission("broadcast.use")) {
				if (args.length == 0) {
					plr.sendMessage(ChatColor.RED + "[PluginTuto] " + ChatColor.WHITE + "Format correcte : " + ChatColor.GREEN + "/broadcast (message)" + ChatColor.WHITE + " !");
					return false;
				}
				Bukkit.broadcastMessage(ChatColor.RED + "[Information] " + ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', String.join(" ", args)));
				return false;
			} else {
				plr.sendMessage(ChatColor.RED + "[PluginTuto] " + ChatColor.WHITE + "Vous n'avez pas la permission d'exécuter cette commande !");
				return false;
			}
		} else {
			senders.sendMessage(ChatColor.RED + "[PluginTuto] " + ChatColor.WHITE + "Vous devez etre un joueur !");
		}
		return false;
	}

}