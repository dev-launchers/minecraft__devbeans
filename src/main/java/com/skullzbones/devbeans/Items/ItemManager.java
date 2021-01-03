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
    public static ItemStack build_bean;
    public static ItemStack build_bean_pod_wand;
    public static ItemStack build_bean_vines;
    public static ItemStack build_bean_bucket;

    public static void init() {
        creatBean();
        creatgoldenBean();
        createBuildBean();
        createBuildBeanWand();
        createBuildBeanVines();
    }


    private static void creatBean() {

        ItemStack item = new ItemStack(Material.POTATO, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(33);

        meta.setDisplayName(YELLOW+"Bean");

        List<String> lore = new ArrayList<>();
        lore.add(YELLOW+"Bean, Symbol Of Holyness!");
        lore.add(YELLOW+"Devlauncher's ancient history!");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        bean = item;
    }

    private static void creatgoldenBean() {
        ItemStack item = new ItemStack(Material.POTATO, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(34);

        meta.setDisplayName(GOLD+"Golden Bean");
        List<String> lore = new ArrayList<>();
        lore.add(GOLD+"Golden Bean, Its Golden!");
        lore.add(GOLD+"It Shines Because.. Its Golden!!");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        golden_bean = item;
    }


    private static void createBuildBean() {
        ItemStack item = new ItemStack(Material.POTATO, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(35);

        meta.setDisplayName(GOLD+"Build Bean");
        List<String> lore = new ArrayList<>();
        lore.add(GOLD+"Build Bean? Hey you built something? Let me check!");
        lore.add(GOLD+"A basic building currency!");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        build_bean = item;
    }

    private static void createBuildBeanWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(91);

        meta.setDisplayName(GOLD+"Build Bean Wand!");
        List<String> lore = new ArrayList<>();
        lore.add(GOLD+"Let the magical powers of this stick enlighten you!");
        lore.add(GOLD+"Giving a build bean to those who deserve it!");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        build_bean_pod_wand = item;
    }


    private static void createBuildBeanVines() {
        ItemStack item = new ItemStack(Material.SOUL_TORCH, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(92);

        meta.setDisplayName(GOLD+"Bean Torch!");
        List<String> lore = new ArrayList<>();
        lore.add(GOLD+"Vines to get your esteemed beans!!");
        lore.add(GOLD+"Dont farm it pal, you will anger the heavens!");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        build_bean_vines = item;
    }

}
