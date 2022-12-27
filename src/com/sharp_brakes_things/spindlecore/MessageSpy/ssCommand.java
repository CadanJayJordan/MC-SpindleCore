package com.sharp_brakes_things.spindlecore.MessageSpy;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sharp_brakes_things.spindlecore.CoreMain;

public class ssCommand implements CommandExecutor{
    public static CoreMain plugin;
    public ssCommand(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	public static ArrayList<UUID> toggleSSList = new ArrayList<UUID>();
	public static Player player = null;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			player = (Player) sender;
			if (!sender.hasPermission("spindlemc.sspy")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + noPerms));
			} else {
				if (!(toggleSSList.contains(player.getUniqueId()))){
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bMessage Spy &aEnabled"));
					toggleSSList.add(player.getUniqueId());
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bMessage Spy &4Disabled"));
					toggleSSList.remove(player.getUniqueId());
				}
			}
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + playerOnly));
		}
		return true;
	}
	

}
