package com.teddyrna.tutorial.events;

import com.teddyrna.tutorial.items.itemmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TutorialEvents implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.hasPlayedBefore()) {
            p.sendMessage("Welcome back, " + ChatColor.AQUA + p.getName());
        } else {
            Bukkit.broadcastMessage("Welcome " + ChatColor.AQUA + p.getName() + ChatColor.WHITE + " to the server");
        }

    }
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) if (event.getItem().getItemMeta().equals(itemmanager.wand.getItemMeta())) {
                Player player = event.getPlayer();
                player.getWorld().createExplosion(player.getLocation(), 2.0f);
                player.sendMessage("§6You dare use the stick of TRUTH?!");
            }
        }

    }
}
