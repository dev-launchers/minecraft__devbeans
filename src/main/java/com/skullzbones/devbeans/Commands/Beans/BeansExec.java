package com.skullzbones.devbeans.Commands.Beans;

import com.skullzbones.devbeans.Commands.Beans.Sub.help;
import com.skullzbones.devbeans.Commands.CommandBase;
import com.skullzbones.devbeans.Devbeans;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import static net.md_5.bungee.api.ChatColor.*;
import static net.md_5.bungee.api.ChatColor.GRAY;

public class BeansExec {

    public static void RegisterMainCommands(Devbeans devbeans){
        CommandBase<Devbeans> beansExec = new CommandBase<Devbeans>(devbeans) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                sender.sendMessage(RED + "INVALID COMMAND, SHOWING HELP PAGE!");
                new help().onCommand(sender,null,null,null);
                return false;
            }
        };

        devbeans.getCommand("beans").setExecutor(beansExec);
        beansExec.registerSubCommand("help", new help());
    }

}
