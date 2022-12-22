package fr.aluny.gameapi.scoreboard.structure.impl;

import fr.aluny.gameapi.scoreboard.PlayerScoreboard;
import fr.aluny.gameapi.scoreboard.structure.ScoreboardLineProvider;
import fr.aluny.gameapi.timer.RunnableHelper;
import java.time.Duration;
import org.bukkit.scheduler.BukkitTask;

public class AutoUpdateLine extends BaseScoreboardLine {

    private final RunnableHelper         runnableHelper;
    private final ScoreboardLineProvider provider;
    private final Duration               interval;

    private BukkitTask bukkitTask;

    public AutoUpdateLine(RunnableHelper runnableHelper, ScoreboardLineProvider provider, Duration interval) {
        this.runnableHelper = runnableHelper;
        this.provider = provider;
        this.interval = interval;
    }

    @Override
    public ScoreboardLineProvider getLineProvider() {
        return this.provider;
    }

    @Override
    public void addScoreboard(PlayerScoreboard playerScoreboard) {
        super.addScoreboard(playerScoreboard);

        if (this.bukkitTask == null)
            this.bukkitTask = runnableHelper.runTimerAsynchronously(this::notifyScoreboards, 0, (long) (this.interval.toMillis() * 0.02));
    }

    @Override
    public void removeScoreboard(PlayerScoreboard playerScoreboard) {
        super.removeScoreboard(playerScoreboard);

        if (this.bukkitTask != null && getScoreboards().isEmpty()) {
            this.bukkitTask.cancel();
            this.bukkitTask = null;
        }
    }
}
