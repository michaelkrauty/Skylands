package me.michaelkrauty.Skylands.command;

import me.michaelkrauty.Skylands.Main;
import me.michaelkrauty.Skylands.User;
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
public class StaffAdd2 implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			Player target;
			if (args[1] != null) {
				if ((target = Bukkit.getPlayer(args[1])) != null) {
					User targetUser = Main.main.getUserManager().getUser(target);
					if (args[0].equalsIgnoreCase("owner")) {
						targetUser.setRank("owner");
						sender.sendMessage("§a" + target.getName() + " added!");
					} else if (args[0].equalsIgnoreCase("admin")) {
						targetUser.setRank("admin");
						sender.sendMessage("§a" + target.getName() + " added!");
					} else if (args[0].equalsIgnoreCase("mod")) {
						targetUser.setRank("mod");
						sender.sendMessage("§a" + target.getName() + " added!");
					} else if (args[0].equalsIgnoreCase("helper")) {
						targetUser.setRank("helper");
						sender.sendMessage("§a" + target.getName() + " added!");
					} else if (args[0].equalsIgnoreCase("builder")) {
						targetUser.setRank("builder");
						sender.sendMessage("§a" + target.getName() + " added!");
					}
				}
			}
		}
		return true;
	}
}
