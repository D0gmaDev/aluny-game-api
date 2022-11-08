package fr.aluny.gameapi.player;

import fr.aluny.gameapi.scoreboard.team.ScoreboardTeam;
import java.util.Optional;
import org.bukkit.entity.Player;

public interface GamePlayer extends OfflineGamePlayer {

    Player getPlayer();

    int getPing();

    Optional<ScoreboardTeam> getScoreboardTeam();

    void setScoreboardTeam(ScoreboardTeam scoreboardTeam);

}
