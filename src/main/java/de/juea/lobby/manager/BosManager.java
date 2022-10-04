package de.juea.lobby.manager;

import de.juea.lobby.Lobby;

import de.juea.lobby.manager.Rank.PermRank;
import de.juea.lobby.manager.Rank.PermUser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class BosManager {

    public static void setScore(Player player) {
        ScoreboardManager smanager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = smanager.getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("aaa", "bbb");


        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§eINVINCIBLEMC §8| §aLobby");

        PermUser permUser = new PermUser(player.getName());
        permUser.loadSetting();
        PermRank permRank = new PermRank(permUser.getGroupName());
        permRank.loadSetting();
        String Prefix = ChatColor.translateAlternateColorCodes('&', permRank.getPrefix().replace("|", ""));


        obj.getScore("§a ").setScore(20);
        obj.getScore("§7Spieler Online§8:").setScore(19);
        obj.getScore(getTeam("Online", "§8» §e" + Bukkit.getOnlinePlayers().size() + " Spieler",
                "", scoreboard, ChatColor.AQUA)).setScore(18);
        obj.getScore("§b ").setScore(17);
        obj.getScore("§7Dein Rang§8:").setScore(16);
        obj.getScore(getTeam("GameMode", "§8» §7" + Prefix,
                " §8+§e§lGamePass", scoreboard, ChatColor.BLACK)).setScore(15);
        obj.getScore("§c ").setScore(14);
        obj.getScore("§7Deine Freunde§8:").setScore(13);
        obj.getScore("§8» §a0§8/§20 §7Freunde").setScore(12);
        obj.getScore("§d ").setScore(11);
        obj.getScore("§7Dein Can§8:").setScore(10);
        obj.getScore("§8» §cKein Clan erstelt").setScore(9);
        obj.getScore("§e ").setScore(8);
        obj.getScore("§7TeamspeakIP§8:").setScore(7);
        obj.getScore("§8» §cInvincibleMC.com").setScore(6);
        obj.getScore("§f ").setScore(5);

        player.setScoreboard(scoreboard);


    }

    public static void updateScore() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.getScoreboard() == null) {
                setScore(all);
            }
            Scoreboard scoreboard = all.getScoreboard();
            Objective obj = scoreboard.getObjective("aaa");
            PermUser permUser = new PermUser(all.getName());
            permUser.loadSetting();
            PermRank permRank = new PermRank(permUser.getGroupName());
            permRank.loadSetting();
            String Prefix = ChatColor.translateAlternateColorCodes('&', permRank.getPrefix().replace("|", ""));

            obj.getScore(getTeam("Online", "§8» §e" + Bukkit.getOnlinePlayers().size() + " Spieler",
                    "", scoreboard, ChatColor.AQUA)).setScore(18);

            obj.getScore(getTeam("GameMode", "§8» §7" + Prefix,
                    " §8+§e§lGamePass", scoreboard, ChatColor.BLACK)).setScore(15);

        }
        new BukkitRunnable() {

            @Override
            public void run() {
                updateScore();
            }
        }.runTaskLater(Lobby.getPlugin(Lobby.class), 20);
    }

    public static String getTeam(String Teams, String Prefix, String Suffix, Scoreboard scoreboard, ChatColor chatColor) {
        Team team = scoreboard.getTeam(Teams);
        if (scoreboard.getTeam(Teams) == null) {
            team = scoreboard.registerNewTeam(Teams);
        }
        team.setPrefix(Prefix);
        team.setSuffix(Suffix);
        team.addEntry(chatColor.toString());
        return chatColor.toString();
    }

}
