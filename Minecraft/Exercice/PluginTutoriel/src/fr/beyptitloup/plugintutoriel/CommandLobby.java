package fr.beyptitloup.plugintutoriel;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLobby implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			Location loc = new Location(plr.getWorld(), 161.28262, 76.000, 271.47367, 271f, 15f);
			plr.teleport(loc);
			plr.sendMessage(ChatColor.RED + "[PluginTuto] " + ChatColor.WHITE + "Vous venez d'être téléporté !");
		} else {
			sender.sendMessage(ChatColor.RED + "[PluginTuto] " + ChatColor.WHITE + "Vous devez etre un joueur");
		}
		return false;
	}

}
