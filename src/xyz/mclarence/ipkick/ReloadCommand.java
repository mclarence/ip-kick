package xyz.mclarence.ipkick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandInterface {

    IpKick plugin;

    public ReloadCommand(IpKick _plugin) {
        plugin = _plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!p.hasPermission("ipkick.reload")) {
                p.sendMessage("You do not have permission to access this command");
                return false;
            }
        }

        plugin.reloadConfiguration();
        sender.sendMessage("Reloaded IP Kick");
        return true;
    }
}
