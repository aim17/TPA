package io.github.aim17.tpa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import io.github.aim17.tpa.TPA;

public class CommandTPAccept implements CommandExecutor {
    private TPA plugin;
    
    public CommandTPAccept (TPA plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(plugin.getRequestList().containsKey(sender.getName())) {
            plugin.teleport(plugin.getRequestList().get(sender.getName()), sender.getName());
            plugin.removeRequest(plugin.getRequestList().get(sender.getName()), sender.getName());
        }
        
        return true;
    }

}
