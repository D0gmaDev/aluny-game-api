package fr.aluny.gameapi.scoreboard;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLine;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardStructure;
import fr.aluny.gameapi.translation.Locale;

public interface PlayerScoreboard {

    GamePlayer getGamePlayer();

    Locale getLocale();

    ScoreboardStructure getStructure();

    void updateLine(ScoreboardLine scoreboardLine);

}
