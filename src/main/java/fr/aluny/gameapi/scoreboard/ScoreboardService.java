package fr.aluny.gameapi.scoreboard;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.service.Service;
import fr.aluny.gameapi.translation.Locale;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;

public interface ScoreboardService extends Service {

    /**
     * Creates a new scoreboard. If you are not sure what you are doing,
     * please use {@link #displayScoreboard this method} instead.
     *
     * @param locale the locale for the scoreboard
     * @param title the scoreboard title
     * @return the created scoreboard
     */
    Scoreboard createScoreboard(Locale locale, Component title);

    /**
     * Displays a scoreboard for a player.
     *
     * @param gamePlayer the game player to display the scoreboard to
     * @param locale the locale for the scoreboard
     * @param title the scoreboard title
     * @param scoreboardBuilder a consumer that builds the scoreboard
     * @return the displayed scoreboard
     * @see GamePlayer#getScoreboard()
     */
    Scoreboard displayScoreboard(GamePlayer gamePlayer, Locale locale, Component title, Consumer<Scoreboard> scoreboardBuilder);

    /**
     * Displays a scoreboard for a player, that updates its updatable lines periodically
     *
     * @param gamePlayer the game player to display the scoreboard to
     * @param locale the locale for the scoreboard
     * @param title the scoreboard title
     * @param scoreboardBuilder a consumer that builds the scoreboard
     * @param updatePeriod the update interval, in ticks
     * @return the displayed scoreboard
     * @see GamePlayer#getScoreboard()
     */
    Scoreboard displayScoreboard(GamePlayer gamePlayer, Locale locale, Component title, long updatePeriod, Consumer<Scoreboard> scoreboardBuilder);

    /**
     * Deletes the scoreboard for a player.
     *
     * @param gamePlayer the game player to delete the scoreboard for
     * @see GamePlayer#getScoreboard()
     */
    void deleteScoreboard(GamePlayer gamePlayer);

}
