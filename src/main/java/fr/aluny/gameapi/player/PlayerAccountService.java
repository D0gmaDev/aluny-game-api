package fr.aluny.gameapi.player;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import java.util.UUID;

public interface PlayerAccountService extends Service {

    PlayerAccount getPlayerAccount(OfflineGamePlayer gamePlayer);

    PlayerAccount getPlayerAccount(OfflineGamePlayer gamePlayer, boolean forceRefresh);

    Optional<PlayerAccount> getPlayerAccount(UUID uuid);

    Optional<PlayerAccount> getPlayerAccountByName(String name);

    boolean isOnline(UUID uuid);

}
