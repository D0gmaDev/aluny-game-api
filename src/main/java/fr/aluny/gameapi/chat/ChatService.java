package fr.aluny.gameapi.chat;

import fr.aluny.gameapi.service.Service;
import java.util.UUID;
import reactor.core.publisher.MonoSink;

public interface ChatService extends Service {

    void registerDefaultChatPreProcessor(ChatPreProcessor chatPreProcessor);

    void registerChatPreProcessor(String prefix, ChatPreProcessor chatPreProcessor);

    void setDefaultChatProcessor(ChatProcessor chatProcessor);

    void setChatProcessor(String prefix, ChatProcessor chatProcessor);

    void unregisterAllChatPreProcessor(String prefix);

    void unregisterChatPreProcessor(String prefix, ChatPreProcessor chatPreProcessor);

    void unregisterDefaultChatProcessor();

    void unregisterChatProcessor(String prefix);

    void addChatListener(UUID uuid, MonoSink<String> callback);

    void cancelChatListener(UUID uuid);

}
