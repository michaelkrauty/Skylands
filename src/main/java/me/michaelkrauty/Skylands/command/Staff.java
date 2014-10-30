package me.michaelkrauty.Skylands.command;

import me.michaelkrauty.Skylands.Main;
import me.michaelkrauty.Skylands.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created on 10/30/2014.
 *
 * @author michaelkrauty
 */
public class Staff implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args[0] != null) {
			if (args[0].equalsIgnoreCase("list")) {
				String owners = "";
				String admins = "";
				String moderators = "";
				String helpers = "";
				String builders = "";
				sender.sendMessage("§8§l[]-<()>-[] §4§lSkyland §8§l[]-<()>-[]");
				sender.sendMessage("§7§lOwners: §a" + owners);
				sender.sendMessage("§7§lAdmins: §a" + admins);
				sender.sendMessage("§7§lModerators: §a" + moderators);
				sender.sendMessage("§7§lHelpers: §a" + helpers);
				sender.sendMessage("§7§lBuilders: §a" + builders);
			}
			if (args[0].equalsIgnoreCase("me")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					User user = Main.main.getUserManager().getUser(player);
					if (user.getStaffAsks() == -1)
						user.setStaffAsks(1);
					else
						user.setStaffAsks(user.getStaffAsks() + 1);
					player.sendMessage("§2§lOf course not!     Times you asked for staff: " + user.getStaffAsks() + "!");
				}
			}
		}
		return true;
	}
}
