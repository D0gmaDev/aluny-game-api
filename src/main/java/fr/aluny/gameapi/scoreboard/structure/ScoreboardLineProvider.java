package fr.aluny.gameapi.scoreboard.structure;

import fr.aluny.gameapi.scoreboard.PlayerScoreboard;

public interface ScoreboardLineProvider {

    String getForPlayer(PlayerScoreboard playerScoreboard);

}
