package fr.aluny.gameapi.scoreboard.team;

import fr.aluny.gameapi.player.GamePlayer;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

public interface ScoreboardTeam {

    /**
     * Gets the name of this Team
     *
     * @return Team name
     */
    String getName();

    /**
     * Gets the prefix prepended to the display of entries on this team.
     *
     * @return Team prefix
     */
    String getPrefix();

    /**
     * Sets the prefix prepended to the display of entries on this team.
     *
     * @param prefix New prefix
     * characters
     */
    void setPrefix(String prefix);

    /**
     * Gets the suffix appended to the display of entries on this team.
     *
     * @return the team's current suffix
     */
    String getSuffix();

    /**
     * Sets the suffix appended to the display of entries on this team.
     *
     * @param suffix the new suffix for this team.
     * characters
     */
    void setSuffix(String suffix);

    /**
     * Gets the color of the team.
     *
     * @return team color, defaults to {@link ChatColor#RESET}
     */
    ChatColor getColor() throws IllegalStateException;

    /**
     * Sets the color of the team.
     *
     * @param color new color, must be non-null. Use {@link ChatColor#RESET} for
     * no color
     */
    void setColor(ChatColor color);

    /**
     * Gets the Set of players on the team
     *
     * @return players on the team
     */
    Set<GamePlayer> getPlayers();

    /**
     * Gets the size of the team
     *
     * @return number of players on the team
     */
    int getSize();

    /**
     * This puts the specified player onto this team for the scoreboard.
     * This will remove the player from any other team on the scoreboard.
     *
     * @param player the player to add
     */
    void addPlayer(GamePlayer player);

    /**
     * Removes the player from this team.
     *
     * @param player the player to remove
     * @return if the player was on this team
     */
    boolean removePlayer(GamePlayer player);

    /**
     * Unregisters this team
     */
    void unregister();

    /**
     * Checks to see if the specified player is a member of this team.
     *
     * @param player the player to search for
     * @return true if the player is a member of this team
     */
    boolean hasPlayer(GamePlayer player);

    /**
     * Get an option for this team
     *
     * @param option the option to get
     * @return the option status
     */
    Team.OptionStatus getOption(Team.Option option);

    /**
     * Set an option for this team
     *
     * @param option the option to set
     * @param status the new option status
     */
    void setOption(Team.Option option, Team.OptionStatus status);

}
