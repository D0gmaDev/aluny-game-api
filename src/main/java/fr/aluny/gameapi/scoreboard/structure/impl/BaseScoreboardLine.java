package fr.aluny.gameapi.scoreboard.structure.impl;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.scoreboard.PlayerScoreboard;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLine;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseScoreboardLine implements ScoreboardLine {

    private final Set<PlayerScoreboard> playerScoreboards = new HashSet<>();

    @Override
    public void addScoreboard(PlayerScoreboard playerScoreboard) {
        this.playerScoreboards.add(playerScoreboard);
    }

    @Override
    public void removeScoreboard(PlayerScoreboard playerScoreboard) {
        this.playerScoreboards.remove(playerScoreboard);
    }

    @Override
    public Set<PlayerScoreboard> getScoreboards() {
        return Collections.unmodifiableSet(this.playerScoreboards);
    }

    @Override
    public void notifyScoreboards() {
        playerScoreboards.forEach(playerScoreboard -> playerScoreboard.updateLine(this));
    }

    @Override
    public void notifyScoreboard(GamePlayer gamePlayer) {
        gamePlayer.getScoreboard().filter(this.playerScoreboards::contains).ifPresent(playerScoreboard -> playerScoreboard.updateLine(this));
    }
}
