package com.skullzbones.devbeans.Events.allevents;

import com.skullzbones.devbeans.Items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BeanEvents implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        /*if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.bean.getItemMeta())) {
                    Player player = event.getPlayer();
                    PotionEffect invincibility = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 4);
                    player.addPotionEffect(invincibility);
                    player.getWorld().createExplosion(player.getLocation(), 2.0f);
                    player.sendMessage("§6Are!!!");
                }
            }
        }*/ //DONT UNCOMMENT IF YOU DONT WANA SEE YOUR SERVER DESTROYED!!
    }
}
