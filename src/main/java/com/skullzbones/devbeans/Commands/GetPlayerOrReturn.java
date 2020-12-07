package com.skullzbones.devbeans.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPlayerOrReturn {
    public static Player getPlayerFromSender(CommandSender sender){
        if(!(sender instanceof Player)){
            return null;
        }
        return (Player) sender;
    }
}
