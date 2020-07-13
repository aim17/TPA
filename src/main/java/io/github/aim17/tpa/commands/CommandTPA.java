package io.github.aim17.tpa.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import io.github.aim17.tpa.TPA;

public class CommandTPA implements CommandExecutor {
    private TPA plugin;
    
    public CommandTPA(TPA plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Error: Must be a player to use this command.");
            return true;
        }
        if (args == null || args.length != 1) {
            sender.sendMessage("Must supply the correct argument.");
            return false;
        }
        
        sender.sendMessage("You entered: /" + label + " " + args[0]);
        
        Player recipient = Bukkit.getPlayer(args[0]);
        if (recipient == null) {
            sender.sendMessage("The player could not be found.");
            return true;
        }
        //TODO: Add check to see if a tpa request is already in arraylist in TPA.java
        plugin.sendTPARequest((Player) sender, recipient);

        
        
        return true;
    }

    
}
