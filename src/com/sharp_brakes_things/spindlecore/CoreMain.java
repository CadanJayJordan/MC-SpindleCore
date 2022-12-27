package com.sharp_brakes_things.spindlecore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.sharp_brakes_things.spindlecore.CommandSpy.commandListener;
import com.sharp_brakes_things.spindlecore.CommandSpy.cscommand;
import com.sharp_brakes_things.spindlecore.MessageSpy.messageListener;
import com.sharp_brakes_things.spindlecore.MessageSpy.ssCommand;
import com.sharp_brakes_things.spindlecore.PlayerOptionUI.pOptionUICommand;
import com.sharp_brakes_things.spindlecore.PlayerOptionUI.pOptionUICommandDisconnectListener;
import com.sharp_brakes_things.spindlecore.PlayerOptionUI.pOptionUICommandMenuListener;
import com.sharp_brakes_things.spindlecore.punishmentSystem.ban.banUICOmmand;
import com.sharp_brakes_things.spindlecore.punishmentSystem.ban.banUICOmmandMenuListener;
import com.sharp_brakes_things.spindlecore.punishmentSystem.kick.kickCommand;
import com.sharp_brakes_things.spindlecore.punishmentSystem.unban.unbanCommand;
import com.sharp_brakes_things.spindlecore.staffUI.staffUICommand;
import com.sharp_brakes_things.spindlecore.staffUI.staffUICommandMenuListner;

public class CoreMain extends JavaPlugin {
	public static CoreMain plugin;
	@Override
    public void onEnable() {
		getServer().getLogger().info("[" + this.getDescription().getName() +  " v" + this.getDescription().getVersion() + "] Plugin has loaded successfully");
		//Config//
		plugin = this;
		this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        //CommandSpy//
        Bukkit.getPluginManager().registerEvents(new commandListener(this), this);
        getCommand("cs").setExecutor(new cscommand(this));
        //SocialSpy//
        Bukkit.getPluginManager().registerEvents(new messageListener(this), this);
        getCommand("ss").setExecutor(new ssCommand(this));
        //Ban System//
        getCommand("kick").setExecutor(new kickCommand(this));
        getCommand("unban").setExecutor(new unbanCommand(this));
        getCommand("ban").setExecutor(new banUICOmmand(this));
        Bukkit.getPluginManager().registerEvents(new banUICOmmandMenuListener(this), this);
        //Player Option UI//
        getCommand("options").setExecutor(new pOptionUICommand(this));
        Bukkit.getPluginManager().registerEvents(new pOptionUICommandMenuListener(this), this);
        Bukkit.getPluginManager().registerEvents(new pOptionUICommandDisconnectListener(this), this);
        //Staff UI//
        getCommand("staff").setExecutor(new staffUICommand(this));
        Bukkit.getPluginManager().registerEvents(new staffUICommandMenuListner(this), this);
    }
    @Override
    public void onDisable() {
        getServer().getLogger().info("[" + this.getDescription().getName() + " v" + this.getDescription().getVersion() + "] Plugin has unloaded successfully");
    }
}