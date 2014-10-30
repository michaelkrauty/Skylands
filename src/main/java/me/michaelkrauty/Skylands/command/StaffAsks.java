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
public class StaffAsks implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			Player target;
			if ((target = Bukkit.getPlayer(args[0])) != null) {
				User targetUser = Main.main.getUserManager().getUser(target);
				sender.sendMessage("§2§1" + target.getName() + " has asked for staff " + targetUser.getStaffAsks() + " times!");
			}
		}
		return true;
	}
}
