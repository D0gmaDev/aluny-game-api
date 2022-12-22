package fr.aluny.gameapi.scoreboard.structure.impl;

import fr.aluny.gameapi.scoreboard.PlayerScoreboard;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLineProvider;
import java.util.function.Supplier;

public record SuppliedLineProvider(Supplier<String> supplier) implements ScoreboardLineProvider {

    @Override
    public String getForPlayer(PlayerScoreboard playerScoreboard) {
        return supplier.get();
    }
}
