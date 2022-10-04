package de.juea.lobby.manager.extras;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LobbyItems {

    public static HashMap<Player, List<String>> LobbyItems = new HashMap<>();
    public static HashMap<Player, List<String>> ActiveLobbyItems = new HashMap<>();

    public static void addItem(Player player, String Items) {
        List<String> list = LobbyItems.get(player);
        list.add(Items);
        LobbyItems.put(player, list);
    }

    public static void addActiveItem(Player player, String Items) {
        List<String> list = ActiveLobbyItems.get(player);
        list.add(Items);
        ActiveLobbyItems.put(player, list);
    }

    public static void rmvActiveItem(Player player, String Items) {
        List<String> list = ActiveLobbyItems.get(player);
        list.remove(Items);
        ActiveLobbyItems.put(player, list);
    }



    public static void createPlayer(Player player) {
        LobbyItems.put(player, new ArrayList<String>());
        ActiveLobbyItems.put(player, new ArrayList<String>());
    }


    //Mange Extras

    public static Material managePlatzhalter(Player player) {
        if (ActiveLobbyItems.get(player).contains("Platzhalter-Grau")) {
            return Material.GRAY_STAINED_GLASS_PANE;
        }
        if (ActiveLobbyItems.get(player).contains("Platzhalter-Rot")) {
            return Material.RED_STAINED_GLASS_PANE;
        }
        if (ActiveLobbyItems.get(player).contains("Platzhalter-Blau")) {
            return Material.BLUE_STAINED_GLASS_PANE;
        }
        if (ActiveLobbyItems.get(player).contains("Platzhalter-HellBlau")) {
            return Material.LIGHT_BLUE_STAINED_GLASS_PANE;
        }
        if (ActiveLobbyItems.get(player).contains("Platzhalter-Grün")) {
            return Material.GREEN_STAINED_GLASS_PANE;
        }
        return Material.GRAY_STAINED_GLASS_PANE;
    }

}
