package fr.aluny.gameapi.scoreboard.structure;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.scoreboard.PlayerScoreboard;
import java.util.Set;

public interface ScoreboardLine {

    ScoreboardLineProvider getLineProvider();

    void addScoreboard(PlayerScoreboard playerScoreboard);

    void removeScoreboard(PlayerScoreboard playerScoreboard);

    Set<PlayerScoreboard> getScoreboards();

    void notifyScoreboards();

    void notifyScoreboard(GamePlayer gamePlayer);

}
