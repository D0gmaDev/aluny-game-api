package fr.aluny.gameapi.player;

import fr.aluny.gameapi.player.rank.Rank;
import fr.aluny.gameapi.translation.Locale;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * The PlayerAccount interface represents a frozen player account, representing
 * what is stored in the database at a given moment.
 */
public interface PlayerAccount {

    /**
     * Gets the UUID of the player.
     *
     * @return the UUID of the player
     */
    UUID getUuid();

    /**
     * Gets the username of the player, as stored in the database.
     *
     * @return the name of the player
     */
    String getName();

    /**
     * Gets the id of the server the player is currently connected to, if any.
     *
     * @return an optional containing the id of the server the player is currently connected to, or empty if the player is not connected
     */
    Optional<Integer> getCurrentServerId();

    /**
     * Gets the locale of the player.
     *
     * @return the locale of the player
     * @see Locale
     */
    Locale getLocale();

    /**
     * Gets the set of {@link Rank ranks} assigned to the player.
     * This set is immutable.
     *
     * @return the set of ranks assigned to the player
     * @see Rank
     */
    Set<Rank> getRanks();

    /**
     * Gets the creation date of the player's account, as stored in the database.
     *
     * @return the creation date of the player's account
     */
    OffsetDateTime getCreationDate();

    /**
     * Gets the highest {@link Rank} assigned to the player. This rank always exists,
     * as every player always has at least one rank.
     *
     * @return the highest rank assigned to the player
     * @see Rank
     */
    Rank getHighestRank();

    /**
     * Returns whether this player account has the specified permission. This method checks
     * every {@link #getRanks() rank} that this player account possesses for the permission.
     *
     * @param permission the permission to check for
     * @return true if this player account has the permission, false otherwise
     * @see Rank#hasPermission(String)
     */
    boolean hasPermission(String permission);

}
