package fr.aluny.gameapi.player;

import fr.aluny.gameapi.scoreboard.Scoreboard;
import fr.aluny.gameapi.scoreboard.team.ScoreboardTeam;
import java.util.Optional;
import org.bukkit.entity.Player;

/**
 * Represents a necessarily online player.
 */
public interface GamePlayer extends OfflineGamePlayer {

    Player getPlayer();

    int getPing();

    Optional<ScoreboardTeam> getScoreboardTeam();

    /**
     * Manually sets a team. This method should generally not be called
     * unless you know what you are doing.
     *
     * @param scoreboardTeam the team to set
     * @see ScoreboardTeam#addPlayer
     * @see ScoreboardTeam#removePlayer
     */
    void setScoreboardTeam(ScoreboardTeam scoreboardTeam);

    Optional<Scoreboard> getScoreboard();

    /**
     * Manually sets a scoreboard. This method should generally not be called
     * unless you know what you are doing.
     *
     * @param scoreboard the scoreboard to set
     * @see fr.aluny.gameapi.scoreboard.ScoreboardService#displayScoreboard
     * @see fr.aluny.gameapi.scoreboard.ScoreboardService#deleteScoreboard
     */
    void setScoreboard(Scoreboard scoreboard);

    boolean isVanished();

}
