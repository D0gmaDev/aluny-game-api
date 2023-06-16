package fr.aluny.gameapi.moderation;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.service.Service;
import java.util.List;

public interface VanishService extends Service {

    /**
     * Gets all vanished players currently on this server.
     *
     * @return an immutable list containing all vanishedPlayers.
     */
    List<GamePlayer> getVanishedPlayers();

    /**
     * returns if the player is currently vanished on this server.
     */
    boolean isVanished(GamePlayer gamePlayer);

    void vanishPlayer(GamePlayer gamePlayer);

    void unVanishPlayer(GamePlayer gamePlayer);

}
