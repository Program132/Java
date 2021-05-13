package fr.beyptitloup.plugintutoriel;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender senders, Command cmd, String label, String[] args) {
		if(senders instanceof Player) {
			Player plr = (Player) senders;
			plr.sendMessage("Bravo vous avez réussi le test !");
		} else {
			senders.sendMessage(ChatColor.RED + "[PluginTuto] " + ChatColor.WHITE + "Vous devez etre un joueur");
		}
		return false;
	}

}
