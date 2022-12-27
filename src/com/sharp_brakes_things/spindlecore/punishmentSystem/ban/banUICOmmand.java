package com.sharp_brakes_things.spindlecore.punishmentSystem.ban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sharp_brakes_things.spindlecore.CoreMain;
import com.sharp_brakes_things.spindlecore.Inventory.inventorySetting;

public class banUICOmmand implements CommandExecutor {
    public static CoreMain plugin;
    public banUICOmmand(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	public static OfflinePlayer target = null;
	public static Player player = null;
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
		    //Console//
		    if (sender.hasPermission("litebans.ban") && sender.hasPermission("spindlemc.staff")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Ivalid usage: /ban <Player>"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Example: /ban Sharp_brakes"));
                } else if (args.length == 1) {
                    target = Bukkit.getOfflinePlayer(args[0]);
                    if (target == null ) {
                        return true;
                    }
                    if (!target.isOnline()) {
                        if (sender.hasPermission("spindlemc.staff.admin")){
                            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:ban " + target.getName() + " (C) Manually Perm Banned -s");
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
                        }
                    } else {
                        Player onlinePlayer = target.getPlayer();
                        if (target == null) {
                            return true;
                        }
                        if (sender.hasPermission("spindlemc.staff.admin")){
                            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:ban " + target.getName() + " (C) Manually Perm Banned -s");
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
                        }
                    }
                } else if (args.length >= 2) {
                    target = Bukkit.getOfflinePlayer(args[0]);
                    if (target == null) {
                        return true;
                    }
                    if (!target.isOnline()) {
                        String reason = "";
                        for (String word : args) {
                            reason += " " + word;
                        }
                        reason = reason.substring(target.getName().length() + 2);
                        if (sender.hasPermission("spindlemc.staff.admin")) {
                            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:ban " + target.getName() + " (C) " + reason + " -s");
                        }
                    } else {
                        Player onlinePlayer = target.getPlayer();
                        String reason = "";
                        for (String word : args) {
                            reason += " " + word;
                        }
                        reason = reason.substring(target.getName().length() + 2);
                        if (player.hasPermission("spindlemc.staff.admin")) {
                            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "litebans:ban " + target.getName() + " (C) " + reason + " -s");
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bSpindle&3]&4 Ivalid usage: /ban <Player>"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bSpindle&3]&4 Example: /ban Sharp_brakes"));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
            }
		} else {
		    //Player//
			if (sender.hasPermission("litebans.ban") && sender.hasPermission("spindlemc.staff")) {
				Player player = (Player) sender;
				if (args.length == 0) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Ivalid usage: /ban <Player>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Example: /ban Sharp_brakes"));
				} else if (args.length == 1) {
					target = Bukkit.getOfflinePlayer(args[0]);
					if (target == null ) {
						return true;
					}
					if (!target.isOnline()) {
						if (sender.hasPermission("spindlemc.staff.admin")){
							inventorySetting.applyOfflineaBanUI(player);
						} else if (sender.hasPermission("spindlemc.staff.mod")) {
								inventorySetting.applyOfflineBanUI(player);
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
						}
					} else {
						Player onlinePlayer = target.getPlayer();
						if (target == null) {
							return true;
						}
						if (sender.hasPermission("spindlemc.staff.admin")){
							inventorySetting.applyaBanUI(player);
						} else if (sender.hasPermission("spindlemc.staff.mod")) {
								inventorySetting.applyBanUI(player);
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
						}
					}
				} else if (args.length >= 2) {
					target = Bukkit.getOfflinePlayer(args[0]);
					if (target == null) {
						return true;
					}
					if (!target.isOnline()) {
						if (player.hasPermission("spindlemc.staff.ban.manual")) {
							String reason = "";
							for (String word : args) {
								reason += " " + word;
							}
							reason = reason.substring(target.getName().length() + 2);
							if (player.hasPermission("spindlemc.staff.admin")) {
								player.performCommand("litebans:ban " + target.getName() + " (A) " + reason + " -s");
							} else if (player.hasPermission("spindlemc.staff.mod")) {
								player.performCommand("litebans:ban " + target.getName() + " (M) " + reason + " -s");
		                    }
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&3Attempting to open 'BanUI'"));
							if (sender.hasPermission("spindlemc.staff.admin")){
								inventorySetting.applyOfflineaBanUI(player);
							} else if (sender.hasPermission("spindlemc.staff.mod")) {
									inventorySetting.applyOfflineBanUI(player);
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
							}
						}
					} else {
						Player onlinePlayer = target.getPlayer();
						if (player.hasPermission("spindlemc.staff.ban.manual")) {
							String reason = "";
							for (String word : args) {
								reason += " " + word;
							}
							reason = reason.substring(target.getName().length() + 2);
							if (player.hasPermission("spindlemc.staff.admin")) {
								player.performCommand("litebans:ban " + target.getName() + " (A) " + reason + " -s");
							} else if (player.hasPermission("spindlemc.staff.mod")) {
								player.performCommand("litebans:ban " + target.getName() + " (M) " + reason + " -s");
		                    }
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&3Attempting to open 'BanUI'"));
							if (sender.hasPermission("spindlemc.staff.admin")){
								inventorySetting.applyaBanUI(player);
							} else if (sender.hasPermission("spindlemc.staff.mod")) {
									inventorySetting.applyBanUI(player);
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
							}
						}
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bSpindle&3]&4 Ivalid usage: /ban <Player>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bSpindle&3]&4 Example: /ban Sharp_brakes"));
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
			}
		}
		return true;
	}
}