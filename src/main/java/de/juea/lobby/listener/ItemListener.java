package de.juea.lobby.listener;

import de.juea.lobby.Lobby;
import de.juea.lobby.manager.InvManager;
import de.juea.lobby.manager.extras.LobbyItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemListener implements Listener {

    @EventHandler
    public void handleInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        if (player.getOpenInventory().getTitle().equals("§aDein Inventar")) {
            String Name = event.getCurrentItem().getItemMeta().getDisplayName();
            if (Name.equals("§aLobby-Items")) {
                player.closeInventory();
                InvManager.openExtrasLobbyItems1(player);
            }
            if (Name.equals("§aServer-Items")) {
                player.closeInventory();
                InvManager.openExtrasServerItems1(player);
            }
        }
        if (player.getOpenInventory().getTitle().equals("§aInv §71")) {
            String Name = event.getCurrentItem().getItemMeta().getDisplayName();
            if (Name.equals("§aInventar-Platzhalter")) {
                player.closeInventory();
                InvManager.openExtrasLobbyItems2(player);
            }
            if (Name.equals("§aFreunde-Pack")) {
                player.closeInventory();
                InvManager.openExtrasServerItems2(player);
            }
            if (Name.equals("§eClan-Pack")) {
                player.closeInventory();
                InvManager.openExtrasServerItems3(player);
            }
        }
        if (player.getOpenInventory().getTitle().equals("§aInv §7Platzhalter")) {
            String What = "";
            if (event.getRawSlot() == 20) {
                What = "Platzhalter-Grau";
            } else if (event.getRawSlot() == 21) {
                What = "Platzhalter-Rot";
            } else if (event.getRawSlot() == 22) {
                What = "Platzhalter-Blau";
            } else if (event.getRawSlot() == 23) {
                What = "Platzhalter-Grün";
            } else if (event.getRawSlot() == 24) {
                What = "Platzhalter-HellBlau";
            } else if (event.getRawSlot() == 26) {
                What = "AllePlatzhalter";
            } else {
                return;
            }
            if (event.getCurrentItem().getType() == Material.RED_DYE && event.getRawSlot() != 26) {
                player.closeInventory();
                LobbyItems.addActiveItem(player, What);
                player.sendMessage(Lobby.ServerPrefix + "§7Du hast das Extra §a" + What + " §7aktiviert!");
            }
            if (event.getCurrentItem().getType() == Material.GREEN_DYE && event.getRawSlot() != 26) {
                player.closeInventory();
                LobbyItems.rmvActiveItem(player, What);
                player.sendMessage(Lobby.ServerPrefix + "§7Du hast das Extra §c" + What + " §7deaktiviert!");
            }
            if (event.getCurrentItem().getType() == Material.GOLD_INGOT) {
                player.closeInventory();
                LobbyItems.addItem(player, What);
                player.sendMessage(Lobby.ServerPrefix + "§7Du hast das Extra §e" + What + " §7gekauft!");
            }
            InvManager.openExtrasLobbyItems2(player);
        }
    }

    @EventHandler
    public void handlePlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
    }

    @EventHandler
    public void handlePlayerInteractItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem().getType() == Material.COOKIE) {
            InvManager.openNavigator(player);
        }
        if (event.getItem().getType() == Material.CHEST) {
            InvManager.openExtrasMenu(player);
        }

        if (event.getItem().getItemMeta().getDisplayName().equals("§9§lDein Profil §8| §7rechtsklick")) {
            InvManager.openProfilMenu(player);
        }

        if (event.getItem().getItemMeta().getDisplayName().equals("§e§lGamePass §8| §7rechtsklick")) {
            player.sendMessage("§e§lGamePass §8| §7Schaue unter §ehttp://invinciblemc.eu?page=shop/gamepass §7!");
        }
    }

}
