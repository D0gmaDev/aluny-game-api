package fr.aluny.gameapi.proxy;

import fr.aluny.gameapi.service.Service;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

public interface ProxyMessagingService extends Service {

    void connect(Player player, String server);

    void kickFromProxy(Player sender, String targetName, String reason);

    void sendMessage(Player sender, String targetName, BaseComponent message);

    void sendMessage(Player sender, String targetName, String message);

    String[] getOnlinePlayerNames(Player sender);

}
