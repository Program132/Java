package fr.beyptitloup.lobpl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetLobby implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			if (args.length == 3) {
				int X = Integer.parseInt(args[0]);
				int Y = Integer.parseInt(args[1]);
				int Z = Integer.parseInt(args[2]);
				ConfigBuild.set("location.x", X);
				ConfigBuild.set("location.yy", Y);
				ConfigBuild.set("location.z", Z);
				plr.sendMessage(ChatColor.DARK_RED + "[LobPl]" + ChatColor.WHITE + " The location has been updated !");
			} else {
				plr.sendMessage(ChatColor.DARK_RED + "[LobPl]" + ChatColor.WHITE + " Give me three args : X, Y and Z (show on your F3) !");
			}
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "[LobPl]" + ChatColor.WHITE + " You must be a player !");
		}
		return false;
	}

}