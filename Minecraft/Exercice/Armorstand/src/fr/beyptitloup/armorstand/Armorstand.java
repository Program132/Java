package fr.beyptitloup.armorstand;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Armorstand extends JavaPlugin {
	
	Manager manager = new Manager();
	
	
	@Override
	public void onEnable() {
		manager.load(this);
	}
	
	@Override
	public void onDisable() {
		manager.unload();
	}
	
	
    public void followAS(Player plr, ArmorStand as) {
        new BukkitRunnable() {
            int t = 0;


            @Override
            public void run() {
                Location loc = plr.getLocation();
                
                t += 5;
                
                int size = 2;

                float radius = (float) Math.toRadians(t);
                
                float x =  size*(float)Math.sin(radius);
                float z = size*(float)Math.cos(radius);
                
                x += loc.getX();
                z += loc.getZ();
                
                Location finalloc = new Location(plr.getWorld(), x, loc.getY() - 1, z);
                
                as.teleport(finalloc); 
            }
        }.runTaskTimer(this, 0, 1);
    }
    
    public void waiting(Player plr, ArmorStand as, ArmorStand as2, ArmorStand as3, ArmorStand as4) {
        new BukkitRunnable() {
            
            int stop = 0;
            
            @Override
            public void run() {
                stop++;
                
                if (stop == 5) {
                    cancel();
                } else if (stop == 4) {
                    followAS(plr, as4);
                } else if (stop == 3) {
                    followAS(plr, as3);
                } else if (stop == 2) {
                    followAS(plr, as2);
                } else if (stop == 1) {
                    followAS(plr, as);
                }
                
            }
        }.runTaskTimer(this, 0, 10);
    }
}
