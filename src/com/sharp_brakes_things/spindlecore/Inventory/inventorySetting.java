package com.sharp_brakes_things.spindlecore.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sharp_brakes_things.spindlecore.CoreMain;
import com.sharp_brakes_things.spindlecore.punishmentSystem.ban.banUICOmmand;
import com.sharp_brakes_things.spindlecore.staffUI.staffUICommand;

public class inventorySetting {
    public static CoreMain plugin;
    public inventorySetting(CoreMain instance){
        plugin = instance;
    }
    FileConfiguration config = CoreMain.plugin.getConfig();
    String prefix = config.getString("Prefix");
    String noPerms = config.getString("NoPermissions");
    String playerOnly = config.getString("PlayerOnly");
    
	
	//Staff UI//
    public static void applyStaffUI(Player player) {
    	
    	
    	//Beginning//
    	Inventory staffUI = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "Staff Member: " + staffUICommand.player.getName());
    	//lore//    	
    	List<String> vanishLore = new ArrayList<>();
    	vanishLore.add(ChatColor.DARK_RED + "CLick to change your visibility to normal players");
    	vanishLore.add(ChatColor.DARK_RED + "Command: /sv");
    	
    	List<String> xrayChestsLore = new ArrayList<>();
    	xrayChestsLore.add(ChatColor.DARK_RED + "Gives the player 4 single chests (2 Double)");
    	//Item stacks//
    	ItemStack vanish = new ItemStack(Material.GLASS);
    	ItemMeta vanishMeta = vanish.getItemMeta();
    	vanishMeta.setDisplayName(ChatColor.DARK_RED + "Vanish");
    	vanishMeta.setLore(vanishLore);
    	vanish.setItemMeta(vanishMeta);
    	
    	ItemStack xrayChests = new ItemStack(Material.CHEST);
    	ItemMeta xrayChestsMeta = xrayChests.getItemMeta();
    	xrayChestsMeta.setDisplayName(ChatColor.DARK_RED + "Chests for Xrayers");
    	xrayChestsMeta.setLore(xrayChestsLore);
    	xrayChests.setItemMeta(xrayChestsMeta);
    	
    	staffUI.setItem(3, vanish);
    	staffUI.setItem(5, xrayChests);
    	
