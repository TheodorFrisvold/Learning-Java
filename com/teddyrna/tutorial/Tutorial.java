package com.teddyrna.tutorial;

import com.teddyrna.tutorial.Commands.TutorialCommands;
import com.teddyrna.tutorial.events.TutorialEvents;
import com.teddyrna.tutorial.items.itemmanager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        TutorialCommands commands = new TutorialCommands();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getCommand("heal").setExecutor(new TutorialCommands());
        getCommand("feed").setExecutor(new TutorialCommands());
        getCommand("spawnmob").setExecutor(new TutorialCommands());
        itemmanager.init();
        getCommand("select)").setExecutor(new TutorialCommands());
        getCommand("givewand").setExecutor(new TutorialCommands());
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Tutorial]: Plugin is enabled!");


    }

    @Override
    public void onDisable() {

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Tutorial]: Plugin is disabled!");

    }

}
