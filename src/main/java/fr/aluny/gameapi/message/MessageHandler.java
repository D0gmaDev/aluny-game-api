package fr.aluny.gameapi.message;

import java.util.List;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public interface MessageHandler {

    default void sendMessage(String key, String... arguments) {

    }

    void sendComponentMessage(String key, TagResolver... arguments);

    void sendTitle(String titleKey, List<TagResolver> titleArgs, String messageKey, List<TagResolver> messageArgs, int fadeIn, int duration, int fadeOut);

    void sendActionBar(String key, TagResolver... arguments);

}
