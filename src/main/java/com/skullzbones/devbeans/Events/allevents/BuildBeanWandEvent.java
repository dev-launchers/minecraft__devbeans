package com.skullzbones.devbeans.Events.allevents;

import com.google.common.collect.Lists;
import com.skullzbones.devbeans.Devbeans;
import com.skullzbones.devbeans.Items.ItemManager;
import com.skullzbones.devbeans.Tools.BeanCooldownManager;
import com.skullzbones.devbeans.Tools.SignInput;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.CharUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.skullzbones.devbeans.Tools.BlockFaces;


import java.beans.Visibility;
import java.math.BigInteger;


import static com.skullzbones.devbeans.Tools.BeanCooldownManager.setCooldowns;
import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.event.EventPriority.HIGHEST;

public class BuildBeanWandEvent implements Listener {


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof ItemFrame) {
            Entity entity = e.getDamager();
            if(!(entity instanceof Player)) return;
            Player player = (Player) e.getDamager();
            ItemFrame itemFrame = (ItemFrame) e.getEntity();
            if (itemFrame.getItem().equals(ItemManager.build_bean)) {
                if(itemFrame.getItem().getItemMeta().getDisplayName().contains(player.getDisplayName())){
                    setCooldowns(player,1);
                    player.sendMessage("Item has been placed in your inventory!!");
                    player.getInventory().addItem(ItemManager.build_bean);
                    itemFrame.remove();
                    return;
                }
                player.sendMessage("Yay! Sweet Bean Sweet Bean!");
                player.getInventory().addItem(ItemManager.build_bean);
                itemFrame.remove();
            }
        }
    }


    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onHangingBreak(HangingBreakEvent event) {
        if (event.getCause() == HangingBreakEvent.RemoveCause.EXPLOSION) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        for (Entity entity : event.getBlock().getWorld().getNearbyEntities(event.getBlock().getLocation(), 2, 2, 2)) {
            if (entity instanceof ItemFrame && entity.getLocation().getBlock().getRelative(((ItemFrame) entity).getAttachedFace()).equals(event.getBlock())) {
                ItemFrame itemFrame = (ItemFrame) entity;

                //Your code
                if (itemFrame.getItem().equals(ItemManager.build_bean)) {
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }

/*    @EventHandler
    public void onFramePlace(HangingPlaceEvent event) {

        Player player = event.getPlayer();
        if(event.getEntity() instanceof ItemFrame && player.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "You cannot do that while in creative mode!");
        }

    }*/

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.build_bean.getItemMeta())) {
                    Player player = event.getPlayer();

                    if(!BeanCooldownManager.checkCooldowns(player)){

                        player.sendMessage(String.format("You can only use this command once! Wait full 24 hours!"));
                        return;
                    }
                    Block b = BlockFaces.getBlockEntity(player);

                    if(!b.getType().equals(Material.AIR)){  //FALSE
                        player.sendMessage("You need to point at a block!");
                    }
                    else {
                        PotionEffect invincibility = new PotionEffect(PotionEffectType.LUCK, 10, 4);
                        player.addPotionEffect(invincibility);
                        Location bl = b.getLocation();
                        ItemFrame itm = player.getWorld().spawn(bl, ItemFrame.class);
                        itm.setVisible(false);

                        Devbeans.signMenuFactory
                                .newMenu(Lists.newArrayList("&a&lNyce!", "&5", "&6", "&7"))
                                .reopenIfFail()
                                .response((player1, lines) -> {
                                    Bukkit.getServer().getLogger().info(lines[0]);
                                    itm.setItem(ItemManager.setName(ItemManager.build_bean,ChatColor.YELLOW + "By "+ChatColor.BLUE +player1.getDisplayName()+", "+ChatColor.DARK_GREEN+lines[0]+" "+lines[1]+" "+lines[2]));
                                    setCooldowns(player1,60*6);
                                    ItemManager.removeInventoryItems(player1);
                                    return true;
                                    //return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                                })
                                .open(player);

                    }

                    /*Block block = player.getWorld().getBlockAt(player.getLocation());
                    if(!(block.getState() instanceof Sign)) {
                        block.setType(Material.OAK_WALL_SIGN);
                        Sign sign = (Sign) block.getState();
                        sign.setLine(0, "watTheFj");


                    }*/
                }
            }
        } //DONT UNCOMMENT IF YOU DONT WANA SEE YOUR SERVER DESTROYED!!
    }
}
