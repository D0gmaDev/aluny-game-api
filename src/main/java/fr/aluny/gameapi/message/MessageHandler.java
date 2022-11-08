package fr.aluny.gameapi.message;

import java.util.function.Consumer;

public interface MessageHandler {

    void sendMessage(String key, String... arguments);

    void sendTitle(String titleKey, String[] titleArgs, String messageKey, String[] messageArgs, int fadeIn, int duration, int fadeOut);

    void sendActionBar(String titleKey, String... arguments);

    void sendClickableMessage(Consumer<ClickableMessageBuilder> builder);

}
