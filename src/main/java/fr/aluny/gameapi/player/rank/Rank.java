package fr.aluny.gameapi.player.rank;

import java.util.Set;

/**
 * Represents a player rank, which can be used to determine various permissions or access levels.
 * Players can cumulate many ranks.
 */
public interface Rank {

    /**
     * Gets the id of the rank.
     *
     * @return The id of the rank
     */
    int getId();

    /**
     * Gets the name of the rank.
     *
     * @return The name of the rank
     */
    String getName();

    /**
     * Gets the importance index of the rank. Ranks with higher importance index are considered
     * to be higher in the hierarchy.
     *
     * @return The importance index of the rank
     */
    int getImportanceIndex();

    /**
     * Gets the prefix associated with the rank.
     *
     * @return The prefix of the rank
     */
    String getPrefix();

    /**
     * Gets the hexadecimal color code associated with the rank.
     * Example: {@code #f09e9f}
     *
     * @return The color code of the rank
     */
    String getColorCode();

    /**
     * Gets the set of permissions associated with the rank.
     * This set is immutable.
     *
     * @return The set of permissions
     */
    Set<String> getPermissions();

    /**
     * Checks whether the rank has a particular permission.
     *
     * @param permission The permission to check
     * @return {@code true} if the rank has the permission, {@code false} otherwise
     */
    boolean hasPermission(String permission);

    /**
     * Compares the rank with another rank to determine if it is higher or equal in the hierarchy.
     * Ranks with higher {@link #getImportanceIndex() importance index} are considered to be higher in the hierarchy.
     *
     * @param other The other rank to compare against
     * @return {@code true} if the rank is higher or equal to the other rank, {@code false} otherwise
     * @see #getImportanceIndex()
     */
    boolean isHigherOrEqualThan(Rank other);

}
