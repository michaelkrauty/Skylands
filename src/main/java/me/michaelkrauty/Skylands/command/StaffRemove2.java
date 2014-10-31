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
public class StaffRemove2 implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			Player target;
			if ((target = Bukkit.getPlayer(args[1])) != null) {
				User targetUser = Main.main.getUserManager().getUser(target);
				if (args[0].equalsIgnoreCase("owner")) {
					targetUser.setRank("default");
					sender.sendMessage("§a" + target.getName() + " removed!");
				} else if (args[0].equalsIgnoreCase("admin")) {
					targetUser.setRank("default");
					sender.sendMessage("§a" + target.getName() + " removed!");
				} else if (args[0].equalsIgnoreCase("mod")) {
					targetUser.setRank("default");
					sender.sendMessage("§a" + target.getName() + " removed!");
				} else if (args[0].equalsIgnoreCase("helper")) {
					targetUser.setRank("default");
					sender.sendMessage("§a" + target.getName() + " removed!");
				} else if (args[0].equalsIgnoreCase("builder")) {
					targetUser.setRank("default");
					sender.sendMessage("§a" + target.getName() + " removed!");
				}
			}
		}
		return true;
	}
}
