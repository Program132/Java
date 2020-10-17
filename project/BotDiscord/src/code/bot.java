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
            .setToken("TOKEN")
            .login().join();
        
        
        api.updateStatus(UserStatus.ONLINE);
        api.updateActivity("A s'améliorer");
        
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!embed")) {
            	EmbedBuilder embed = new EmbedBuilder()
                	    .setTitle("Title")
                	    .setDescription("Description")
                	    .setAuthor("Author Name", "http://google.com/", "https://cdn.discordapp.com/embed/avatars/0.png")
                	    .addField("A field", "Some text inside the field")
                	    .addInlineField("An inline field", "More text")
                	    .addInlineField("Another inline field", "Even more text")
                	    .setColor(Color.BLUE);
                event.getChannel().sendMessage(embed);
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!emoji")) {
            	event.getChannel().sendMessage("Hi! 😃");
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!react")) {
            	event.getChannel().sendMessage("Yo");
            	event.getMessage().addReaction("😃");
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!messagebuilder"))
            {
				new MessageBuilder()
                .append("Regarde sa !")
                .append("Texte en gras et souligné", MessageDecoration.BOLD, MessageDecoration.UNDERLINE)
                .appendCode("java", "System.out.println(\"Sweet!\");")
                .setEmbed(new EmbedBuilder()
                        .setTitle("Embed")
                        .setDescription("Yes un embed crée dans un message builder")
                        .setColor(Color.ORANGE))
				.send(event.getChannel());
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!createChannelVoice"))
            {
            	@SuppressWarnings("unused")
				ServerVoiceChannel channel = new ServerVoiceChannelBuilder(event.getServer().get())
            		    .setName("Vocal")
            		    .setUserlimit(10) // Pour rajouter une limite de personne qui se co
            		    .create().join();
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!createChannelText"))
            {
            	ServerTextChannel channel = new ServerTextChannelBuilder(event.getServer().get())
            		    .setName("Text")
            		    .create().join();
            }
            
            else if (event.getMessageContent().equalsIgnoreCase("!createInvite"))
            {
                ServerChannel channel = (ServerChannel) event.getChannel();
                Invite invite = new InviteBuilder(channel )
                        .setMaxAgeInSeconds(60*60*24)
                        .setMaxUses(42)
                        .create().join();
                event.getChannel().sendMessage(invite.getUrl().toString());
            }
        });

    }
}