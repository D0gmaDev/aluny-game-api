package fr.aluny.gameapi.moderation;

import fr.aluny.gameapi.service.Service;
import java.time.OffsetDateTime;
import java.util.UUID;

public interface ModerationService extends Service {

    /**
     * Check if a player is currently muted.
     *
     * @param uuid the uuid of the player
     * @return true if the player is muted, false otherwise
     */
    boolean isMuted(UUID uuid);

    /**
     * Gets the unmute date for a player, meaning the latest expiration date of all active mute sanctions.
     *
     * @param uuid the uuid of the player
     * @return when the player will be able to talk, or {@link OffsetDateTime#now() the current date} if the player is not muted
     */
    OffsetDateTime getUnMuteDate(UUID uuid);

}
