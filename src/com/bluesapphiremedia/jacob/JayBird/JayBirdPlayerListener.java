package com.bluesapphiremedia.jacob.JayBird;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerListener;

public class JayBirdPlayerListener extends PlayerListener {
	// register the main class as a plugin
	public JayBird plugin;
	// open the player listener
	public JayBirdPlayerListener(JayBird instance){
		plugin = instance;
	}
	public void onEntityDamage(EntityDamageEvent event){
		// check if the entity is a player
		if(event.getEntity() instanceof Player) {
			// if so, cancel the damage
			event.setCancelled(true);
		}
	}
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		// cancel the food level change
		event.setCancelled(true);
	}
}
