package com.teddyrna.tutorial.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemmanager {

    public static ItemStack wand;

    public static void init(){

        createWand();

    }

    private static void createWand(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Stick of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerful artifact is");
        lore.add("§7a relic of Minecraft's");
        lore.add("§7ancient history!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;


        //Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        sr.shape ("B  ",
                  " S ",
                  "  S");
        sr.setIngredient('B', Material.BLAZE_POWDER);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        //Shapeless Recipe
        ShapelessRecipe sar = new ShapelessRecipe(NamespacedKey.minecraft("wand_shapeless"), item);
        sar.addIngredient(2, Material.BLAZE_POWDER);
        sar.addIngredient(1, Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(sar);

        //Furnace Recipe
        FurnaceRecipe smelt = new FurnaceRecipe(NamespacedKey.minecraft("wand_smelt"), item, Material.EMERALD, 1.0f, 200);
        Bukkit.getServer().addRecipe(smelt);
    }

}
