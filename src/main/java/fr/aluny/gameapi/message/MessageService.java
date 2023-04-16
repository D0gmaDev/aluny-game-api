package fr.aluny.gameapi.message;

import fr.aluny.gameapi.player.OfflineGamePlayer;
import fr.aluny.gameapi.service.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Supplier;
import net.kyori.adventure.text.minimessage.MiniMessage;

public interface MessageService extends Service {

    MiniMessage COMPONENT_PARSER = MiniMessage.miniMessage();

    @Deprecated
    MessageHandler getPlayerMessageHandler(OfflineGamePlayer gamePlayer);

    MessageHandler getSetMessageHandler(Supplier<Collection<UUID>> receiversSupplier);

    MessageHandler getBroadcastHandler();

}
