package com.skullzbones.devbeans.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
    public static ItemStack build_bean_bucket;

    public static void init() {
        creatBean();
        creatgoldenBean();
        createBuildBean();
        createBuildBeanWand();
        createBuildBeanBucket();
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


    private static void createBuildBeanBucket() {
        ItemStack item = new ItemStack(Material.HOPPER, 1);
        ItemMeta meta = item.getItemMeta();


        meta.setDisplayName(GOLD+"Bean Bucket!");
        List<String> lore = new ArrayList<>();
        lore.add(GOLD+"Can you pass your beans to this bucket?");
        lore.add(GOLD+"Farm your beans by depositing them to here!");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        build_bean_bucket = item;
    }

    public static ItemStack setName(ItemStack is, String name){
        ItemMeta m = is.getItemMeta();
        m.setDisplayName(name);
        is.setItemMeta(m);
        return is;
    }

    public static void removeInventoryItems(Player player) {
        int a = player.getInventory().getItemInMainHand().getAmount();
        player.getInventory().getItemInMainHand().setAmount(a);
        if(a==1) {a=1; player.getInventory().removeItem(player.getInventory().getItemInMainHand()); }
        else a--;
    }

}
