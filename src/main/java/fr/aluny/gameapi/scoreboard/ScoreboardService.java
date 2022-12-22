package fr.aluny.gameapi.scoreboard;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLine;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardStructure;
import fr.aluny.gameapi.service.Service;
import fr.aluny.gameapi.timer.Timer;

public interface ScoreboardService extends Service {

    ScoreboardStructure createStructure(String title, ScoreboardLine... lines);

    void displayScoreboard(GamePlayer gamePlayer, ScoreboardStructure structure);

    void deleteScoreboard(GamePlayer gamePlayer);

    ScoreboardLine getEmptyLine();

    ScoreboardLine getIpLine();

    ScoreboardLine getLine(String key, String... args);

    ScoreboardLine getIncreasingTimerLine(String key, Timer timer);

    ScoreboardLine getDecreasingTimerLine(String key, Timer timer, String endedKey);

}
