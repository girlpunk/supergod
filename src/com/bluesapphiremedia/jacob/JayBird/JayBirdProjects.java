package com.bluesapphiremedia.jacob.JayBird;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class JayBirdProjects {
	public static boolean callCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		// sort through our list of possible commands
		if(args.length == 0) {
			// if we don't have a sub-command, show the help
			getHelp(sender, cmd, commandLabel, args);
		} else if(args[0] == "info") {
			info(sender, cmd, commandLabel, args);
		}
		return true;
	}

	private static void info(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("Hello World!");
	}

	private static void getHelp(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// TODO Auto-generated method stub
		sender.sendMessage("This is the help for JayBird Project management");
	}
}
