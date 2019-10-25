package xyz.mclarence.ipkick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!p.hasPermission("ipkick.base")) {
                p.sendMessage("You do not have permission to access this command");
                return false;
            }
        }
        sender.sendMessage("IP Kick version 1. Reload configuration with /ipkick reload");
        return true;
    }
}
