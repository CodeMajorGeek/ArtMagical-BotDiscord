package fr.ArtMagical.command.defaut;

import fr.ArtMagical.Main;
import fr.ArtMagical.command.Command;
import fr.ArtMagical.command.Command.ExecutorType;

public class CommandDefault {

	private final Main main;
	
	public CommandDefault(Main main) {
		
		this.main = main;
	}
	
	@Command(name="stop", type=ExecutorType.CONSOLE)
	private void stop() {
		
		main.setRunning(false);
	}
}