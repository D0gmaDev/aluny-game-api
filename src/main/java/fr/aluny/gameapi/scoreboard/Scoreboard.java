package fr.aluny.gameapi.scoreboard;

import java.util.Collection;
import java.util.List;
import org.bukkit.entity.Player;

public interface Scoreboard {

    /**
     * Get the scoreboard title.
     *
     * @return the scoreboard title
     */
    String getTitle();

    /**
     * Update the scoreboard title.
     *
     * @param title the new scoreboard title
     * @throws IllegalArgumentException if the title is longer than 32 chars on 1.12 or lower
     * @throws IllegalStateException if {@link #delete()} was call before
     */
    void updateTitle(String title);

    /**
     * Get the scoreboard lines.
     *
     * @return the scoreboard lines
     */
    List<String> getLines();

    /**
     * Get the specified scoreboard line.
     *
     * @param line the line number
     * @return the line
     * @throws IndexOutOfBoundsException if the line is higher than {@code size}
     */
    String getLine(int line);

    /**
     * Update a single scoreboard line.
     *
     * @param line the line number
     * @param text the new line text
     * @throws IndexOutOfBoundsException if the line is higher than {@link #size() size() + 1}
     */
    void updateLine(int line, String text);

    /**
     * Remove a scoreboard line.
     *
     * @param line the line number
     */
    void removeLine(int line);

    /**
     * Update all the scoreboard lines.
     *
     * @param lines the new lines
     * @throws IllegalArgumentException if one line is longer than 30 chars on 1.12 or lower
     * @throws IllegalStateException if {@link #delete()} was call before
     */
    void updateLines(String... lines);

    /**
     * Update the lines of the scoreboard
     *
     * @param lines the new scoreboard lines
     * @throws IllegalArgumentException if one line is longer than 30 chars on 1.12 or lower
     * @throws IllegalStateException if {@link #delete()} was call before
     */
    void updateLines(Collection<String> lines);

    /**
     * Get the player who has the scoreboard.
     *
     * @return current player for this ScoreboardImpl
     */
    Player getPlayer();

    /**
     * Get the scoreboard id.
     *
     * @return the id
     */
    String getId();

    /**
     * Get if the scoreboard is deleted.
     *
     * @return true if the scoreboard is deleted
     */
    boolean isDeleted();

    /**
     * Get the scoreboard size (the number of lines).
     *
     * @return the size
     */
    int size();

    /**
     * Delete this ScoreboardImpl, and will remove the scoreboard for the associated player if he is online.
     * After this, all uses of {@link #updateLines} and {@link #updateTitle} will throw an {@link IllegalStateException}
     *
     * @throws IllegalStateException if this was already call before
     */
    void delete();

    /**
     * Return if the player has a prefix/suffix characters limit.
     * By default, it returns true only in 1.12 or lower.
     * This method can be overridden to fix compatibility with some versions support plugin.
     *
     * @return max length
     */
    boolean hasLinesMaxLength();
}
