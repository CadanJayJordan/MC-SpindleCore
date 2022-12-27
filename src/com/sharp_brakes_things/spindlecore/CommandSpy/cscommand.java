package com.sharp_brakes_things.spindlecore.CommandSpy;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sharp_brakes_things.spindlecore.CoreMain;

public class cscommand implements CommandExecutor {
    public static CoreMain plugin;
    public cscommand(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	public static ArrayList<UUID> toggleCSList = new ArrayList<UUID>();
	public static Player player = null;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			player = (Player) sender;
			if (!sender.hasPermission("spindlemc.cspy")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
			} else {
				if (!(toggleCSList.contains(player.getUniqueId()))){
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bCommand Spy &aEnabled"));
					toggleCSList.add(player.getUniqueId());
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bCommand Spy &4Disabled"));
					toggleCSList.remove(player.getUniqueId());
				}
			}
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + playerOnly));
		}
		return true;
	}

}
