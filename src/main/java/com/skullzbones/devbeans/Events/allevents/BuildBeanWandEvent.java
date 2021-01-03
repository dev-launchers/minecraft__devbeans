package com.skullzbones.devbeans.Events.allevents;

import com.skullzbones.devbeans.Items.ItemManager;
import org.apache.commons.lang.CharUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.skullzbones.devbeans.Tools.BlockFaces;

public class BuildBeanWandEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.build_bean_pod_wand.getItemMeta())) {
                    Player player = event.getPlayer();

                    Block b = BlockFaces.getBlockEntity(player);

                    if(b.getType().equals(Material.AIR) && false){  //FALSE
                        player.sendMessage("You need to point at a block!");
                    }
                    else {
                        PotionEffect invincibility = new PotionEffect(PotionEffectType.LUCK, 10, 4);
                        player.addPotionEffect(invincibility);
                        Location bl = b.getLocation();
                        ItemFrame itm = player.getWorld().spawn(bl, ItemFrame.class);
                        itm.setItem(ItemManager.build_bean);

                    }

                    /*Block block = player.getWorld().getBlockAt(player.getLocation());
                    if(!(block.getState() instanceof Sign)) {
                        block.setType(Material.OAK_WALL_SIGN);
                        Sign sign = (Sign) block.getState();
                        sign.setLine(0, "watTheFj");


                    }*/

                    player.sendMessage("§6Are!!!");
                }
            }
        } //DONT UNCOMMENT IF YOU DONT WANA SEE YOUR SERVER DESTROYED!!
    }
}
