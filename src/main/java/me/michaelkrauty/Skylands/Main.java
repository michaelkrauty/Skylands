package me.michaelkrauty.Skylands;

import me.michaelkrauty.Skylands.command.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					User u = userManager.getUser(p);
					if (u.getEffect() != null) {
						if (u.getEffect().equals("smoking")) {
							ParticleEffect.LARGE_SMOKE.display(p.getLocation(), 3, 0, 0, 0, 1, 5);
						}
						if (u.getEffect().equals("flaming")) {
							ParticleEffect.FLAME.display(p.getLocation(), 3, 0, 0, 0, 1, 10);
						}
						if (u.getEffect().equals("redstoning")) {
							ParticleEffect.RED_DUST.display(p.getLocation(), 3, 0, 0, 0, 1, 100);
						}
						if (u.getEffect().equals("lavaing")) {
							ParticleEffect.DRIP_LAVA.display(p.getLocation(), 3, 0, 0, 0, 1, 100);
						}
						if (u.getEffect().equals("splashing")) {
							ParticleEffect.SPLASH.display(p.getLocation(), 3, 0, 0, 0, 1, 100);
						}
					}
				}
			}
		}, 5, 5);
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
		getServer().getPluginCommand("effectsudo").setExecutor(new EffectSudo());
		getServer().getPluginCommand("effects").setExecutor(new Effects());
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
