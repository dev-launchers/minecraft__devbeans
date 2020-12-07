package com.skullzbones.devbeans.Commands.testcommands_remove_this;

import com.skullzbones.devbeans.Commands.Beans.Sub.help;
import com.skullzbones.devbeans.Commands.CommandBase;
import com.skullzbones.devbeans.Devbeans;
import com.skullzbones.devbeans.Items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.*;
import static net.md_5.bungee.api.ChatColor.GRAY;

public class TestExec {

    public static void RegisterMainCommands(Devbeans devbeans){
        CommandBase<Devbeans> testExec = new CommandBase<Devbeans>(devbeans) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                //GIVVE ITEM
                sender.sendMessage("§6Run Test Command 1");
                Player player = (Player) sender;
                player.getInventory().addItem(ItemManager.bean);
                player.getInventory().addItem(ItemManager.golden_bean);
                return true;
            }
        };

        devbeans.getCommand("test").setExecutor(testExec);
        //testExec.registerSubCommand("test", new testExec());
    }

}
