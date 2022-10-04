package de.juea.lobby.manager.Rank;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PermRank {


    public static File file = new File("plugins//Ranks//rank.yml");
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
            cfg.set("Group.Spieler.Prefix", "&7Spieler &8|");
            cfg.set("Group.Spieler.Display", "&7Spieler &8|");
            cfg.set("Group.Spieler.permlist", new ArrayList<String>());
            cfg.set("Group.Spieler.sortid", 1);
            cfg.set("Groups", new ArrayList<String>());
            List<String> list = cfg.getStringList("Groups");
            list.add("Spieler");
            cfg.set("Groups", list);
            save();
        }
    }

    private String rankname, prefix, display;

    private List<String> permlist;
    private int sortid;

    public PermRank(String RankName) {
        rankname = RankName;
    }

    public PermRank() {

    }

    public List<String> allRanks() {
        return cfg.getStringList("Groups");
    }

    public String getRankname() {
        return rankname;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDisplay() {
        return display;
    }

    public List<String> getPermlist() {
        return permlist;
    }

    public int getSortID() {
        return sortid;
    }

    public boolean exist() {
        return (cfg.contains("Group." + rankname));
    }

    //========================== Setter =========================

    public void addList() {
        List<String> Groups = cfg.getStringList("Groups");
        Groups.add(rankname);
        cfg.set("Groups", Groups);
        save();
    }

    public void removeList() {
        List<String> Groups = cfg.getStringList("Groups");
        Groups.remove(rankname);
        cfg.set("Groups", Groups);
        save();
    }

    public void addPerm(String Permission) {
        List<String> list = getPermlist();
        list.add(Permission);
        cfg.set("Group." + rankname + ".permlist", list);
        save();
        loadSetting();
    }

    public void removePerm(String Permission) {
        List<String> list = getPermlist();
        list.remove(Permission);
        cfg.set("Group." + rankname + ".permlist", list);
        save();
        loadSetting();
    }

    public void setPrefix(String Prefix) {
        cfg.set("Group." + rankname + ".Prefix", Prefix);
        save();
    }

    public void setDisplay(String Display) {
        cfg.set("Group." + rankname + ".Display", Display);
        save();
    }

    public void setSortID(int SortID) {
        cfg.set("Group." + rankname + ".SortID", SortID);
        save();
    }

    public void create() {
        cfg.set("Group." + rankname + ".Prefix", "&7Spieler &8|");
        cfg.set("Group." + rankname + ".Display", "&7Spieler &8|");
        cfg.set("Group." + rankname + ".permlist", new ArrayList<String>());
        cfg.set("Group." + rankname + ".SortID", 1);
        save();
        addList();
    }

    public void delete() {
        cfg.set("Group." + rankname, null);
        save();
        removeList();
    }

    public void loadSetting() {
        sortid = cfg.getInt("Group." + rankname + ".SortID");
        prefix = cfg.getString("Group." + rankname + ".Prefix");
        display = cfg.getString("Group." + rankname + ".Display");
        permlist = cfg.getStringList("Group." + rankname + ".permlist");
    }


}
