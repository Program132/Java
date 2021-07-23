package fr.beyptitloup.armorstand;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

public class SpawnArmorstandCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemMeta helmetMeta = helmet.getItemMeta();
			helmetMeta.setDisplayName("Helmet du Best ArmorStand");
			helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			helmet.setItemMeta(helmetMeta);
			
			Location loc = plr.getLocation();
			
			ArmorStand as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
			as.setCustomName("Best ArmorStand");
			as.setHelmet(helmet);
			as.setVisible(true);
			
			
			
			Location l2 = loc;
			l2.setZ(loc.getZ() + 2);
			l2.setX(loc.getX() + 2);
			
			ArmorStand as2 = (ArmorStand) loc.getWorld().spawnEntity(l2, EntityType.ARMOR_STAND);
			as2.setCustomName("Best ArmorStand");
			as2.setHelmet(helmet);
			as2.setVisible(false);
			
			
			
			Location l3 = loc;
			l3.setZ(loc.getZ() + 4);
			l3.setX(loc.getX() + 4);
			
			ArmorStand as3 = (ArmorStand) loc.getWorld().spawnEntity(l3, EntityType.ARMOR_STAND);
			as3.setArms(true);
			as3.setCustomName("Best ArmorStand");
			as3.setHelmet(helmet);
			as3.setVisible(true);
			as3.setRightArmPose(new EulerAngle(3, 1, 5));
		} else {
			sender.sendMessage("Vous devez etre un joueur !");
		}
		
		return false;
	}

}
