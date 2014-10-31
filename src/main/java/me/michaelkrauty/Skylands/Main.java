package me.michaelkrauty.Skylands;

import me.michaelkrauty.Skylands.command.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class Main extends JavaPlugin {

	public static Main main;
	private final UserManager userManager = new UserManager(this);
	private File userFolder;

	public void onEnable() {
		main = this;
		userFolder = new File(getDataFolder(), "userdata");
		if (!getDataFolder().exists())
			getDataFolder().mkdir();
		if (!userFolder.exists())
			userFolder.mkdir();
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
		registerCommands();
		userManager.loadOnlineUsers();
	}

	private void registerCommands() {
		getServer().getPluginCommand("sudosay").setExecutor(new SudoSay());
		getServer().getPluginCommand("staffadd").setExecutor(new StaffAdd());
		getServer().getPluginCommand("donatoradd").setExecutor(new DonatorAdd());
		getServer().getPluginCommand("donatoradd").setExecutor(new DonatorAdd());
		getServer().getPluginCommand("staffremove").setExecutor(new StaffRemove());
		getServer().getPluginCommand("donatorremove").setExecutor(new DonatorRemove());
		getServer().getPluginCommand("callhacks").setExecutor(new CallHacks());
		getServer().getPluginCommand("cc").setExecutor(new CC());
		getServer().getPluginCommand("staff").setExecutor(new Staff());
		getServer().getPluginCommand("staffasks").setExecutor(new StaffAsks());
		getServer().getPluginCommand("staffasks-reset").setExecutor(new StaffAsksReset());
		getServer().getPluginCommand("staff-add").setExecutor(new StaffAdd2());
		getServer().getPluginCommand("staff-remove").setExecutor(new StaffRemove2());
	}

	public void onDisable() {
		userManager.unloadOnlineUsers();
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public File getUserFolder() {
		return userFolder;
	}
}
