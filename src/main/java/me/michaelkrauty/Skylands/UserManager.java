package me.michaelkrauty.Skylands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class UserManager {

	private final Main main;
	private static HashMap<Player, User> users;

	public UserManager(Main main) {
		this.main = main;
		users = new HashMap<Player, User>();
	}

	public void loadOnlineUsers() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!users.containsKey(player))
				users.put(player, new User(player));
		}
	}

	public void unloadOnlineUsers() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (users.containsKey(player))
				users.get(player).savePlayerData();
			users.clear();
		}
	}

	public User getUser(Player player) {
		if (users.get(player) != null)
			return users.get(player);
		else {
			users.put(player, new User(player));
			return getUser(player);
		}
	}

	public HashMap<Player, User> getAllUsers() {
		return users;
	}

	public void playerQuit(Player player) {
		getUser(player).savePlayerData();
		users.remove(player);
	}
}
