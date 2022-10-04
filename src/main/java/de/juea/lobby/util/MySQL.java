package de.juea.lobby.util;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    public String username;
    public String password;
    public String database;
    public String host;
    public String port;
    public Connection con;


    public MySQL(String HOST, String USER, String PASSWORD, String DATABASE) {

        this.host = HOST;
        this.username = USER;
        this.password = PASSWORD;
        this.database = DATABASE;

    }

    public void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?autoReconnect=true",
                        username, password);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage("§aMySQL verbunden!");
                }
            } catch (SQLException e) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage("§cMySQL nicht verbunden!");
                }
            }
        }
    }

    public void close() {
        if (isConnected()) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return con != null;
    }

    public void update(String qry) {
        if (isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getResult(String qry) {
        if (isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}