package me.michaelkrauty.Skylands.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class CallHacks implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			Player target;
			if ((target = Bukkit.getPlayer(args[0])) != null) {
				Bukkit.broadcastMessage("§d§1HACKS HAVE BEEN CALLED! :O §b§1" + sender.getName() + " is accusing " + target.getName() + " of hacking!");
			}
		}
		return true;
	}
}
