package fr.aluny.gameapi.proxy;

import fr.aluny.gameapi.service.Service;
import org.bukkit.entity.Player;

public interface ProxyMessagingService extends Service {

    void connect(Player player, String server);

    void kickFromProxy(Player sender, String targetName, String reason);

}
