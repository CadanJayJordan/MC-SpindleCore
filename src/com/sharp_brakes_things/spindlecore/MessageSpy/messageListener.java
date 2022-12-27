package com.sharp_brakes_things.spindlecore.MessageSpy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.sharp_brakes_things.spindlecore.CoreMain;

public class messageListener implements Listener{
    public static CoreMain plugin;
    public messageListener(CoreMain instance){
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
				if (ssCommand.toggleSSList.contains(player2.getUniqueId())) {
					if (player.hasPermission("spindlemc.sspy.exempt")) {
					} else {
					if (player.getUniqueId() == player2.getUniqueId()) {
					} else {
						if (e.getMessage().contains("/msg") || e.getMessage().contains("/r") || e.getMessage().contains("/w") || e.getMessage().contains("/mail") || e.getMessage().contains("/m")  || e.getMessage().contains("/t")  || e.getMessage().contains("/whisper") || e.getMessage().contains("/emsg") || e.getMessage().contains("/tell") || e.getMessage().contains("/er") || e.getMessage().contains("/ereply") || e.getMessage().contains("/email") || e.getMessage().contains("/action") || e.getMessage().contains("/describe") || e.getMessage().contains("/eme") || e.getMessage().contains("/eaction") || e.getMessage().contains("/edescribe") || e.getMessage().contains("/etell") || e.getMessage().contains("/ewhisper") || e.getMessage().contains("/pm")) {
							player2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&bStaff Only&3] [&bSS&3] " + player.getName().toString() + "&b: Message: '&3" + e.getMessage() + "&b'"));
						}
					}
				}
			}
		}
	}
}
