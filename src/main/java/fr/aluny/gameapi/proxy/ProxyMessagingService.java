package fr.aluny.gameapi.proxy;

import fr.aluny.gameapi.service.Service;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

/**
 * The ProxyMessagingService uses the BungeeCord Messaging channel to execute actions.
 * These methods will have no effect if the plugin is not run on a BungeeCord proxy.
 */
public interface ProxyMessagingService extends Service {

    void connect(Player player, String server);

    void connectOther(Player sender, String targetName, String server);

    void kickFromProxy(Player sender, String targetName, Component reason);

    @Deprecated
    void sendMessage(Player sender, String targetName, BaseComponent message);

    void sendMessage(Player sender, String targetName, Component message);

    void sendMessage(Player sender, String targetName, String message);

}
