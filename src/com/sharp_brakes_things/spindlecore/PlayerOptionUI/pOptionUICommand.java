package com.sharp_brakes_things.spindlecore.PlayerOptionUI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sharp_brakes_things.spindlecore.CoreMain;
import com.sharp_brakes_things.spindlecore.Inventory.inventorySetting;

public class pOptionUICommand implements CommandExecutor {
    public static CoreMain plugin;
    public pOptionUICommand(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + playerOnly));
		} else {
		Player player = (Player) sender;
		if (player.hasPermission("spindlemc.player.options")) {
			inventorySetting.applyPOptionUI(player);
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
			}
		}
		return true;
		
	}

}
