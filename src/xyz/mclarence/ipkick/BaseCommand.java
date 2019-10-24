package xyz.mclarence.ipkick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class BaseCommand implements CommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        sender.sendMessage("Base command");
        return true;
    }
}
