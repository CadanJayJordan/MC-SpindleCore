package com.sharp_brakes_things.spindlecore.punishmentSystem.unban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sharp_brakes_things.spindlecore.CoreMain;

public class unbanCommand implements CommandExecutor{
    public static CoreMain plugin;
    public unbanCommand(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
		    if (sender.hasPermission("spindlemc.staff") && sender.hasPermission("litebans.unban") && sender.hasPermission("litebans.unban.queue")) {
                if (args.length == 1) { 
                    OfflinePlayer target = (OfflinePlayer) Bukkit.getOfflinePlayer(args[0]);
                    if (target == null) {
                        return true;
                    }
                    if (!target.isOnline()) {
                        
                        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:unban " + target.getName() + " -s");
                    } else {
                        Player onlinePlayer = target.getPlayer();
                        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:unban " + target.getName() + " -s");
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Invalid Usage: /unban <Player>"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Example: /unban Sharp_brakes"));
                }
            } else { 
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
            }
		} else {
			Player player = (Player) sender;
			if (sender.hasPermission("spindlemc.staff") && sender.hasPermission("litebans.unban") && player.hasPermission("litebans.unban.queue")) {
				if (args.length == 1) {	
					OfflinePlayer target = (OfflinePlayer) Bukkit.getOfflinePlayer(args[0]);
					if (target == null) {
						return true;
					}
					if (!target.isOnline()) {
						
						player.performCommand("litebans:unban " + target.getName() + " -s");
					} else {
					Player onlinePlayer = target.getPlayer();
					player.performCommand("litebans:unban " + target.getName() + " -s");
					}
				} else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Invalid Usage: /unban <Player>"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Example: /unban Sharp_brakes"));
                }
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
			}
		}
		return true;
	}

}
