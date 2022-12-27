package com.sharp_brakes_things.spindlecore.PlayerOptionUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sharp_brakes_things.spindlecore.CoreMain;
import com.sharp_brakes_things.spindlecore.Inventory.inventorySetting;

public class pOptionUICommandMenuListener implements Listener {
    public static CoreMain plugin;
    public pOptionUICommandMenuListener(CoreMain instance){
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
		
		if (e.getInventory().getHolder() == this) {
			if(e.getCurrentItem() != null) {
				e.setCancelled(true);
				
				switch(e.getCurrentItem().getType()) {
				case ELYTRA:
					if(player.getInventory().getChestplate() != null) {
						inventorySetting.elytraChestSlot.put(player, player.getInventory().getChestplate().getType());
					}
					ItemStack elytra = new ItemStack(Material.ELYTRA);
					ItemMeta elytraMeta = elytra.getItemMeta();
					elytraMeta.addEnchant(Enchantment.DURABILITY, 100, true);
					elytraMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
					elytra.setItemMeta(elytraMeta);
							
					player.getInventory().setChestplate(elytra);
					
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&aEnabled Elytra"));
					break;
				case REDSTONE_BLOCK:
					if(inventorySetting.elytraChestSlot.containsKey(player)) {
						player.getInventory().setChestplate(new ItemStack(inventorySetting.elytraChestSlot.get(player)));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Disabled eytra &band returned chestplate"));
					} else {
						player.getInventory().setChestplate(null);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&4Disabled eytra"));
					}
					break;
				case MAP:
					player.performCommand("spawn");
					break;
				default:
					return;
				}
				player.closeInventory();
			}
			
		} else {
		    return;
		}
	}
}
