package fr.beyptitloup.particules;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;


public class Do implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("flame360")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " flame360");
					
					Location loc = plr.getLocation();
					
					for (int i = 0; i < 360; i += 5) {
						Location flameloc = loc;
						flameloc.setZ(flameloc.getZ() + Math.cos(i)*5);
	                    flameloc.setX(flameloc.getX() + Math.sin(i)*5);
	                    loc.getWorld().playEffect(flameloc, Effect.FLAME, 51);
					}
					
				} else if (args[0].equalsIgnoreCase("note")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " note");
					
					Location loc = plr.getLocation();
					
					for (int i = 0; i < 360; i += 5) {
						Location flameloc = loc;
						flameloc.setY(plr.getLocation().getY() + 2);
	                    loc.getWorld().playEffect(flameloc, Effect.NOTE, 51);
					}
				} else if (args[0].equalsIgnoreCase("circulaire")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " circulaire");
					
					Location loc = plr.getLocation();
					
					for (double t = 0; t < 50; t += 0.5) {
						float radius = 1f;
						float x =  radius*(float)Math.sin(t);
						float z = radius*(float)Math.cos(t);
						
						PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true, (float) loc.getX() + x, 
								(float) loc.getY(), (float) loc.getZ() + z, 0, 0, 0, 0, 1);
						
						((CraftPlayer)plr).getHandle().playerConnection.sendPacket(particle);
					}
				} else {
					plr.sendMessage("Mettez un argument : " + ChatColor.BLUE + "flame360" + ChatColor.WHITE + ", " + ChatColor.BLUE + "note" + ChatColor.WHITE + ", " + ChatColor.BLUE + "circulaire");
				}	
			}
		} else {
			sender.sendMessage("Vous devez etre un joueur pour utiliser cette commande !");
		}
		
		return false;
	}

}