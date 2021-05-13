package fr.beyptitloup.lobpl;

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
			int x = ConfigBuild.getInt("location.x");
			int y = ConfigBuild.getInt("location.yy");
			int z = ConfigBuild.getInt("location.z");
			Location lobby = new Location(plr.getWorld(), x, y ,z);
			plr.teleport(lobby);
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "[LobPl]" + ChatColor.WHITE + " You must be a player !");
		}
		return false;
	}

}