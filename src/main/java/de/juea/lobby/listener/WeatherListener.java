package de.juea.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener {

    @EventHandler
    public void handleServerWeather(WeatherChangeEvent event) {
        event.setCancelled(true);
        event.getWorld().setStorm(false);
        event.getWorld().setThundering(false);
    }

}
