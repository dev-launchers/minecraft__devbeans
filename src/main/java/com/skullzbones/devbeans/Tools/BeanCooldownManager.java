package com.skullzbones.devbeans.Tools;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BeanCooldownManager {

    static Map<UUID, Double> cooldowns = new HashMap<>();

    public static void setCooldowns(Player player, int secondes){
        double delay = System.currentTimeMillis() + (secondes * 1000);
        cooldowns.put(player.getUniqueId(), delay);

    }

    public static int getCooldowns(Player player){
        return Math.toIntExact(Math.round((cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()/1000)));
    }

    public static boolean checkCooldowns(Player player){
        return !cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis();
    }
}