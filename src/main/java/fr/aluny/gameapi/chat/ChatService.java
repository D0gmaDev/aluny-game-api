package fr.aluny.gameapi.chat;

import fr.aluny.gameapi.service.Service;
import java.util.UUID;

public interface ChatService extends Service {

    void registerDefaultChatPreProcessor(ChatPreProcessor chatPreProcessor);

    void registerChatPreProcessor(char prefix, ChatPreProcessor chatPreProcessor);

    void setDefaultChatProcessor(ChatProcessor chatProcessor);

    void setChatProcessor(char prefix, ChatProcessor chatProcessor);

    void unregisterAllChatPreProcessor(char prefix);

    void unregisterChatPreProcessor(char prefix, ChatPreProcessor chatPreProcessor);

    void unregisterDefaultChatProcessor();

    void unregisterChatProcessor(char prefix);

    void addChatListener(UUID uuid, ChatCallback callback);

    void cancelChatListener(UUID uuid);

}
