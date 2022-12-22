package fr.aluny.gameapi.scoreboard.structure.impl;

import fr.aluny.gameapi.scoreboard.PlayerScoreboard;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLineProvider;

public record TextLineWrapper(String line) implements ScoreboardLineProvider {

    @Override
    public String getForPlayer(PlayerScoreboard playerScoreboard) {
        return this.line;
    }
}
