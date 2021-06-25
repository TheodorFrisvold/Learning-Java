package com.teddyrna.tutorial.Commands;

import com.teddyrna.tutorial.selectscreen;
import com.teddyrna.tutorial.items.itemmanager;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TutorialCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can use that command!");
            return true;}
        Player player = (Player) sender;

        //heal
        if (cmd.getName().equalsIgnoreCase("heal")) {
            int maxHealth = (int) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage(ChatColor.GREEN + "Healed you!");
            return true;
        }
        //feed
        if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "Fed you!");
        }

        //spawnmob
        else if (cmd.getName().equalsIgnoreCase("spawnmob")) {
            if (args.length >=2) {
            try {
                EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                int amount = Integer.parseInt(args[1]);
                for (int i = 0; i < amount; i++){
                    player.getWorld().spawnEntity(player.getLocation(), entity);
                }
            } catch (IllegalArgumentException e) {
                player.sendMessage("§c§l (!) §cThat is not a valid entity!");
            }
        } else {
                player.sendMessage("§c§l(!) §c/spawnmob <mob> <amount>");
            }
        }
        if (cmd.getName().equalsIgnoreCase("givewand")){
            player.getInventory().addItem(itemmanager.wand);
        }

        if(cmd.getName().equalsIgnoreCase("select")) {
            selectscreen gui = new selectscreen();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.AQUA + "Please make a selection!");
        }



        return true;
    }
}
