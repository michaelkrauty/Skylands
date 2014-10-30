package me.michaelkrauty.Skylands.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class CC implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		for (int i = 0; i < 150; i++) {
			sender.sendMessage("");
		}
		sender.sendMessage("§2§1Chat Cleared!");
		return true;
	}
}
