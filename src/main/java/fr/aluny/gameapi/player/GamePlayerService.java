package fr.aluny.gameapi.player;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.entity.Player;

public interface GamePlayerService extends Service {

    Optional<OfflineGamePlayer> getPlayer(UUID uuid);

    GamePlayer getPlayer(Player player);

}
