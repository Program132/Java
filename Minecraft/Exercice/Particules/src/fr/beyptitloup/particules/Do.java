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
	
	private Particules instance;
	
	public Do(Particules instance) {
		this.instance = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("flame")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " flame");
					
					Location loc = plr.getLocation();
					Effect effect = Effect.FLAME;
					
					for (double t = 0; t < 50; t += 0.5) {
						float radius = 1f;
						float x =  radius*(float)Math.sin(t);
						float z = radius*(float)Math.cos(t);
						
						PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true, (float) loc.getX() + x, 
								(float) loc.getY(), (float) loc.getZ() + z, 0, 0, 0, 0, 1);
						
						((CraftPlayer)plr).getHandle().playerConnection.sendPacket(particle);
					}
					
				} else if (args[0].equalsIgnoreCase("note")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " note");
					
					Location loc = plr.getLocation();
					
					for (int i = 0; i < 360; i += 5) {
						Location nloc = loc;
						nloc.setY(plr.getLocation().getY() + 2);
	                    loc.getWorld().playEffect(nloc, Effect.NOTE, 1);
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
				} else if (args[0].equalsIgnoreCase("spamcircu")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " spamcircu");
					
					Effect effect = Effect.FLAME;
					
					instance.spamCircle(plr, effect);
					
				} else if (args[0].equalsIgnoreCase("followcircu")) {
					plr.sendMessage("Vous venez d'utiliser la particule : "+ ChatColor.RED + " followcircu");
					
					Effect effect = Effect.FLAME;
					
					instance.followCircle(plr, 1, effect);
					
				} else {
					plr.sendMessage("Mettez un argument !");
				}	
			}
		} else {
			sender.sendMessage("Vous devez etre un joueur pour utiliser cette commande !");
		}
		
		return false;
	}

}