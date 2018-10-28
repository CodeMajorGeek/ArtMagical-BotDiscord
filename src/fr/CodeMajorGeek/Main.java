package fr.CodeMajorGeek;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import fr.CodeMajorGeek.command.CommandMap;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Main implements Runnable{

	private JDA jda = null;
	private final CommandMap commandMap = new CommandMap(this);
	private static String Token;
	private final Scanner scanner = new Scanner(System.in);
	
	public static MessageChannel recrutement;
	
	private boolean running;
	
	public Main() throws LoginException, InterruptedException {
		
		jda = new JDABuilder(AccountType.BOT).setToken(Token).setBulkDeleteSplittingEnabled(false).buildBlocking();
		jda.addEventListener(new BotListener(commandMap));
		System.out.println("The bot is connected !");
	}
	
	public void setRunning(boolean running) {
		
		this.running = running;
	}
	
	public JDA getJDA() {
		
		return jda;
	}
	
	@Override
	public void run() {
		running = true;
		
		 while(running) {
			 
			 if(scanner.hasNextLine()) commandMap.commandConsole(scanner.nextLine());
		 }
		 
		 scanner.close();
		 System.out.println("Bot Stopped !");
		 jda.shutdown();
		 System.exit(0);
	}
	
	public static void main(String[] args) {
		
		if(args.length < 1) System.out.println("Veulliez indiquer le token du bot !");
		else Token = args[0];
		
		Token = "NTA0NDE1Njk1MzU5MDQ5NzQ5.DrdrTA.CIxrNhzKQVInEktPAZB7WuAk2lo";
		
		try {
			
			Main main = new Main();
			new Thread(main, "bot").start();
		} catch (LoginException | InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
