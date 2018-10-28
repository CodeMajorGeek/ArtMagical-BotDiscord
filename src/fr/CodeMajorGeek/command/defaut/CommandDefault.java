package fr.CodeMajorGeek.command.defaut;

import java.awt.Color;

import fr.CodeMajorGeek.Main;
import fr.CodeMajorGeek.command.Command;
import fr.CodeMajorGeek.command.Command.ExecutorType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class CommandDefault {

	private final Main main;
	
	public CommandDefault(Main main) {
		
		this.main = main;
	}
	
	@Command(name="stop", type=ExecutorType.CONSOLE)
	private void stop() {
		
		main.setRunning(false);
	}
	
	@Command(name="help", type=ExecutorType.USER)
	private void info(User user, MessageChannel channel) {
		
		EmbedBuilder embedBuilder = new EmbedBuilder();
		embedBuilder.setAuthor(user.getName(), null, user.getAvatarUrl()+"?size-256");
		embedBuilder.setTitle("Liste des commandes: :");
		embedBuilder.setDescription("-help --> affiche la liste des commandes.");
		embedBuilder.setColor(Color.YELLOW);
		
		channel.sendMessage(embedBuilder.build()).queue();
	}
}