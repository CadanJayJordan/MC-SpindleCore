package com.sharp_brakes_things.spindlecore.CommandSpy;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.sharp_brakes_things.spindlecore.CoreMain;

public class commandListener implements Listener {
    public static CoreMain plugin;
    public commandListener(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();
			for(Player player2 : Bukkit.getOnlinePlayers()) {
				if (cscommand.toggleCSList.contains(player2.getUniqueId())) {
					if (player.hasPermission("spindlemc.cspy.exempt")) {
					} else {
					if (player.getUniqueId() == player2.getUniqueId()) {						
						} else {
							if (player2.hasPermission("spindlemc.staff.admin")) {
								if (e.getMessage().contains("/") && !e.getMessage().contains(":") && !e.getMessage().contains("/msg") && !e.getMessage().contains("/r") && !e.getMessage().contains("/w") && !e.getMessage().contains("/mail") && !e.getMessage().contains("/m") && !e.getMessage().contains("/t") && !e.getMessage().contains("/whisper") && !e.getMessage().contains("/emsg") && !e.getMessage().contains("/tell") && !e.getMessage().contains("/er") && !e.getMessage().contains("/ereply") && !e.getMessage().contains("/email") && !e.getMessage().contains("/action") && !e.getMessage().contains("/describe") && !e.getMessage().contains("/eme") && !e.getMessage().contains("/eaction") && !e.getMessage().contains("/edescribe") && !e.getMessage().contains("/etell") && !e.getMessage().contains("/ewhisper") && !e.getMessage().contains("/pm")) {
									player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bAdmin Only&3] [&bCS&3] " + player.getName().toString() + "&b: Command: '&3" + e.getMessage() + "&b'"));
								}
						} else {
							if (player2.hasPermission("spindlemc.staff.mod")) {
								if (e.getMessage().contains("/gm") || e.getMessage().contains("/op") || e.getMessage().contains("/gamemode") || e.getMessage().contains("/ban")  || e.getMessage().contains("/tempban")  || e.getMessage().contains("/deop") || e.getMessage().contains("/lp") || e.getMessage().contains("/pex")) {
									player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bMod Only&3] [&bCS&3] " + player.getName().toString() + "&b: Command: '&3" + e.getMessage() + "&b'"));
								}
							}
						}
					}
				}
			}
			if (player.hasPermission("spindlemc.bc.exempt")) {
			    return;
			} else {
        		if (e.getMessage().contains(":")) {
        			e.setCancelled(true);
        			player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&3[&bBlocked Command&3] " + player.getName() + "&b: Command: '&3" + e.getMessage() + "&b'"));
        			if (player2.hasPermission("spindlemc.staff.admin")) {
        				if (player.getUniqueId() == player2.getUniqueId()) {
        				} else {
        				player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bAdmin Only&3] [&bBC&3] " + player.getName() + "&b: Command: '&3" + e.getMessage() + "&b'"));
        				}
        			}
        		}
			}
		}
	}
}
