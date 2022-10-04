package de.juea.lobby;

import de.juea.lobby.listener.*;

import de.juea.lobby.manager.BosManager;
import de.juea.lobby.manager.Rank.PermRank;
import de.juea.lobby.manager.Rank.PermUser;
import de.juea.lobby.util.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Lobby extends JavaPlugin {

    public static String ServerPrefix = "§eInvMC §8| ";

    public static MySQL mysql;

    @Override
    public void onEnable() {

        mysql = new MySQL("db5010285826.hosting-data.io", "dbu5397533", "dasvollzeit2001", "dbs8714886");
        mysql.connect();

        PermRank.loadAndCreate();
        PermUser.loadAndCreate();

        Bukkit.getPluginManager().registerEvents(new LogListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodListener(), this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new WeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemListener(), this);

        setTime();
        BosManager.updateScore();

        for (World world : Bukkit.getWorlds()) {
            world.setAmbientSpawnLimit(0);
            world.setAnimalSpawnLimit(0);
            world.setMonsterSpawnLimit(0);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void setTime() {
        for (World world : Bukkit.getWorlds()) {
            world.setTime(0);
        }
        new BukkitRunnable() {

            @Override
            public void run() {
                setTime();
            }
        }.runTaskLater(Lobby.getPlugin(Lobby.class), 20);
    }
}
