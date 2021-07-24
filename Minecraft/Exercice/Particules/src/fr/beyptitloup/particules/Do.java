package fr.beyptitloup.particules;

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
					Location loc = plr.getLocation();
					
					for (int i = 0; i < 360; i += 5) {
						Location nloc = loc;
						nloc.setY(plr.getLocation().getY() + 2);
	                    loc.getWorld().playEffect(nloc, Effect.NOTE, 1);
					}
					
				} else if (args[0].equalsIgnoreCase("circulaire")) {
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
					instance.spamCircle(plr);
				} else if (args[0].equalsIgnoreCase("spamnote")) {
					instance.spamNote(plr);
				} else if (args[0].equalsIgnoreCase("spamexplo")) {
					instance.spamExplosion(plr);
				} else if (args[0].equalsIgnoreCase("followcircu")) {
					instance.followCircle(plr);
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