package fr.beyptitloup.particules;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

public class Particules extends JavaPlugin {
	Manager manager = new Manager();
	
	@Override
	public void onEnable() {
		manager.load(this);
	}
	
	@Override
	public void onDisable() {
		manager.unload();
	}
	
	
	
	// Particle
	
	public void spamCircle(Player plr) {
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Location loc = plr.getLocation();
				
				for (double t = 0; t < 50; t += 0.5) {
					float radius = 1f;
					float x =  radius*(float)Math.sin(t);
					float z = radius*(float)Math.cos(t);
					
					PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true, (float) loc.getX() + x, 
							(float) loc.getY(), (float) loc.getZ() + z, 0, 0, 0, 0, 1);
					
					((CraftPlayer)plr).getHandle().playerConnection.sendPacket(particle);
				}
			}
		}.runTaskTimer(this, 0, 14);
		
	}
	
	public void followCircle(Player plr) {

        new BukkitRunnable() {
            int t = 0;


            @Override
            public void run() {
            	Location loc = plr.getLocation();
            	
            	int size = 3;
            	
                t += 5;

                float radius = (float) Math.toRadians(t);
                
                float x =  size*(float)Math.sin(radius);
				float z = size*(float)Math.cos(radius);
                
				PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.FLAME, true, (float) loc.getX() + x, 
						(float) loc.getY(), (float) loc.getZ() + z, 0, 0, 0, 0, 1);
				
				((CraftPlayer)plr).getHandle().playerConnection.sendPacket(particle);
            }
        }.runTaskTimer(this, 0, 1);
    }
	
	public void spamNote(Player plr) {
		new BukkitRunnable() {

			@Override
			public void run() {
				Location loc = plr.getLocation();
				
				Location locParticle = new Location(plr.getWorld(), loc.getX(), loc.getY() + 2, loc.getZ());
				loc.getWorld().playEffect(locParticle, Effect.NOTE, 1);
				
				Location locParticle2 = new Location(plr.getWorld(), loc.getX() + 2, loc.getY() + 2, loc.getZ() + 2);
				loc.getWorld().playEffect(locParticle2, Effect.NOTE, 1);
				
				Location locParticle3 = new Location(plr.getWorld(), loc.getX() - 2, loc.getY() + 2, loc.getZ() - 2);
				loc.getWorld().playEffect(locParticle3, Effect.NOTE, 1);
			}
			
		}.runTaskTimer(this, 0, 10);
	}
	
	public void spamExplosion(Player plr) {
		new BukkitRunnable() {

			@Override
			public void run() {
				Location loc = plr.getLocation();
				
				Location locParticle2 = new Location(plr.getWorld(), loc.getX() + 2, loc.getY() + 3, loc.getZ() + 2);
				loc.getWorld().playEffect(locParticle2, Effect.SMOKE, 1);
				
				Location locParticle3 = new Location(plr.getWorld(), loc.getX() - 2, loc.getY() + 3, loc.getZ() - 2);
				loc.getWorld().playEffect(locParticle3, Effect.SMOKE, 1);
			}
			
		}.runTaskTimer(this, 0, 10);
	}
}