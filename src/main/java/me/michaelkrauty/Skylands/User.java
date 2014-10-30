package me.michaelkrauty.Skylands;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class User {

	private final Player player;
	private final File playerFile;
	private final YamlConfiguration playerData;

	public User(Player player) {
		this.player = player;
		this.playerFile = new File(Main.main.getUserFolder(), player.getUniqueId().toString() + ".yml");
		this.playerData = new YamlConfiguration();
		reloadPlayerData();
	}

	public Player getPlayer() {
		return player;
	}

	public YamlConfiguration getPlayerData() {
		return playerData;
	}


	/**
	 * To make life easier
	 */
	public String getRank() {
		return playerData.getString("rank");
	}

	public void setRank(String rank) {
		playerData.set("rank", rank);
	}

	public int getStaffAsks() {
		if (playerData.getString("staffasks") != null)
			return playerData.getInt("staffasks");
		else
			return -1;
	}

	public void setStaffAsks(int asks) {
		playerData.set("staffasks", asks);
	}


	/**
	 * FILE UTIL
	 */
	public void reloadPlayerData() {
		try {
			if (!playerFile.exists())
				playerFile.createNewFile();
			playerData.load(playerFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePlayerData() {
		try {
			if (!playerFile.exists())
				playerFile.createNewFile();
			playerData.save(playerFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
