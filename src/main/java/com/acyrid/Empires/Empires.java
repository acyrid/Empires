package com.acyrid.Empires;

import com.acyrid.Empires.listeners.EBlockListener;
import com.acyrid.Empires.listeners.EDamageListener;
import com.acyrid.Empires.listeners.EEntityListener;
import com.acyrid.Empires.listeners.EPlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class Empires extends JavaPlugin{
    private EPlayerListener playerListener = new EPlayerListener(this);
    private EBlockListener blockListener = new EBlockListener(this);
    private EEntityListener entityListener = new EEntityListener(this);
    private EDamageListener damageListener = new EDamageListener(this);
    
    public void onDisable(){
        Bukkit.getLogger().log(Level.INFO, "Disabled!");
    }


    public void onEnable(){
        if(!new File(this.getDataFolder(), "config.yml").exists()){
            saveDefaultConfig();
        }
        getConfig();
        Bukkit.getLogger().log(Level.INFO, "Enabled!");
        getConfig().getKeys(true);
    }
    
    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.playerListener, this);
        pm.registerEvents(this.damageListener, this);
        pm.registerEvents(this.blockListener, this);
        pm.registerEvents(this.entityListener, this);
    }

}
