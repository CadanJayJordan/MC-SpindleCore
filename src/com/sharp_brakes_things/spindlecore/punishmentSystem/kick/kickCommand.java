package com.sharp_brakes_things.spindlecore.punishmentSystem.kick;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sharp_brakes_things.spindlecore.CoreMain;

public class kickCommand implements CommandExecutor{
    public static CoreMain plugin;
    public kickCommand(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    
		if(!(sender instanceof Player)) {
		    if (sender.hasPermission("spindlemc.staff") && sender.hasPermission("litebans.kick")) {
                if (args.length >= 2) {
                    Player target = (Player) Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        return true;
                    } else {
                        String reason = "";
                        for (String word : args) {
                            reason += " " + word;
                        }
                        
                        reason = reason.substring(target.getName().length() + 2);
                        if (sender.hasPermission("spindlemc.staff.admin")) {
                            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:kick " + target.getName() + " (C) " + reason + " -s");
                        }
                    }
                } else {
                    if (args.length == 1) {
                        Player target = (Player) Bukkit.getPlayer(args[0]);
                        if (target == null) {
                            return true;
                        } else {
                            if (sender.hasPermission("spindlemc.staff.admin")) {
                                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:kick " + target.getName() + " (C) Manually Kicked -s");
                            }
                            
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Ivalid usage: /kick <Player>"));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Example: /kick Sharp_brakes"));
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
            }
		} else {
			Player player = (Player) sender;
			if (sender.hasPermission("spindlemc.staff") && sender.hasPermission("litebans.kick")) {
				if (args.length >= 2) {
					Player target = (Player) Bukkit.getPlayer(args[0]);
					if (target == null) {
						return true;
					} else {
						String reason = "";
						for (String word : args) {
							reason += " " + word;
						}
						
						reason = reason.substring(target.getName().length() + 2);
						if (player.hasPermission("spindlemc.staff.admin")) {
							player.performCommand("litebans:kick " + target.getName() + " (A) " + reason + " -s");
						} else if (player.hasPermission("spindlemc.staff.mod")) {
							player.performCommand("litebans:kick " + target.getName() + " (M) " + reason + " -s");
	                    }
					}
				} else {
					if (args.length == 1) {
						Player target = (Player) Bukkit.getPlayer(args[0]);
						if (target == null) {
							return true;
						} else {
							if (player.hasPermission("spindlemc.staff.admin")) {
						player.performCommand("litebans:kick " + target.getName() + " (A) Manually Kicked -s");
							} else if (player.hasPermission("spindlemc.staff.mod")) {
								player.performCommand("litebans:kick " + target.getName() + " (M) Manually Kicked -s");
							}
							
						}
					} else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Ivalid usage: /kick <Player>"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Example: /kick Sharp_brakes"));
					}
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
			}
		}
		return true;
	}

}
