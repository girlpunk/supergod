package com.bluesapphiremedia.jacob.JayBird;

import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldListener;

public class JayBirdWorldListener extends WorldListener {

	// register the main class as a plugin
	public JayBird plugin;
	// open the player listener
	public JayBirdWorldListener(JayBird instance){
		plugin = instance;
	}
	public void onWeatherChange(WeatherChangeEvent event) {
		// just lock the weather if it tries to change
		event.setCancelled(true);
	}

}
