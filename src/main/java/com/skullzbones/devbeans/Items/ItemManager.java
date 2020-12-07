package com.skullzbones.devbeans.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import static net.md_5.bungee.api.ChatColor.*;

public class ItemManager {

    public static ItemStack bean;
    public static ItemStack golden_bean;

    public static void init() {
        creatBean();
        creatgoldenBean();
    }

    private static void creatBean() {

        ItemStack item = new ItemStack(Material.POTATO, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(YELLOW+"Bean");
        List<String> lore = new ArrayList<>();
        lore.add(YELLOW+"Bean, Symbol Of Holyness!");
        lore.add(YELLOW+"Devlauncher's ancient history!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        bean = item;
    }

    private static void creatgoldenBean() {
        ItemStack item = new ItemStack(Material.BAKED_POTATO, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(GOLD+"Golden Bean");
        List<String> lore = new ArrayList<>();
        lore.add(GOLD+"Golden Bean, Its Golden!");
        lore.add(GOLD+"It Shines Because.. Its Golden!!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        golden_bean = item;
    }

}
