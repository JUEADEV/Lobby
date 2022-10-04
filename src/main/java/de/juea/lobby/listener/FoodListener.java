package de.juea.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodListener implements Listener {

    @EventHandler
    public void handlePlayerFood(FoodLevelChangeEvent event) {
        event.setCancelled(true);
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.setFoodLevel(20);
        }
    }

}
