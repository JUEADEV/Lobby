package de.juea.lobby.manager.Rank;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PermUser {


    public static File file = new File("plugins//Ranks//user.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadAndCreate() {
        if (file.exists()) {
            try {
                cfg.load(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            save();
        }
    }

    private String name,groupname;
    private List<String> permlist;

    public PermUser(String Name) {
        name = Name;
    }

    public String getGroupName() {
        return groupname;
    }

    public List<String> getPermList() {
        return permlist;
    }

    public boolean exist() {
        return (cfg.contains("Spieler." + name));
    }

    public void create() {
        if (!exist()) {
            cfg.set("Spieler." + name + ".GroupName", "Spieler");
            cfg.set("Spieler." + name + "PermList", new ArrayList<String>());
            save();
        }
    }

    public void setGroupName(String GroupName) {
        cfg.set("Spieler." + name + ".GroupName", GroupName);
        save();
    }

    public void loadSetting() {
        groupname = cfg.getString("Spieler." + name + ".GroupName");
    }


}
