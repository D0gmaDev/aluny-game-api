package fr.aluny.gameapi.message;

import fr.aluny.gameapi.player.OfflineGamePlayer;
import fr.aluny.gameapi.service.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Supplier;
import net.kyori.adventure.text.minimessage.MiniMessage;

/**
 * Represents a service for sending messages to players.
 *
 * @see MessageHandler
 */
public interface MessageService extends Service {

    MiniMessage COMPONENT_PARSER = MiniMessage.miniMessage();

    /**
     * Returns the message handler for the specified player.
     *
     * @param gamePlayer the game player to get the message handler for
     * @return the message handler for the specified game player
     * @deprecated Use {@link OfflineGamePlayer#getMessageHandler()} instead.
     */
    @Deprecated
    MessageHandler getPlayerMessageHandler(OfflineGamePlayer gamePlayer);

    /**
     * Returns the message handler for a set of receivers.
     *
     * @param receiversSupplier a supplier for the set of receivers
     * @return the message handler for the set of receivers
     */
    MessageHandler getSetMessageHandler(Supplier<Collection<UUID>> receiversSupplier);

    /**
     * Returns the message handler for broadcasting messages to all players.
     *
     * @return the global message handler
     */
    MessageHandler getBroadcastHandler();

}
