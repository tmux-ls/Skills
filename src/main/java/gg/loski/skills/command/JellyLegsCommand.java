package gg.loski.skills.command;

import gg.loski.skills.utils.Constants;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JellyLegsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("jellylegs")) {
            return true;
        }

        if (Constants.jellyLegs.contains(player.getUniqueId())) {
            Constants.jellyLegs.remove(player.getUniqueId());
        } else {
            Constants.jellyLegs.add(player.getUniqueId());
        }

        return false;
    }
}
