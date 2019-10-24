package xyz.mclarence.ipkick;

import org.bukkit.command.Command;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class IpKick extends JavaPlugin {

    FileConfiguration config = getConfig();


    public String newHostname = "minecraft.net";
    public String kickMessage = "Please use the new IP to join: " + newHostname;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        kickMessage = config.getString("kickMessage");
        newHostname = config.getString("newHostname");



        registerCommands();

        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getLogger().info("Enabled IP Kick");
    }

    public void registerCommands() {
        CommandHandler handler = new CommandHandler();

        handler.register("ipkick", new BaseCommand());

        handler.register("reload", new ReloadCommand(this));

        getCommand("ipkick").setExecutor(handler);
    }

    public void reloadConfiguration() {
        reloadConfig();
        config = getConfig();
        newHostname = config.getString("newHostname");
        kickMessage = config.getString("kickMessage");
    }
}
