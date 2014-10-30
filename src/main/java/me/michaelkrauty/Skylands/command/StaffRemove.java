package me.michaelkrauty.Skylands.command;

import me.michaelkrauty.Skylands.Main;
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
public class StaffRemove implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			Player target;
			if ((target = Bukkit.getPlayer(args[0])) != null) {
				Main.main.getUserManager().getUser(target).setRank("default");
				sender.sendMessage("§aRemoved " + target.getName() + " from staff!");
			}
		}
		return true;
	}
}