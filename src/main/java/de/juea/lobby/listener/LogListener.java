package de.juea.lobby.listener;

import de.juea.lobby.Lobby;
import de.juea.lobby.manager.BosManager;
import de.juea.lobby.manager.InvManager;
import de.juea.lobby.manager.Rank.PermUser;
import de.juea.lobby.manager.extras.LobbyItems;
import de.juea.lobby.util.FlyingItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class LogListener implements Listener {

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        LobbyItems.createPlayer(player);

        PermUser permUser = new PermUser(player.getName());
        permUser.create();

        event.setJoinMessage(null);
        InvManager.setLobbyInv(player);
        BosManager.setScore(player);

        player.setPlayerListHeaderFooter("\n§eInvicibleMC.com §8| §aLobby\n\n" +
                "§7Willkommen §a" + player.getName() + "\n", "\n§7Server §8| §aLobby-1\n" +
                "        §7Teamspeak §8| §aInvincibleMC.com        \n");


        player.sendMessage("§e§lGamePass §8| §eDu hast den §lGamePass §eaktiv! Somit stehen dir alle Stufe 1 & 2 Extras zur verfügung!");
        player.sendMessage("§8[§cINFO§8] §7GamePass aktivierte Objekte verliehrt man nie wieder!");
        new BukkitRunnable() {

            @Override
            public void run() {
                player.teleport(player.getWorld().getSpawnLocation());
                player.setDisplayName(player.getDisplayName() + " " + "§8[§e§l✰PASS§8]");
                player.setCustomName(player.getDisplayName());
                player.setPlayerListName(player.getDisplayName());
                FlyingItems flyingItems = new FlyingItems();
                flyingItems.setItemStack(new ItemStack(Material.BEACON));

                Location location = player.getLocation();
                location.subtract(0, 0, 4);

                flyingItems.setLocation(player.getLocation());
                flyingItems.setText("§e§lGamePass §aaktiviert\n\n" +
                        "§eDu hast ale Stufe 1 & 2 Extras frei!");
                flyingItems.setHeight(1);
                flyingItems.spawn();
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        flyingItems.remove();
                    }
                }.runTaskLater(Lobby.getPlugin(Lobby.class), 10*20);
            }
        }.runTaskLater(Lobby.getPlugin(Lobby.class), 20);



    }

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);
    }

}
