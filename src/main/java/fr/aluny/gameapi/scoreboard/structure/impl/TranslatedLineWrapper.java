package fr.aluny.gameapi.scoreboard.structure.impl;

import fr.aluny.gameapi.scoreboard.PlayerScoreboard;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLineProvider;

public record TranslatedLineWrapper(String key, String... args) implements ScoreboardLineProvider {

    @Override
    public String getForPlayer(PlayerScoreboard playerScoreboard) {
        return playerScoreboard.getLocale().translate(key, (Object[]) args);
    }
}
