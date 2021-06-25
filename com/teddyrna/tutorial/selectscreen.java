package com.teddyrna.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class selectscreen implements InventoryHolder {

        private Inventory inv;


        public selectscreen(){
            inv = Bukkit.createInventory(this, 9, "Selection Screen"); // 54 max size, increments of 9
            init();



        }

        private void init() {
            //Left
            ItemStack item;
            for(int i = 0; i < 4; i++){
                item = createItem("§a§lAccept", Material.LIME_STAINED_GLASS_PANE, Collections.singletonList("§7Accept the request"));
                inv.setItem(i, item);
            }

            //Center
            List<String> lore = new ArrayList<>();
            lore.add("hello");
            lore.add("there");
            item = createItem("§b§lMake a Selection", Material.BOOK, lore);
            inv.setItem(inv.firstEmpty(), item);

            //Right
            for (int i= 5; i < 9; i++) {
                item = createItem("§c§lDeny", Material.RED_STAINED_GLASS_PANE, Collections.singletonList("§7Denies the request!"));
            }
        }

        private ItemStack createItem(String name, Material mat, List<String> lore) {
            ItemStack item = new ItemStack(mat, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }

        @Override
        public Inventory getInventory() {
            return inv;
        }

}
