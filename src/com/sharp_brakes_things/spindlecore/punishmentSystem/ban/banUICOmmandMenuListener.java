package com.sharp_brakes_things.spindlecore.punishmentSystem.ban;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sharp_brakes_things.spindlecore.CoreMain;


public class banUICOmmandMenuListener implements Listener{
    public static CoreMain plugin;
    public banUICOmmandMenuListener(CoreMain instance){
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
			 if(e.getCurrentItem().getType() != null) {
				e.setCancelled(true);
				switch(e.getCurrentItem().getType()) {
				case COAL_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 1hr (A) Manually Temporarily Banned -s");
					break;
				case REDSTONE_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 6hr (A) Manually Temporarily Banned -s");
					break;
				case LAPIS_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 1d (A) Manually Temporarily Banned  -s");
					break;
				case IRON_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 3d (A) Manually Temporarily Banned -s");
					break;
				case GOLD_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 5d (A) Manually Temporarily Banned -s");
					break;
				case EMERALD_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 10d (A) Manually Temporarily Banned -s");
					break;
				case DIAMOND_ORE:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 20d (A) Manually Temporarily Banned -s");
					break;
				case OBSIDIAN:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 30d (A) Manually Temporarily Banned -s");
					break;
				case BEDROCK:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " (A) Manual Perm Ban (Indefinite) -s");
					break;
				case DIAMOND:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 7d (A) Xray/Texture Pack -s");
					break;
				case FEATHER:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 14d (A) Fly/Speed -s");
					break;
				case DIAMOND_SWORD:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 30d (A) PVP/Mob Aura -s");
					break;
				case TNT:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 30d (A) Exploiting/Griefing -s");			
					break;
				case STICK:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 7d (A) Racism/Harassment/Sexism/Threats -s");		
					break;
				case COMMAND:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 3d (A) Advertising/Chat/PM/Command Spam -s");		
					break;
				case COAL:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 7d (A) Staff Impersonation/Disrespect -s");		
					break;
				case GLASS:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 3d (A) Inappropriate Skin/Name -s");		
					break;
				case BED:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 1hr (A) Other/Minor Offenses -s");		
					break;		
				default:
					return;
				}
			player.closeInventory();
			 } else {
			     return;
			 }
		} else if (ChatColor.translateAlternateColorCodes('&', e.getClickedInventory()getTitle()).equals(ChatColor.RED + "(M) Ban: " + banUICOmmand.target.getName())) {
			 if(e.getCurrentItem().getType() != null) {
				e.setCancelled(true);
				switch(e.getCurrentItem().getType()) {
				case DIAMOND:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 7d (M) Xray/Texture Pack -s");
					break;
				case FEATHER:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 14d (M) Fly/Speed -s");
					break;
				case DIAMOND_SWORD:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 30d (M) PVP/Mob Aura -s");
					break;
				case TNT:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 30d (M) Exploiting/Griefing -s");			
					break;
				case STICK:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 7d (M) Racism/Harassment/Sexism/Threats -s");		
					break;
				case COMMAND:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 3d (M) Advertising/Chat/PM/Command Spam -s");		
					break;
				case COAL:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 7d (M) Staff Impersonation/Disrespect -s");		
					break;
				case GLASS:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 3d (M) Inappropriate Skin/Name -s");		
					break;
				case BED:
					player.performCommand("litebans:ban " + banUICOmmand.target.getName().toString() + " 1hr (M) Other/Minor Offenses -s");		
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
			


