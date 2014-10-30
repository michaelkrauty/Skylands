package me.michaelkrauty.Skylands;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class PlayerListener implements Listener {

	private final Main main;

	public PlayerListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		User user = main.getUserManager().getUser(player);

		if (user.getRank() == null)
			user.setRank("default");

		if (user.getRank().equals("staff"))
			player.setPlayerListName("§2" + player.getDisplayName());
		else if (user.getRank().equals("donator"))
			player.setPlayerListName("§6" + player.getDisplayName());
		else if (user.getRank().equals("default"))
			player.setPlayerListName("§b" + player.getDisplayName());
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		main.getUserManager().playerQuit(event.getPlayer());
	}
}
