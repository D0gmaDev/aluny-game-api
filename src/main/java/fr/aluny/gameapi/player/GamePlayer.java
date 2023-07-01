package fr.aluny.gameapi.player;

import fr.aluny.gameapi.scoreboard.Scoreboard;
import fr.aluny.gameapi.scoreboard.team.ScoreboardTeam;
import java.util.Optional;
import org.bukkit.entity.Player;

/**
 * Represents a necessarily online player.
 */
public interface GamePlayer extends OfflineGamePlayer {

    /**
     * Retrieves the {@link Player} associated with this {@link GamePlayer}.
     *
     * @return the player object
     */
    Player getPlayer();

    /**
     * Retrieves the ping of the player, in milliseconds.
     *
     * @return the player's ping
     */
    int getPing();

    /**
     * Retrieves the scoreboard team associated with the player, if any.
     *
     * @return an optional containing the scoreboard team if present, otherwise empty
     */
    Optional<ScoreboardTeam> getScoreboardTeam();

    /**
     * Manually sets a team for the player. This method should generally not be called
     * unless you know what you are doing.
     *
     * @param scoreboardTeam the team to set
     * @see ScoreboardTeam#addPlayer
     * @see ScoreboardTeam#removePlayer
     */
    void setScoreboardTeam(ScoreboardTeam scoreboardTeam);

    /**
     * Retrieves the scoreboard associated with the player, if any.
     *
     * @return an optional containing the scoreboard if present, otherwise empty
     */
    Optional<Scoreboard> getScoreboard();

    /**
     * Manually sets a scoreboard for the player. This method should generally not be called
     * unless you know what you are doing.
     *
     * @param scoreboard the scoreboard to set
     * @see fr.aluny.gameapi.scoreboard.ScoreboardService#displayScoreboard
     * @see fr.aluny.gameapi.scoreboard.ScoreboardService#deleteScoreboard
     */
    void setScoreboard(Scoreboard scoreboard);

    /**
     * Checks if the player is currently vanished.
     *
     * @return true if the player is vanished, false otherwise
     */
    boolean isVanished();

    /**
     * Manually sets whether the player is vanished. This method should generally not be called
     * unless you know what you are doing.
     *
     * @param vanished the vanished state
     * @see fr.aluny.gameapi.moderation.VanishService#vanishPlayer(GamePlayer)
     * @see fr.aluny.gameapi.moderation.VanishService#unVanishPlayer(GamePlayer)
     */
    void setVanished(boolean vanished);

}
