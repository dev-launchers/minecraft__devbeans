package com.skullzbones.devbeans;

import com.skullzbones.devbeans.Commands.Beans.BeansExec;
import com.skullzbones.devbeans.Commands.CommandsRegistrar;
import com.skullzbones.devbeans.Events.EventsRegistrar;
import com.skullzbones.devbeans.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Devbeans extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("DevBeans Plugin Enabled!");

        ItemManager.init();
        CommandsRegistrar.RegisterAllCommands(this);
        EventsRegistrar.RegisterAllEvents(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}