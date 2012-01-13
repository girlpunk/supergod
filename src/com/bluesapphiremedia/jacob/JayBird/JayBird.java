/**
 * Class        : JayBird.java
 * Package      : com.bluesapphiremedia.jacob.JayBird
 * Project      : JayBird
 *
 * Description  : the main JayBird plugin class
 *
 * Notes        : 
 *
 * Url		: www.bluesapphiremedia.co.uk
 *
 * External 
 * Interfaces   : 
 *
 * Config
 * File
 * Layout       : 
 *
 * See Also     :
 *
 * Functions    : TODO
 *
 * @author      : Jacob Mansfield
 * Copyright    : 2010-2012 Blue Sapphire Media
 *
 * Engineering
 * Status       : SYSTEM TEST
 *
 * @see
 */
package com.bluesapphiremedia.jacob.JayBird;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Jacob Mansfield
 *
 */

public class JayBird extends JavaPlugin {

	/**
	 *
	 * Description
	 * 
	 * @param	name 	Description 
	 *
	 * @param	name 	
	 *
	 * @return	type	
	 *
	 * @exception	Description 
	 * 
	 * @see		fully-qualified-class-name#methodindex()
	 *
	 * @since	Description 
	 *		
	 * @deprecated  Description	
	 *
	 */
	
	// get us a logger to chop down some wood
	Logger Log = Logger.getLogger("Minecraft");
	// register our player listener
	private final JayBirdPlayerListener playerListener = new JayBirdPlayerListener(this);
	private final JayBirdWorldListener worldListener = new JayBirdWorldListener(this);
	
	public void onEnable(){ 
		// get us a plugin manager
		PluginManager pm = this.getServer().getPluginManager();
		// tell us when an entity takes damage, so we can godmode players
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, playerListener, Event.Priority.Normal, this);
		// tell us when a player's food level changes, so we can refill it
		pm.registerEvent(Event.Type.FOOD_LEVEL_CHANGE, playerListener, Event.Priority.Normal, this);
		// tell us if the weather changes, so we can cancel it
		pm.registerEvent(Event.Type.WEATHER_CHANGE, worldListener, Event.Priority.Normal, this);
		// log that we loaded successfully
		Log.info("JayBird v0.0.1 enabled successfully!");
	}
	public void onDisable(){ 
		// log that we got disabled
		 Log.info("JayBird v0.0.1 dissabled");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// match our list of commands
		if(cmd.getName().equalsIgnoreCase("project")) {
			// it's a project command, run the project command processor
			return JayBirdProjects.callCommand(sender, cmd, commandLabel, args);
		}
		return false;
	}

}
