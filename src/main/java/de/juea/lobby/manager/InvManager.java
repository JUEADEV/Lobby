package de.juea.lobby.manager;

import de.juea.lobby.manager.extras.LobbyItems;
import de.juea.lobby.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class InvManager {

    public static void setLobbyInv(Player player) {
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setLevel(2022);
        player.setGameMode(GameMode.ADVENTURE);
        player.setMaxHealth(6);
        player.setHealth(6);

        player.getInventory().setItem(4, new ItemBuilder(Material.COOKIE)
                .setName("§c§lNavigator §8| §7rechtklick").toItemStack());
        player.getInventory().setItem(2, new ItemBuilder(Material.CHEST)
                .setName("§a§lDein Inventar §8| §7rechtsklick").toItemStack());
        player.getInventory().setItem(6, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setSkullOwner(player.getName()).setName("§9§lDein Profil §8| §7rechtsklick").toItemStack());


        player.getInventory().setItem(8, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setSkullOwner("MHF_Beacon_").setName("§e§lGamePass §8| §7rechtsklick")
                .setLore(Arrays.asList("§e§lSchalte jeden Monat coole Extras frei!")).toItemStack());


    }




    public static void openNavigator(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3*9, "§cNavigator");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(13, new ItemBuilder(Material.MAGMA_CREAM).setName("§eSpawn").toItemStack());



        player.openInventory(inventory);
    }

    public static void openExtrasMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3*9, "§aDein Inventar");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(11, new ItemBuilder(Material.GLOWSTONE_DUST).setName("§aServer-Items").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.MAGMA_CREAM).setName("§aLobby-Items").toItemStack());
        inventory.setItem(15, new ItemBuilder(Material.REDSTONE).setName("§aCityBuild-Items").toItemStack());

        player.openInventory(inventory);
    }

    public static void openExtrasLobbyItems1(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3*9, "§aInv §71");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(11, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE)
                .setName("§aInventar-Platzhalter").toItemStack());

        player.openInventory(inventory);
    }

    public static void openExtrasLobbyItems2(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 4*9, "§aInv §7Platzhalter");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(11, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setName("§aGrauer Platzhalter").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.RED_STAINED_GLASS_PANE)
                .setName("§aGrauer Platzhalter").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE)
                .setName("§aGrauer Platzhalter").toItemStack());
        inventory.setItem(14, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE)
                .setName("§aGrauer Platzhalter").toItemStack());
        inventory.setItem(15, new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE)
                .setName("§aGrauer Platzhalter").toItemStack());
        inventory.setItem(17, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setSkullOwner("ElMarcosFTW").setName("§aPlatzhalter-Pack")
                .setLore(Arrays.asList("§7Alle Platzhalter in einem pack!")).toItemStack());
        addProgress(inventory, player, 20, "Platzhalter-Grau", "AllePlatzhalter");
        addProgress(inventory, player, 21, "Platzhalter-Rot", "AllePlatzhalter");
        addProgress(inventory, player, 22, "Platzhalter-Blau", "AllePlatzhalter");
        addProgress(inventory, player, 23, "Platzhalter-Grün", "AllePlatzhalter");
        addProgress(inventory, player, 24, "Platzhalter-HellBlau", "AllePlatzhalter");
        addProgress(inventory, player, 26, "AllePlatzhalter", "AllePlatzhalter");
        player.openInventory(inventory);
    }

    public static void openExtrasServerItems1(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3*9, "§aInv §71");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(11, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setSkullOwner("_ruuzZ").setName("§aFreunde-Pack").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setSkullOwner("MHF_TNT2").setName("§eClan-Pack").toItemStack());


        player.openInventory(inventory);
    }

    public static void openExtrasServerItems2(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 4*9, "§aInv §7Freunde");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(11, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §e+20 Freunde §afrei!"))
                .setSkullOwner("_ruuzZ").setName("§aFreunde-Pack 1").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §e+40 Freunde §afrei!"))
                .setSkullOwner("_ruuzZ").setName("§aFreunde-Pack 2").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §e+100 Freunde §afrei!"))
                .setSkullOwner("_ruuzZ").setName("§aFreunde-Pack 3").toItemStack());

        addProgress(inventory, player, 20, "Freunde-1", "AlleFreunde");
        addProgress(inventory, player, 21, "Freunde-2", "AlleFreunde");
        addProgress(inventory, player, 22, "Freunde-3", "AlleFreunde");

        player.openInventory(inventory);
    }

    public static void openExtrasServerItems3(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 4*9, "§aInv §7Freunde");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(11, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §e+20 Mitglieder §afrei!"))
                .setSkullOwner("MHF_TNT2").setName("§eClan-Pack 1").toItemStack());
        inventory.setItem(12, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §e+40 Mitglieder §afrei!"))
                .setSkullOwner("MHF_TNT2").setName("§eClan-Pack 2").toItemStack());
        inventory.setItem(13, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §eClan-Events §afrei!"))
                .setSkullOwner("MHF_TNT2").setName("§eClan-Pack 3").toItemStack());
        inventory.setItem(14, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §eELO-Games §afrei!"))
                .setSkullOwner("MHF_TNT2").setName("§eClan-Pack 4").toItemStack());
        inventory.setItem(15, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§aSchalte §e+2 Ränge §afrei!"))
                .setSkullOwner("MHF_TNT2").setName("§eClan-Pack 4").toItemStack());

        addProgress(inventory, player, 20, "Clan-1", "AlleClans");
        addProgress(inventory, player, 21, "Clan-2", "AlleClans");
        addProgress(inventory, player, 22, "Clan-3", "AlleClans");
        addProgress(inventory, player, 23, "Clan-4", "AlleClans");
        addProgress(inventory, player, 24, "Clan-5", "AlleClans");

        player.openInventory(inventory);
    }


    public static void openProfilMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3*9, "§9Profil");

        for (int i = 0; i < inventory.getContents().length; i++) {
            inventory.setItem(i, new ItemBuilder(LobbyItems.managePlatzhalter(player)).setName("§a ").toItemStack());
        }

        inventory.setItem(12, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§a0§8/§220 §7Freunde","§cGesperrt"))
                .setSkullOwner("_ruuzZ").setName("§aDeine Freunde").toItemStack());

        inventory.setItem(14, new ItemBuilder(Material.LEGACY_SKULL_ITEM, 1, (byte) 3)
                .setLore(Arrays.asList("§cKein Clan erstellt!","§cGesperrt"))
                .setSkullOwner("MHF_TNT2").setName("§eDeine Clan").toItemStack());

        player.openInventory(inventory);

    }

    public static void addProgress(Inventory inventory, Player player, int Slot, String What, String PackName) {
        if (LobbyItems.ActiveLobbyItems.get(player).contains(What)) {
            inventory.setItem(Slot, new ItemBuilder(Material.GREEN_DYE).setName("§aAktiviert").toItemStack());
        } else {
            if (LobbyItems.LobbyItems.get(player).contains(What)
                    || LobbyItems.LobbyItems.get(player).contains(PackName)) {
                inventory.setItem(Slot, new ItemBuilder(Material.RED_DYE).setName("§cDeaktiviert").toItemStack());
            } else {
                inventory.setItem(Slot, new ItemBuilder(Material.GOLD_INGOT).setName("§eKaufen")
                        .setLore(Arrays.asList("§eIn den Tests kostenlos!")).toItemStack());
            }
        }
    }




}
