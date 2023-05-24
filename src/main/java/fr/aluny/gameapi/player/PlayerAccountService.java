package fr.aluny.gameapi.player;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents an account service. An account is the player's data that
 * is stored in the database.
 *
 * @see PlayerAccount
 */
public interface PlayerAccountService extends Service {

    /**
     * Retrieves the player account for the specified game player.
     * The method can return a cached result (up to 30 seconds old) if available.
     * <p>
     * Since any OfflinePlayer is supposed to have an account, the method will
     * throw an exception if the no account is found.
     *
     * @param gamePlayer the offline game player
     * @return the player account, non-null
     */
    PlayerAccount getPlayerAccount(OfflineGamePlayer gamePlayer);

    /**
     * Retrieves the player account for the specified offline game player.
     * The method can return a cached result (up to 30 seconds old) if available,
     * unless the 'forceRefresh' flag is set to true.
     * <p>
     * Since any OfflinePlayer is supposed to have an account, the method will
     * throw an exception if the no account is found.
     *
     * @param gamePlayer the game player
     * @param forceRefresh true to force a fresh retrieval, false to allow cached result
     * @return the player account, non-null
     */
    PlayerAccount getPlayerAccount(OfflineGamePlayer gamePlayer, boolean forceRefresh);

    /**
     * Retrieves the player account associated with the specified UUID.
     * The method provides an accurate result.
     *
     * @param uuid the UUID of the player
     * @return an optional containing the player account if found, otherwise empty
     */
    Optional<PlayerAccount> getPlayerAccount(UUID uuid);

    /**
     * Retrieves the player account associated with the specified name.
     * The method provides an accurate result.
     *
     * @param name the name of the player
     * @return an optional containing the player account if found, otherwise empty
     */
    Optional<PlayerAccount> getPlayerAccountByName(String name);

    /**
     * Checks if the player with the specified UUID is currently online
     * anywhere on the network.
     * The method provides an accurate result.
     *
     * @param uuid the UUID of the player
     * @return true if the player is online, false otherwise
     */
    boolean isOnline(UUID uuid);
}
