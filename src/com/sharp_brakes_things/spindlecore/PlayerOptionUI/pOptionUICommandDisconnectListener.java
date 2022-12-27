package com.sharp_brakes_things.spindlecore.PlayerOptionUI;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.sharp_brakes_things.spindlecore.CoreMain;
import com.sharp_brakes_things.spindlecore.Inventory.inventorySetting;

public class pOptionUICommandDisconnectListener implements Listener {
    public static CoreMain plugin;
    public pOptionUICommandDisconnectListener(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if(inventorySetting.elytraChestSlot.containsKey(player)) {
			player.getInventory().setChestplate(new ItemStack(inventorySetting.elytraChestSlot.get(player)));
		} else {
			player.getInventory().setChestplate(null);
		}
		
	}

	@EventHandler
	public void onBadDisconnect(PlayerBedLeaveEvent e) {
		Player player = e.getPlayer();
		if(inventorySetting.elytraChestSlot.containsKey(player)) {
			player.getInventory().setChestplate(new ItemStack(inventorySetting.elytraChestSlot.get(player)));
		} else {
			player.getInventory().setChestplate(null);
		}
		
	}
}
