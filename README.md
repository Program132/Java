### Java

=======================================

# My Java Code !

---------------------------------------

__You can found my project in java :__
>- Base of Java
>- Example discord bot
>- Plugins Minecraft


Example of bases : 

<pre><code>
	import java.util.Scanner;

	public class doublec {
	    public static void main( String [] args ) {
	        Scanner clavier = new Scanner(System.in);
	        System.out.println("Saisissez un nombre à virgule : ");
	        double nbr;
	        nbr = clavier.nextDouble();
	        System.out.println("Vous avez saisie : " + nbr);
	    }
	}
</code></pre>

Example Minecraft Event:

<pre><code>
	package fr.beyptitloup.plugintutoriel;

	import java.util.Arrays;

	import org.bukkit.Material;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.player.PlayerJoinEvent;
	import org.bukkit.event.player.PlayerQuitEvent;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.meta.ItemMeta;

	public class PlayerJoin implements Listener {
		
		private PluginTutorielMain main;
		
		@EventHandler
		public void onJoin(PlayerJoinEvent event) {
			Player plr = event.getPlayer();
			
			plr.getInventory().clear();
			
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta metaSword = sword.getItemMeta();
			metaSword.setDisplayName("L'épée du futur !");
			metaSword.setLore(Arrays.asList("1ère ligne", "2ème ligne", "la dernière ligne !"));
			sword.setItemMeta(metaSword);
			
			plr.getInventory().addItem(sword);	
			plr.updateInventory();
			
			event.setJoinMessage(ConfigBuild.getString("messages.welcome"));
		}
		
		public void onQuit(PlayerQuitEvent event) {
			Player plr = event.getPlayer();
			event.setQuitMessage(ConfigBuild.getString("messages.quit"));
		}
	}
</code></pre>

<pre><code>
	package code;

	import java.awt.Color;

	import org.javacord.api.DiscordApi;
	import org.javacord.api.DiscordApiBuilder;
	import org.javacord.api.entity.channel.ServerChannel;
	import org.javacord.api.entity.channel.ServerTextChannel;
	import org.javacord.api.entity.channel.ServerTextChannelBuilder;
	import org.javacord.api.entity.channel.ServerVoiceChannel;
	import org.javacord.api.entity.channel.ServerVoiceChannelBuilder;
	import org.javacord.api.entity.message.MessageBuilder;
	import org.javacord.api.entity.message.MessageDecoration;
	import org.javacord.api.entity.message.embed.EmbedBuilder;
	import org.javacord.api.entity.server.invite.Invite;
	import org.javacord.api.entity.server.invite.InviteBuilder;
	import org.javacord.api.entity.user.UserStatus;

	public class bot {
	    
	    private static DiscordApi api;
	    
		public static void main(String[] args)
	    {
	        api = new DiscordApiBuilder()
	            .setToken("token de mon bot")
	            .login().join();
	        
	        
	        api.updateStatus(UserStatus.ONLINE);
	        api.updateActivity("A s'améliorer");
	        
	        api.addMessageCreateListener(event -> {
	            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
	                event.getChannel().sendMessage("Pong!");
	            }
	        }
	    }
	}
</code></pre>