package fr.beyptitloup.brainffa;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.md_5.bungee.api.ChatColor;

public class CmdJoin implements CommandExecutor {
	
	private static BrainFFAMain instance = Manager.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player plr = (Player) sender;
			
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta swordMeta = sword.getItemMeta();
			swordMeta.setDisplayName("Sword BrainFFA");
			swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
			swordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
			sword.setItemMeta(swordMeta);
			
			ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta pickaxeMeta = pickaxe.getItemMeta();
			pickaxeMeta.setDisplayName("Pickaxe BrainFFA");
			pickaxe.setItemMeta(pickaxeMeta);
			
			ItemStack goldapple = new ItemStack(Material.GOLDEN_APPLE, 64);
			
			ItemStack blocs = new ItemStack(Material.SANDSTONE, 64);
			
			plr.getInventory().clear();
			plr.getInventory().addItem(sword);
			plr.getInventory().addItem(pickaxe);
			plr.getInventory().addItem(goldapple);
			
			for (int i = 0; i < 6; i++) {
				plr.getInventory().addItem(blocs);
			}
			
			Location loc = null;
			
			Random rand = new Random(); 
			int value = rand.nextInt(4); 
			
			if (value == 0) {
				loc = new Location(plr.getWorld(), 144, 92, 295);
			} else if (value == 1) {
				loc = new Location(plr.getWorld(), 151, 92, 302);
			} else if (value == 2) {
				loc = new Location(plr.getWorld(), 144, 92, 309);
			} else if (value == 3) {
				loc = new Location(plr.getWorld(), 138, 92, 302);
			}
			
			plr.teleport(loc);
			
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Objective objective = board.registerNewObjective("test", "dummy");
			objective.setDisplayName("BRAIN FFA");
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			Score score = objective.getScore(ChatColor.GREEN + "Player Kills:"); 
			score.setScore(instance.getConfig().getInt("player." + plr.getName() + ".kills"));
			plr.setScoreboard(board);

			
			
		} else {
			sender.sendMessage(ChatColor.RED + "[BrainFFA]" + ChatColor.WHITE + " You must be a player!");
		}
		return false;
	}

}
