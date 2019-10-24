package xyz.mclarence.ipkick;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

import java.awt.*;

public class EventListener implements Listener {

    IpKick plugin;

    public EventListener(IpKick _plugin) {
        plugin = _plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        plugin.getLogger().info("Player " + event.getPlayer().getName() + " joined with hostname " + event.getHostname().toLowerCase());
        if (!event.getHostname().toLowerCase().contains(plugin.newHostname)) {
            TextComponent kickMsg = new TextComponent(plugin.kickMessage);
            plugin.getLogger().info("Kicking player " + event.getPlayer().getName());
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, kickMsg.toLegacyText());
        }
    }
}
