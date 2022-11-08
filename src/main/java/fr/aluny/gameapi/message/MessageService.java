package fr.aluny.gameapi.message;

import fr.aluny.gameapi.player.OfflineGamePlayer;
import fr.aluny.gameapi.service.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Supplier;

public interface MessageService extends Service {

    @Deprecated
    MessageHandler getPlayerMessageHandler(OfflineGamePlayer gamePlayer);

    MessageHandler getSetMessageHandler(Supplier<Collection<UUID>> receiversSupplier);

    MessageHandler getBroadcastHandler();

}
