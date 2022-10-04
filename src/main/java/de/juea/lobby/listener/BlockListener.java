package de.juea.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void handleBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
    }

    @EventHandler
    public void handleBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
    }

    @EventHandler
    public void handleBlockStump(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
    }

}
