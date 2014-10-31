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
public class Effects implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender.hasPermission(cmd.getPermission())) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				User user = Main.main.getUserManager().getUser(player);
				if (args != null) {
					String prefix = "§8[§bEffect§8]§4";
					if (args[0].equalsIgnoreCase("enable")) {
						if (args[1].equalsIgnoreCase("smoke")) {
							user.setEffect("smoking");
							player.sendMessage(prefix + " Enabled Smoke Effects!");
						} else if (args[1].equalsIgnoreCase("flame")) {
							user.setEffect("flaming");
							player.sendMessage(prefix + " Enabled Flame Effects!");
						} else if (args[1].equalsIgnoreCase("redstone")) {
							user.setEffect("redstoning");
							player.sendMessage(prefix + " Enabled Redstone Effects!");
						} else if (args[1].equalsIgnoreCase("lava")) {
							user.setEffect("lavaing");
							player.sendMessage(prefix + " Enabled Lava Effects!");
						} else if (args[1].equalsIgnoreCase("splash")) {
							user.setEffect("splashing");
							player.sendMessage(prefix + " Enabled Splash Effects!");
						} else {
							player.sendMessage(prefix + " Invalid Effect!");
						}
					}
					if (args[0].equalsIgnoreCase("disable")) {
						user.removeEffect();
						player.sendMessage(prefix + " Disabled effects.");
					}
				}
			}
		}
		return true;
	}
}