    	player.openInventory(staffUI);
    }
    //Ban UI//
    //ONLINE//
    //Mod Ban UI//
    public static void applyBanUI(Player player) {
    	
    	
    	//Beginning//
    	Inventory banUI = Bukkit.createInventory(null, 9, ChatColor.RED + "(M) Ban: " + banUICOmmand.target.getName());
    	
    	//lore//    	
    	List<String> xrayLore = new ArrayList<>();
    	xrayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	xrayLore.add(ChatColor.DARK_RED + "Reason: (M) Xray/Texture Pack");
    	xrayLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> flyLore = new ArrayList<>();
    	flyLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	flyLore.add(ChatColor.DARK_RED + "Reason: (M) Fly/Speed");
    	flyLore.add(ChatColor.DARK_RED + "Time: 14 Day(s)");
    	
    	List<String> pvpLore = new ArrayList<>();
    	pvpLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	pvpLore.add(ChatColor.DARK_RED + "Reason: (M) PVP/Mob Aura");
    	pvpLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> exploitingGriefingLore = new ArrayList<>();
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Reason: (M) Exploiting/Griefing");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> rudenessLore = new ArrayList<>();
    	rudenessLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	rudenessLore.add(ChatColor.DARK_RED + "Reason: (M) Racism/Harassment/Sexism/Threats");
    	rudenessLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> spamLore = new ArrayList<>();
    	spamLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	spamLore.add(ChatColor.DARK_RED + "Reason: (M) Advertising/Chat/PM/Command Spam");
    	spamLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> staffDisrespectLore = new ArrayList<>();
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Reason: (M) Staff Impersonation/Disrespect");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> InappropriateLore = new ArrayList<>();
    	InappropriateLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	InappropriateLore.add(ChatColor.DARK_RED + "Reason: (M)  Inappropriate Skin/Name");
    	InappropriateLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> otherLore = new ArrayList<>();
    	otherLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	otherLore.add(ChatColor.DARK_RED + "Reason: (M) Other/Minor Offenses");
    	otherLore.add(ChatColor.DARK_RED + "Time: 1 Hour(s)");
    	
    	//Item stacks//
    	ItemStack xray = new ItemStack(Material.DIAMOND);
    	ItemMeta xrayMeta = xray.getItemMeta();
    	xrayMeta.setDisplayName(ChatColor.DARK_RED + "Xray");
    	xrayMeta.setLore(xrayLore);
    	xray.setItemMeta(xrayMeta);
    	
    	ItemStack fly = new ItemStack(Material.FEATHER);
    	ItemMeta flyMeta = fly.getItemMeta();
    	flyMeta.setDisplayName(ChatColor.DARK_RED + "Fly/Speed");
    	flyMeta.setLore(flyLore);
    	fly.setItemMeta(flyMeta);
    	
    	ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta pvpMeta = pvp.getItemMeta();
    	pvpMeta.setDisplayName(ChatColor.DARK_RED + "PVP/Mob Aura");
    	pvpMeta.setLore(pvpLore);
    	pvp.setItemMeta(pvpMeta);
    	
    	ItemStack exploitingGriefing = new ItemStack(Material.TNT);
    	ItemMeta exploitingGriefingMeta = exploitingGriefing.getItemMeta();
    	exploitingGriefingMeta.setDisplayName(ChatColor.DARK_RED + "Exploiting/Griefing");
    	exploitingGriefingMeta.setLore(exploitingGriefingLore);
    	exploitingGriefing.setItemMeta(exploitingGriefingMeta);
    	
    	ItemStack spam = new ItemStack(Material.COMMAND_BLOCK);
    	ItemMeta spamMeta = spam.getItemMeta();
    	spamMeta.setDisplayName(ChatColor.DARK_RED + "Advertising/Chat/PM/Command Spam");
    	spamMeta.setLore(spamLore);
    	spam.setItemMeta(spamMeta);
    	
    	ItemStack rudeness = new ItemStack(Material.STICK);
    	ItemMeta rudenessMeta = rudeness.getItemMeta();
    	rudenessMeta.setDisplayName(ChatColor.DARK_RED + "Racism/Harassment/Sexism/Threats");
    	rudenessMeta.setLore(rudenessLore);
    	rudeness.setItemMeta(rudenessMeta);
    	
    	ItemStack staffDisrespect = new ItemStack(Material.COAL);
    	ItemMeta staffDisrespectMeta = staffDisrespect.getItemMeta();
    	staffDisrespectMeta.setDisplayName(ChatColor.DARK_RED + "Staff Impersonation/Disrespect");
    	staffDisrespectMeta.setLore(staffDisrespectLore);
    	staffDisrespect.setItemMeta(staffDisrespectMeta);
    	
    	ItemStack inappropriate = new ItemStack(Material.GLASS);
    	ItemMeta inappropriateMeta = inappropriate.getItemMeta();
    	inappropriateMeta.setDisplayName(ChatColor.DARK_RED + "Inappropriate Skin/Name");
    	inappropriateMeta.setLore(InappropriateLore);
    	inappropriate.setItemMeta(inappropriateMeta);
    	
    	ItemStack other = new ItemStack(Material.WHITE_BED);
    	ItemMeta otherMeta = other.getItemMeta();
    	otherMeta.setDisplayName(ChatColor.DARK_RED + "Other/Minor Offenses");
    	otherMeta.setLore(otherLore);
    	other.setItemMeta(otherMeta);
    	
    	//Item setting//
    	banUI.setItem(0, xray);
    	banUI.setItem(1, fly);
    	banUI.setItem(2, pvp);
    	banUI.setItem(3, exploitingGriefing);
    	banUI.setItem(4, spam);
    	banUI.setItem(5, rudeness);
    	banUI.setItem(6, staffDisrespect);
    	banUI.setItem(7, inappropriate);
    	banUI.setItem(8, other);
    	//Final//
    	player.openInventory(banUI);
    }
    //Admin Ban UI//
    public static void applyaBanUI(Player player) {

    	
    	//Begininning//
    	Inventory aBanUI = Bukkit.createInventory(null, 18, ChatColor.RED + "(A) Ban: " + banUICOmmand.target.getName());
    	
    	//lore//
    	List<String> oneHrLore = new ArrayList<>();
    	oneHrLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	oneHrLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	oneHrLore.add(ChatColor.DARK_RED + "Time: 1 Hour(s)");
    	
    	List<String> sixHrLore = new ArrayList<>();
    	sixHrLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	sixHrLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	sixHrLore.add(ChatColor.DARK_RED + "Time: 6 Hour(s)");
    	
    	List<String> oneDayLore = new ArrayList<>();
    	oneDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	oneDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	oneDayLore.add(ChatColor.DARK_RED + "Time: 1 Day(s)");
    	
    	List<String> threeDayLore = new ArrayList<>();
    	threeDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	threeDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	threeDayLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> fiveDayLore = new ArrayList<>();
    	fiveDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	fiveDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	fiveDayLore.add(ChatColor.DARK_RED + "Time: 5 Day(s)");
    	
    	List<String> tenDayLore = new ArrayList<>();
    	tenDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	tenDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	tenDayLore.add(ChatColor.DARK_RED + "Time: 10 Day(s)");
    	
    	List<String> twentyDayLore = new ArrayList<>();
    	twentyDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	twentyDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	twentyDayLore.add(ChatColor.DARK_RED + "Time: 20 Day(s)");
    	
    	List<String> thirtyDayLore = new ArrayList<>();
    	thirtyDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	thirtyDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	thirtyDayLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> permOLore = new ArrayList<>();
    	permOLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	permOLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Perm Banned (Indefinite)");
    	permOLore.add(ChatColor.DARK_RED + "Time: Indefinite");
    	
    	List<String> xrayLore = new ArrayList<>();
    	xrayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	xrayLore.add(ChatColor.DARK_RED + "Reason: (A) Xray/Texture Pack");
    	xrayLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> flyLore = new ArrayList<>();
    	flyLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	flyLore.add(ChatColor.DARK_RED + "Reason: (A) Fly/Speed");
    	flyLore.add(ChatColor.DARK_RED + "Time: 14 Day(s)");
    	
    	List<String> pvpLore = new ArrayList<>();
    	pvpLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	pvpLore.add(ChatColor.DARK_RED + "Reason: (A) PVP/Mob Aura");
    	pvpLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> exploitingGriefingLore = new ArrayList<>();
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Reason: (A) Exploiting/Griefing");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> rudenessLore = new ArrayList<>();
    	rudenessLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	rudenessLore.add(ChatColor.DARK_RED + "Reason: (A) Racism/Harassment/Sexism/Threats");
    	rudenessLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> spamLore = new ArrayList<>();
    	spamLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	spamLore.add(ChatColor.DARK_RED + "Reason: (A) Advertising/Chat/PM/Command Spam");
    	spamLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> staffDisrespectLore = new ArrayList<>();
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Reason: (A) Staff Impersonation/Disrespect");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> inappropriateLore = new ArrayList<>();
    	inappropriateLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	inappropriateLore.add(ChatColor.DARK_RED + "Reason: (A) Inappropriate Skin/Name");
    	inappropriateLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> otherLore = new ArrayList<>();
    	otherLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	otherLore.add(ChatColor.DARK_RED + "Reason: (A) Other/Minor Offenses");
    	otherLore.add(ChatColor.DARK_RED + "Time: 1 Hour(s)");
    	
    	
    	
    	
    	
    	//Item stacks//
    	ItemStack oneHr = new ItemStack(Material.COAL_ORE);
    	ItemMeta oneHrMeta = oneHr.getItemMeta();
    	oneHrMeta.setDisplayName(ChatColor.DARK_RED + "Manual 1 Hour Ban");
    	oneHrMeta.setLore(oneHrLore);
    	oneHr.setItemMeta(oneHrMeta);
    	
    	ItemStack sixHr = new ItemStack(Material.REDSTONE_ORE);
    	ItemMeta sixHrMeta = sixHr.getItemMeta();
    	sixHrMeta.setDisplayName(ChatColor.DARK_RED + "Manual 6 Hour Ban");
    	sixHrMeta.setLore(sixHrLore);
    	sixHr.setItemMeta(sixHrMeta);
    	
    	ItemStack oneDay = new ItemStack(Material.LAPIS_ORE);
    	ItemMeta oneDayMeta = oneDay.getItemMeta();
    	oneDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 1 Day Ban");
    	oneDayMeta.setLore(oneDayLore);
    	oneDay.setItemMeta(oneDayMeta);
    	
    	ItemStack threeDay = new ItemStack(Material.IRON_ORE);
    	ItemMeta threeDayMeta = threeDay.getItemMeta();
    	threeDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 3 Day Ban");
    	threeDayMeta.setLore(threeDayLore);
    	threeDay.setItemMeta(threeDayMeta);
    	
    	ItemStack fiveDay = new ItemStack(Material.GOLD_ORE);
    	ItemMeta fiveDayMeta = fiveDay.getItemMeta();
    	fiveDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 5 Day Ban");
    	fiveDayMeta.setLore(fiveDayLore);
    	fiveDay.setItemMeta(fiveDayMeta);
    	
    	ItemStack tenDay = new ItemStack(Material.EMERALD_ORE);
    	ItemMeta tenDayMeta = tenDay.getItemMeta();
    	tenDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 10 Day Ban");
    	tenDayMeta.setLore(tenDayLore);
    	tenDay.setItemMeta(tenDayMeta);
    	
    	ItemStack twentyDay = new ItemStack(Material.DIAMOND_ORE);
    	ItemMeta twentyDayMeta = twentyDay.getItemMeta();
    	twentyDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 20 Day Ban");
    	twentyDayMeta.setLore(twentyDayLore);
    	twentyDay.setItemMeta(twentyDayMeta);
    	
    	ItemStack thirtyDay = new ItemStack(Material.OBSIDIAN);
    	ItemMeta thirtyDayMeta = thirtyDay.getItemMeta();
    	thirtyDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 30 Day Ban");
    	thirtyDayMeta.setLore(thirtyDayLore);
    	thirtyDay.setItemMeta(thirtyDayMeta);
    	
    	ItemStack permO = new ItemStack(Material.BEDROCK);
    	ItemMeta permOMeta = permO.getItemMeta();
    	permOMeta.setDisplayName(ChatColor.DARK_RED + "Manual Perm Ban");
    	permOMeta.setLore(permOLore);
    	permO.setItemMeta(permOMeta);
    	
    	ItemStack xray = new ItemStack(Material.DIAMOND);
    	ItemMeta xrayMeta = xray.getItemMeta();
    	xrayMeta.setDisplayName(ChatColor.DARK_RED + "Xray");
    	xrayMeta.setLore(xrayLore);
    	xray.setItemMeta(xrayMeta);
    	
    	ItemStack fly = new ItemStack(Material.FEATHER);
    	ItemMeta flyMeta = fly.getItemMeta();
    	flyMeta.setDisplayName(ChatColor.DARK_RED + "Fly/Speed");
    	flyMeta.setLore(flyLore);
    	fly.setItemMeta(flyMeta);
    	
    	ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta pvpMeta = pvp.getItemMeta();
    	pvpMeta.setDisplayName(ChatColor.DARK_RED + "PVP/Mob Aura");
    	pvpMeta.setLore(pvpLore);
    	pvp.setItemMeta(pvpMeta);
    	
    	ItemStack exploitingGriefing = new ItemStack(Material.TNT);
    	ItemMeta exploitingGriefingMeta = exploitingGriefing.getItemMeta();
    	exploitingGriefingMeta.setDisplayName(ChatColor.DARK_RED + "Exploiting/Griefing");
    	exploitingGriefingMeta.setLore(exploitingGriefingLore);
    	exploitingGriefing.setItemMeta(exploitingGriefingMeta);
    	
    	ItemStack spam = new ItemStack(Material.COMMAND_BLOCK);
    	ItemMeta spamMeta = spam.getItemMeta();
    	spamMeta.setDisplayName(ChatColor.DARK_RED + "Advertising/Chat/PM/Command Spam");
    	spamMeta.setLore(spamLore);
    	spam.setItemMeta(spamMeta);
    	
    	ItemStack rudeness = new ItemStack(Material.STICK);
    	ItemMeta rudenessMeta = rudeness.getItemMeta();
    	rudenessMeta.setDisplayName(ChatColor.DARK_RED + "Racism/Harassment/Sexism/Threats");
    	rudenessMeta.setLore(rudenessLore);
    	rudeness.setItemMeta(rudenessMeta);
    	
    	ItemStack staffDisrespect = new ItemStack(Material.COAL);
    	ItemMeta staffDisrespectMeta = staffDisrespect.getItemMeta();
    	staffDisrespectMeta.setDisplayName(ChatColor.DARK_RED + "Staff Impersonation/Disrespect");
    	staffDisrespectMeta.setLore(staffDisrespectLore);
    	staffDisrespect.setItemMeta(staffDisrespectMeta);
    	
    	ItemStack inappropriate  = new ItemStack(Material.GLASS);
    	ItemMeta inappropriateMeta = inappropriate.getItemMeta();
    	inappropriateMeta.setDisplayName(ChatColor.DARK_RED + "Inappropriate Skin/Name");
    	inappropriateMeta.setLore(inappropriateLore);
    	inappropriate.setItemMeta(inappropriateMeta);
    	
    	ItemStack other = new ItemStack(Material.WHITE_BED);
    	ItemMeta otherMeta = other.getItemMeta();
    	otherMeta.setDisplayName(ChatColor.DARK_RED + "Other/Minor Offenses");
    	otherMeta.setLore(otherLore);
    	other.setItemMeta(otherMeta);
    	
    	//Item setting//
    	aBanUI.setItem(0, xray);
    	aBanUI.setItem(1, fly);
    	aBanUI.setItem(2, pvp);
    	aBanUI.setItem(3, exploitingGriefing);
    	aBanUI.setItem(4, spam);
    	aBanUI.setItem(5, rudeness);
    	aBanUI.setItem(6, staffDisrespect);
    	aBanUI.setItem(7, inappropriate);
    	aBanUI.setItem(8, other);
    	aBanUI.setItem(9, oneHr);
    	aBanUI.setItem(10, sixHr);
    	aBanUI.setItem(11, oneDay);
    	aBanUI.setItem(12, threeDay);
    	aBanUI.setItem(13, fiveDay);
    	aBanUI.setItem(14, tenDay);
    	aBanUI.setItem(15, twentyDay);
    	aBanUI.setItem(16, thirtyDay);
    	aBanUI.setItem(17, permO);
    	//Final//
    	player.openInventory(aBanUI);
    	
    	
    }

    //OFFLINE//
    //Mod Ban UI//
    public static void applyOfflineBanUI(Player player) {
    	
    	
    	//Beginning//
    	Inventory banOfflineUI = Bukkit.createInventory(null, 9, ChatColor.RED + "(M) Ban: " + banUICOmmand.target.getName());
    	
    	//lore//    	
    	//lore//    	
    	List<String> xrayLore = new ArrayList<>();
    	xrayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	xrayLore.add(ChatColor.DARK_RED + "Reason: (M) Xray/Texture Pack");
    	xrayLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> flyLore = new ArrayList<>();
    	flyLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	flyLore.add(ChatColor.DARK_RED + "Reason: (M) Fly/Speed");
    	flyLore.add(ChatColor.DARK_RED + "Time: 14 Day(s)");
    	
    	List<String> pvpLore = new ArrayList<>();
    	pvpLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	pvpLore.add(ChatColor.DARK_RED + "Reason: (M) PVP/Mob Aura");
    	pvpLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> exploitingGriefingLore = new ArrayList<>();
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Reason: (M) Exploiting/Griefing");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> rudenessLore = new ArrayList<>();
    	rudenessLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	rudenessLore.add(ChatColor.DARK_RED + "Reason: (M) Racism/Harassment/Sexism/Threats");
    	rudenessLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> spamLore = new ArrayList<>();
    	spamLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	spamLore.add(ChatColor.DARK_RED + "Reason: (M) Advertising/Chat/PM/Command Spam");
    	spamLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> staffDisrespectLore = new ArrayList<>();
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Reason: (M) Staff Impersonation/Disrespect");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> InappropriateLore = new ArrayList<>();
    	InappropriateLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	InappropriateLore.add(ChatColor.DARK_RED + "Reason: (M)  Inappropriate Skin/Name");
    	InappropriateLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> otherLore = new ArrayList<>();
    	otherLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	otherLore.add(ChatColor.DARK_RED + "Reason: (M) Other/Minor Offenses");
    	otherLore.add(ChatColor.DARK_RED + "Time: 1 Hour(s)");
    	
    	//Item stacks//
    	ItemStack xray = new ItemStack(Material.DIAMOND);
    	ItemMeta xrayMeta = xray.getItemMeta();
    	xrayMeta.setDisplayName(ChatColor.DARK_RED + "Xray");
    	xrayMeta.setLore(xrayLore);
    	xray.setItemMeta(xrayMeta);
    	
    	ItemStack fly = new ItemStack(Material.FEATHER);
    	ItemMeta flyMeta = fly.getItemMeta();
    	flyMeta.setDisplayName(ChatColor.DARK_RED + "Fly/Speed");
    	flyMeta.setLore(flyLore);
    	fly.setItemMeta(flyMeta);
    	
    	ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta pvpMeta = pvp.getItemMeta();
    	pvpMeta.setDisplayName(ChatColor.DARK_RED + "PVP/Mob Aura");
    	pvpMeta.setLore(pvpLore);
    	pvp.setItemMeta(pvpMeta);
    	
    	ItemStack exploitingGriefing = new ItemStack(Material.TNT);
    	ItemMeta exploitingGriefingMeta = exploitingGriefing.getItemMeta();
    	exploitingGriefingMeta.setDisplayName(ChatColor.DARK_RED + "Exploiting/Griefing");
    	exploitingGriefingMeta.setLore(exploitingGriefingLore);
    	exploitingGriefing.setItemMeta(exploitingGriefingMeta);
    	
    	ItemStack spam = new ItemStack(Material.COMMAND_BLOCK);
    	ItemMeta spamMeta = spam.getItemMeta();
    	spamMeta.setDisplayName(ChatColor.DARK_RED + "Advertising/Chat/PM/Command Spam");
    	spamMeta.setLore(spamLore);
    	spam.setItemMeta(spamMeta);
    	
    	ItemStack rudeness = new ItemStack(Material.STICK);
    	ItemMeta rudenessMeta = rudeness.getItemMeta();
    	rudenessMeta.setDisplayName(ChatColor.DARK_RED + "Racism/Harassment/Sexism/Threats");
    	rudenessMeta.setLore(rudenessLore);
    	rudeness.setItemMeta(rudenessMeta);
    	
    	ItemStack staffDisrespect = new ItemStack(Material.COAL);
    	ItemMeta staffDisrespectMeta = staffDisrespect.getItemMeta();
    	staffDisrespectMeta.setDisplayName(ChatColor.DARK_RED + "Staff Impersonation/Disrespect");
    	staffDisrespectMeta.setLore(staffDisrespectLore);
    	staffDisrespect.setItemMeta(staffDisrespectMeta);
    	
    	ItemStack inappropriate = new ItemStack(Material.GLASS);
    	ItemMeta inappropriateMeta = inappropriate.getItemMeta();
    	inappropriateMeta.setDisplayName(ChatColor.DARK_RED + "Inappropriate Skin/Name");
    	inappropriateMeta.setLore(InappropriateLore);
    	inappropriate.setItemMeta(inappropriateMeta);
    	
    	ItemStack other = new ItemStack(Material.WHITE_BED);
    	ItemMeta otherMeta = other.getItemMeta();
    	otherMeta.setDisplayName(ChatColor.DARK_RED + "Other/Minor Offenses");
    	otherMeta.setLore(otherLore);
    	other.setItemMeta(otherMeta);
    	
    	//Item setting//
    	banOfflineUI.setItem(0, xray);
    	banOfflineUI.setItem(1, fly);
    	banOfflineUI.setItem(2, pvp);
    	banOfflineUI.setItem(3, exploitingGriefing);
    	banOfflineUI.setItem(4, spam);
    	banOfflineUI.setItem(5, rudeness);
    	banOfflineUI.setItem(6, staffDisrespect);
    	banOfflineUI.setItem(7, inappropriate);
    	banOfflineUI.setItem(8, other);
    	//Final//
    	player.openInventory(banOfflineUI);
    }
    //Admin Ban UI//
    public static void applyOfflineaBanUI(Player player) {


    	
    	//Begininning//
    	Inventory aOfflineBanUI = Bukkit.createInventory(null, 18, ChatColor.RED + "(A) Ban: " + banUICOmmand.target.getName());
    	
    	//lore//
    	List<String> oneHrLore = new ArrayList<>();
    	oneHrLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	oneHrLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	oneHrLore.add(ChatColor.DARK_RED + "Time: 1 Hour(s)");
    	
    	List<String> sixHrLore = new ArrayList<>();
    	sixHrLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	sixHrLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	sixHrLore.add(ChatColor.DARK_RED + "Time: 6 Hour(s)");
    	
    	List<String> oneDayLore = new ArrayList<>();
    	oneDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	oneDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	oneDayLore.add(ChatColor.DARK_RED + "Time: 1 Day(s)");
    	
    	List<String> threeDayLore = new ArrayList<>();
    	threeDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	threeDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	threeDayLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> fiveDayLore = new ArrayList<>();
    	fiveDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	fiveDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	fiveDayLore.add(ChatColor.DARK_RED + "Time: 5 Day(s)");
    	
    	List<String> tenDayLore = new ArrayList<>();
    	tenDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	tenDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	tenDayLore.add(ChatColor.DARK_RED + "Time: 10 Day(s)");
    	
    	List<String> twentyDayLore = new ArrayList<>();
    	twentyDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	twentyDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	twentyDayLore.add(ChatColor.DARK_RED + "Time: 20 Day(s)");
    	
    	List<String> thirtyDayLore = new ArrayList<>();
    	thirtyDayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	thirtyDayLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Temporarily Banned");
    	thirtyDayLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> permOLore = new ArrayList<>();
    	permOLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	permOLore.add(ChatColor.DARK_RED + "Reason: (A) Manually Perm Banned (Indefinite)");
    	permOLore.add(ChatColor.DARK_RED + "Time: Indefinite");
    	
    	List<String> xrayLore = new ArrayList<>();
    	xrayLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	xrayLore.add(ChatColor.DARK_RED + "Reason: (A) Xray/Texture Pack");
    	xrayLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> flyLore = new ArrayList<>();
    	flyLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	flyLore.add(ChatColor.DARK_RED + "Reason: (A) Fly/Speed");
    	flyLore.add(ChatColor.DARK_RED + "Time: 14 Day(s)");
    	
    	List<String> pvpLore = new ArrayList<>();
    	pvpLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	pvpLore.add(ChatColor.DARK_RED + "Reason: (A) PVP/Mob Aura");
    	pvpLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> exploitingGriefingLore = new ArrayList<>();
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Reason: (A) Exploiting/Griefing");
    	exploitingGriefingLore.add(ChatColor.DARK_RED + "Time: 30 Day(s)");
    	
    	List<String> rudenessLore = new ArrayList<>();
    	rudenessLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	rudenessLore.add(ChatColor.DARK_RED + "Reason: (A) Racism/Harassment/Sexism/Threats");
    	rudenessLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> spamLore = new ArrayList<>();
    	spamLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	spamLore.add(ChatColor.DARK_RED + "Reason: (A) Advertising/Chat/PM/Command Spam");
    	spamLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> staffDisrespectLore = new ArrayList<>();
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Reason: (A) Staff Impersonation/Disrespect");
    	staffDisrespectLore.add(ChatColor.DARK_RED + "Time: 7 Day(s)");
    	
    	List<String> inappropriateLore = new ArrayList<>();
    	inappropriateLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	inappropriateLore.add(ChatColor.DARK_RED + "Reason: (A) Inappropriate Skin/Name");
    	inappropriateLore.add(ChatColor.DARK_RED + "Time: 3 Day(s)");
    	
    	List<String> otherLore = new ArrayList<>();
    	otherLore.add(ChatColor.DARK_RED + "Bans '" + banUICOmmand.target.getName().toString() + "' for:");
    	otherLore.add(ChatColor.DARK_RED + "Reason: (A) Other/Minor Offenses");
    	otherLore.add(ChatColor.DARK_RED + "Time: 1 Hour(s)");
    	
    	
    	
    	
    	
    	//Item stacks//
    	ItemStack oneHr = new ItemStack(Material.COAL_ORE);
    	ItemMeta oneHrMeta = oneHr.getItemMeta();
    	oneHrMeta.setDisplayName(ChatColor.DARK_RED + "Manual 1 Hour Ban");
    	oneHrMeta.setLore(oneHrLore);
    	oneHr.setItemMeta(oneHrMeta);
    	
    	ItemStack sixHr = new ItemStack(Material.REDSTONE_ORE);
    	ItemMeta sixHrMeta = sixHr.getItemMeta();
    	sixHrMeta.setDisplayName(ChatColor.DARK_RED + "Manual 6 Hour Ban");
    	sixHrMeta.setLore(sixHrLore);
    	sixHr.setItemMeta(sixHrMeta);
    	
    	ItemStack oneDay = new ItemStack(Material.LAPIS_ORE);
    	ItemMeta oneDayMeta = oneDay.getItemMeta();
    	oneDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 1 Day Ban");
    	oneDayMeta.setLore(oneDayLore);
    	oneDay.setItemMeta(oneDayMeta);
    	
    	ItemStack threeDay = new ItemStack(Material.IRON_ORE);
    	ItemMeta threeDayMeta = threeDay.getItemMeta();
    	threeDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 3 Day Ban");
    	threeDayMeta.setLore(threeDayLore);
    	threeDay.setItemMeta(threeDayMeta);
    	
    	ItemStack fiveDay = new ItemStack(Material.GOLD_ORE);
    	ItemMeta fiveDayMeta = fiveDay.getItemMeta();
    	fiveDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 5 Day Ban");
    	fiveDayMeta.setLore(fiveDayLore);
    	fiveDay.setItemMeta(fiveDayMeta);
    	
    	ItemStack tenDay = new ItemStack(Material.EMERALD_ORE);
    	ItemMeta tenDayMeta = tenDay.getItemMeta();
    	tenDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 10 Day Ban");
    	tenDayMeta.setLore(tenDayLore);
    	tenDay.setItemMeta(tenDayMeta);
    	
    	ItemStack twentyDay = new ItemStack(Material.DIAMOND_ORE);
    	ItemMeta twentyDayMeta = twentyDay.getItemMeta();
    	twentyDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 20 Day Ban");
    	twentyDayMeta.setLore(twentyDayLore);
    	twentyDay.setItemMeta(twentyDayMeta);
    	
    	ItemStack thirtyDay = new ItemStack(Material.OBSIDIAN);
    	ItemMeta thirtyDayMeta = thirtyDay.getItemMeta();
    	thirtyDayMeta.setDisplayName(ChatColor.DARK_RED + "Manual 30 Day Ban");
    	thirtyDayMeta.setLore(thirtyDayLore);
    	thirtyDay.setItemMeta(thirtyDayMeta);
    	
    	ItemStack permO = new ItemStack(Material.BEDROCK);
    	ItemMeta permOMeta = permO.getItemMeta();
    	permOMeta.setDisplayName(ChatColor.DARK_RED + "Manual Perm Ban");
    	permOMeta.setLore(permOLore);
    	permO.setItemMeta(permOMeta);
    	
    	ItemStack xray = new ItemStack(Material.DIAMOND);
    	ItemMeta xrayMeta = xray.getItemMeta();
    	xrayMeta.setDisplayName(ChatColor.DARK_RED + "Xray");
    	xrayMeta.setLore(xrayLore);
    	xray.setItemMeta(xrayMeta);
    	
    	ItemStack fly = new ItemStack(Material.FEATHER);
    	ItemMeta flyMeta = fly.getItemMeta();
    	flyMeta.setDisplayName(ChatColor.DARK_RED + "Fly/Speed");
    	flyMeta.setLore(flyLore);
    	fly.setItemMeta(flyMeta);
    	
    	ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
    	ItemMeta pvpMeta = pvp.getItemMeta();
    	pvpMeta.setDisplayName(ChatColor.DARK_RED + "PVP/Mob Aura");
    	pvpMeta.setLore(pvpLore);
    	pvp.setItemMeta(pvpMeta);
    	
    	ItemStack exploitingGriefing = new ItemStack(Material.TNT);
    	ItemMeta exploitingGriefingMeta = exploitingGriefing.getItemMeta();
    	exploitingGriefingMeta.setDisplayName(ChatColor.DARK_RED + "Exploiting/Griefing");
    	exploitingGriefingMeta.setLore(exploitingGriefingLore);
    	exploitingGriefing.setItemMeta(exploitingGriefingMeta);
    	
    	ItemStack spam = new ItemStack(Material.COMMAND_BLOCK);
    	ItemMeta spamMeta = spam.getItemMeta();
    	spamMeta.setDisplayName(ChatColor.DARK_RED + "Advertising/Chat/PM/Command Spam");
    	spamMeta.setLore(spamLore);
    	spam.setItemMeta(spamMeta);
    	
    	ItemStack rudeness = new ItemStack(Material.STICK);
    	ItemMeta rudenessMeta = rudeness.getItemMeta();
    	rudenessMeta.setDisplayName(ChatColor.DARK_RED + "Racism/Harassment/Sexism/Threats");
    	rudenessMeta.setLore(rudenessLore);
    	rudeness.setItemMeta(rudenessMeta);
    	
    	ItemStack staffDisrespect = new ItemStack(Material.COAL);
    	ItemMeta staffDisrespectMeta = staffDisrespect.getItemMeta();
    	staffDisrespectMeta.setDisplayName(ChatColor.DARK_RED + "Staff Impersonation/Disrespect");
    	staffDisrespectMeta.setLore(staffDisrespectLore);
    	staffDisrespect.setItemMeta(staffDisrespectMeta);
    	
    	ItemStack inappropriate  = new ItemStack(Material.GLASS);
    	ItemMeta inappropriateMeta = inappropriate.getItemMeta();
    	inappropriateMeta.setDisplayName(ChatColor.DARK_RED + "Inappropriate Skin/Name");
    	inappropriateMeta.setLore(inappropriateLore);
    	inappropriate.setItemMeta(inappropriateMeta);
    	
    	ItemStack other = new ItemStack(Material.WHITE_BED);
    	ItemMeta otherMeta = other.getItemMeta();
    	otherMeta.setDisplayName(ChatColor.DARK_RED + "Other/Minor Offenses");
    	otherMeta.setLore(otherLore);
    	other.setItemMeta(otherMeta);
    	
    	//Item setting//
    	aOfflineBanUI.setItem(0, xray);
    	aOfflineBanUI.setItem(1, fly);
    	aOfflineBanUI.setItem(2, pvp);
    	aOfflineBanUI.setItem(3, exploitingGriefing);
    	aOfflineBanUI.setItem(4, spam);
    	aOfflineBanUI.setItem(5, rudeness);
    	aOfflineBanUI.setItem(6, staffDisrespect);
    	aOfflineBanUI.setItem(7, inappropriate);
    	aOfflineBanUI.setItem(8, other);
    	aOfflineBanUI.setItem(9, oneHr);
    	aOfflineBanUI.setItem(10, sixHr);
    	aOfflineBanUI.setItem(11, oneDay);
    	aOfflineBanUI.setItem(12, threeDay);
    	aOfflineBanUI.setItem(13, fiveDay);
    	aOfflineBanUI.setItem(14, tenDay);
    	aOfflineBanUI.setItem(15, twentyDay);
    	aOfflineBanUI.setItem(16, thirtyDay);
    	aOfflineBanUI.setItem(17, permO);
    	//Final//
    	player.openInventory(aOfflineBanUI);
    	
    	
    }
    //Elytra//
    public static HashMap<Player, Material> elytraChestSlot = new HashMap<>();
    
    // Player UI //
    public static void applyPOptionUI(Player player) {
    	
    	//Begginning//
    	Inventory pOptionUI = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Player Option Menu");
    	
    	//Lore//
    	List<String> enableElytraLore = new ArrayList<>();
    	enableElytraLore.add(ChatColor.GREEN + "Click the Elytra to");
    	enableElytraLore.add(ChatColor.GREEN + "Enable your Elytra.");
    	
    	List<String> disableElytraLore = new ArrayList<>();
    	disableElytraLore.add(ChatColor.RED + "Click the Elytra to");
    	disableElytraLore.add(ChatColor.RED + "disable your Elytra.");
    	
    	List<String> spawnTPLore = new ArrayList<>();
    	spawnTPLore.add(ChatColor.GREEN + "Click to teleport to spawn");
    	
    	//Item Stacks//
    	ItemStack elytraToggle;
    	ItemMeta elytraToggleMeta;
    	
    	if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {
    	
    		elytraToggle = new ItemStack(Material.REDSTONE_BLOCK);
    		elytraToggleMeta = elytraToggle.getItemMeta();
    		elytraToggleMeta.setDisplayName(ChatColor.RED + "Disable Elyta");
    		elytraToggleMeta.setLore(disableElytraLore);
    		
    		
    	} else {
    		
    		elytraToggle  = new ItemStack(Material.ELYTRA);
    		elytraToggleMeta = elytraToggle.getItemMeta();
    		elytraToggleMeta.setDisplayName(ChatColor.GREEN + "Enable Elyta");
    		elytraToggleMeta.setLore(enableElytraLore);
    		
    	}
    	elytraToggle.setItemMeta(elytraToggleMeta);
    	
    	ItemStack spawnTP = new ItemStack(Material.MAP);
    	ItemMeta spawnTPMeta = spawnTP.getItemMeta();
    	spawnTPMeta.setDisplayName(ChatColor.GREEN + "Teleport to spawn");
    	spawnTPMeta.setLore(spawnTPLore);
    	spawnTP.setItemMeta(spawnTPMeta);
    	//Item Setting//
    	pOptionUI.setItem(3, spawnTP);
    	pOptionUI.setItem(5, elytraToggle);
    	
    	//Final//
    	
    	player.openInventory(pOptionUI);
    	
    	
  
    	
    }
    

}
