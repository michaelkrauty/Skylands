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
public class SudoSay implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			Player target;
			if ((target = Bukkit.getPlayer(args[0])) != null) {
				String message = "";
				for (int i = 1; i < args.length; i++) {
					message += args[i] + " ";
				}
				target.chat(message.trim());
			}
		}
		return true;
	}
}
