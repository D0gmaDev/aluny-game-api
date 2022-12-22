package fr.aluny.gameapi.scoreboard.structure.impl;

import fr.aluny.gameapi.scoreboard.structure.ScoreboardLineProvider;

public class SimpleScoreboardLine extends BaseScoreboardLine {

    private final ScoreboardLineProvider provider;

    public SimpleScoreboardLine(ScoreboardLineProvider provider) {
        this.provider = provider;
    }

    @Override
    public ScoreboardLineProvider getLineProvider() {
        return provider;
    }
}
