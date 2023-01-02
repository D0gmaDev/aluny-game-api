package fr.aluny.gameapi.player;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import java.util.UUID;

public interface PlayerAccountService extends Service {

    PlayerAccount getPlayerAccount(OfflineGamePlayer gamePlayer);

    Optional<PlayerAccount> getPlayerAccount(UUID uuid);

}
