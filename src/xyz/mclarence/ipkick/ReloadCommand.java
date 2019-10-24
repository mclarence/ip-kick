package xyz.mclarence.ipkick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandInterface {

    IpKick plugin;

    public ReloadCommand(IpKick _plugin) {
        plugin = _plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {

        plugin.reloadConfiguration();
        sender.sendMessage("Reloaded IP Kick");
        return false;
    }
}
