package com.skullzbones.devbeans.Commands.Beans.Sub;

import com.skullzbones.devbeans.Commands.GetPlayerOrReturn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static net.md_5.bungee.api.ChatColor.*;

public class help implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if((player = GetPlayerOrReturn.getPlayerFromSender(sender))!=null)

        player.sendMessage(BOLD + "" + GRAY + "———————---" + RESET + GOLD + " Beans Help " + RESET + GRAY + BOLD + "————---———");
        player.sendMessage(GOLD + "/beans help" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Shows the user all of Beans commands.");
        player.sendMessage(GOLD + "/beans info" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Shows the user all of Beans information.");
        player.sendMessage(GOLD + "/beans trade [name]" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Allows the user to trade golden beans for selected items!");
        player.sendMessage(GOLD + "/beans gamble" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Gamble your beans, you could get an awesome item!!");
        return false;
    }
}
