package fr.aluny.gameapi.scoreboard;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.timer.Timer;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * Represents a Minecraft scoreboard.
 *
 * @see ScoreboardService
 */
public interface Scoreboard {

    /**
     * Adds a raw text line to the scoreboard.
     *
     * @param text the raw text to add
     * @return the updated scoreboard
     */
    Scoreboard addRawTextLine(String text);

    /**
     * Adds a line to the scoreboard using a component.
     *
     * @param component the component to add as a line
     * @return the updated scoreboard
     */
    Scoreboard addLine(Component component);

    /**
     * Adds a line to the scoreboard using a key and tag resolvers.
     *
     * @param key the translation key
     * @param arguments the tag resolvers
     * @return the updated scoreboard
     */
    Scoreboard addLine(String key, TagResolver... arguments);

    /**
     * Adds a blank line to the scoreboard.
     *
     * @return the updated scoreboard
     */
    Scoreboard addBlankLine();

    /**
     * Adds an updatable line to the scoreboard using a supplier.
     *
     * @param line the supplier that provides the line component
     * @return the updated scoreboard
     */
    Scoreboard addUpdatableLine(Supplier<Component> line);

    /**
     * Adds an updatable line to the scoreboard using a key and a supplier of tag resolvers.
     *
     * @param key the translation key
     * @param arguments the supplier of tag resolvers
     * @return the updated scoreboard
     */
    Scoreboard addUpdatableLine(String key, Supplier<TagResolver> arguments);

    /**
     * Adds an updatable line to the scoreboard using a function that takes a game player and returns a component.
     *
     * @param line the function that provides the line component
     * @return the updated scoreboard
     */
    Scoreboard addUpdatableLine(Function<GamePlayer, Component> line);

    /**
     * Adds an updatable line to the scoreboard using a key and a function of tag resolvers.
     *
     * @param key the translation key
     * @param arguments the function of tag resolvers
     * @return the updated scoreboard
     */
    Scoreboard addUpdatableLine(String key, Function<GamePlayer, TagResolver> arguments);

    /**
     * Adds a conditional line to the scoreboard if the condition is met.
     * Conditional lines are updatable lines.
     *
     * @param component the component for the line
     * @param condition the condition for the line
     * @return the updated scoreboard
     */
    Scoreboard addConditionalLine(Component component, BooleanSupplier condition);

    /**
     * Adds a conditional line to the scoreboard if the condition is met.
     * Conditional lines are updatable lines.
     *
     * @param key the translation key
     * @param arguments the supplier of tag resolvers
     * @param condition the condition for the line
     * @return the updated scoreboard
     */
    Scoreboard addConditionalLine(String key, Supplier<TagResolver> arguments, BooleanSupplier condition);

    /**
     * Adds a conditional line to the scoreboard if the condition is met.
     * Conditional lines are updatable lines.
     *
     * @param line the function that provides the line component
     * @param condition the condition for the line to be displayed
     * @return the updated scoreboard
     */
    Scoreboard addConditionalLine(Function<GamePlayer, Component> line, Predicate<GamePlayer> condition);

    /**
     * Adds a conditional line to the scoreboard if the condition is met.
     * Conditional lines are updatable lines.
     *
     * @param key the translation key
     * @param arguments the function of tag resolvers
     * @param condition the condition for the line
     * @return the updated scoreboard
     */
    Scoreboard addConditionalLine(String key, Function<GamePlayer, TagResolver> arguments, Predicate<GamePlayer> condition);

    /**
     * Adds a timer line to the scoreboard as an updatable line. The replacement tag is {@code timer}.
     *
     * @param key the translation key
     * @param timer the timer to display
     * @return the updated scoreboard
     * @see Timer#getIncreasingFormattedValue()
     */
    Scoreboard addIncreasingTimerLine(String key, Timer timer);

    /**
     * Adds a timer line to the scoreboard as an updatable line. The replacement tag is {@code timer}.
     *
     * @param key the translation key
     * @param timer the timer to display
     * @param endArgument the raw text to display once the timer is done
     * @return the updated scoreboard
     * @see Timer#getDecreasingFormattedValue()
     */
    Scoreboard addDecreasingTimerLine(String key, Timer timer, String endArgument);

    /**
     * Adds a viewer to the scoreboard.
     *
     * @param gamePlayer the game player to add as a viewer
     */
    void addViewer(GamePlayer gamePlayer);

    /**
     * Removes a viewer from the scoreboard.
     *
     * @param gamePlayer the game player to remove as a viewer
     */
    void removeViewer(GamePlayer gamePlayer);

    /**
     * Updates asynchronously every updatable lines of the scoreboard.
     *
     * @param delay the delay before the update starts, in ticks
     * @param period the refreshment period, in ticks
     */
    void updateLinesPeriodically(long delay, long period);

    /**
     * Destroys the scoreboard.
     */
    void destroy();
}
