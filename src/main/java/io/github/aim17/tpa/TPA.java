package io.github.aim17.tpa;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.aim17.tpa.commands.CommandTPA;
import io.github.aim17.tpa.commands.CommandTPAccept;

public class TPA extends JavaPlugin {
    
    HashMap<String, String> requestList;
    

    // Initialize plugin
    @Override
    public void onEnable() {
        this.getCommand("tpa").setExecutor(new CommandTPA(this));
        this.getCommand("tpaccept").setExecutor(new CommandTPAccept(this));
        requestList = new HashMap<String, String>();
    }
    
    // Disable plugin
    @Override
    public void onDisable() {
        
    }
    
    public TPA getPlugin() {
        return this;
    }
    
    public HashMap<String, String> getRequestList() {
        return requestList;
    }
    
    public void removeRequest(String sender, String recipient) {
        // In this case, sender & recipient are based on location in requestList
        requestList.remove(recipient, sender);
    }

    public void sendTPARequest(Player sender, Player recipient) {
        sender.sendMessage("Teleport request sent.");
        recipient.sendMessage("Teleport request received. Type /tpaccept to accept.");
        requestList.put(recipient.getName(), sender.getName());
    }

    public void teleport(String sender, String recipient) {
        Player playerSender = this.getServer().getPlayer(sender);
        Player playerReceiver = this.getServer().getPlayer(recipient);
        playerSender.teleport(playerReceiver);
    }
    
}
