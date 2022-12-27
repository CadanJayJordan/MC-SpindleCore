package com.sharp_brakes_things.spindlecore.staffUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sharp_brakes_things.spindlecore.CoreMain;
import com.sharp_brakes_things.spindlecore.CommandSpy.cscommand;
import com.sharp_brakes_things.spindlecore.MessageSpy.ssCommand;

public class staffUICommandMenuListner implements Listener{
    public static CoreMain plugin;
    public staffUICommandMenuListner(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	@EventHandler
	public void onClick(InventoryClickEvent e) {
	    if (e.getClickedInventory() == null) return;
	    if (e.getCurrentItem() == null) return;
    	Player player = (Player) e.getWhoClicked();
    	
		if (ChatColor.translateAlternateColorCodes('&', e.getClickedInventory().getTitle()).equals(ChatColor.DARK_RED + "Staff Member: " + staffUICommand.player.getName())) {
			if(e.getCurrentItem() != null) {
				e.setCancelled(true);
				
				switch(e.getCurrentItem().getType()) {
				case GLASS:
					player.performCommand("SuperVanish:sv");
					break;
				case CHEST:
					Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " chest 4");
					break;
				case COMMAND:
				    if (!(cscommand.toggleCSList.contains(player.getUniqueId()))){
	                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bCommand Spy &aEnabled"));
	                    cscommand.toggleCSList.add(player.getUniqueId());
	                } else {
	                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bCommand Spy &4Disabled"));
	                    cscommand.toggleCSList.remove(player.getUniqueId());
	                }
				    break;
				case SIGN:
				    if (!(ssCommand.toggleSSList.contains(player.getUniqueId()))){
	                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bMessage Spy &aEnabled"));
	                    ssCommand.toggleSSList.add(player.getUniqueId());
	                } else {
	                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&bMessage Spy &4Disabled"));
	                    ssCommand.toggleSSList.remove(player.getUniqueId());
	                }
				    break;
				default:
					return;
				}
				player.closeInventory();
			} else {
			    return;
			}
		} else {
			return;
		}
	}
}
