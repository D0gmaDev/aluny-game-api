package fr.aluny.gameapi.message;

import java.util.List;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * Represents a message handler for sending messages to players.
 *
 * @see MessageService
 */
public interface MessageHandler {

    /**
     * Sends a message with the specified key and arguments to the player(s) associated with this message handler.
     *
     * @param key the key of the message to send
     * @param arguments the arguments to replace in the message
     */
    void sendMessage(String key, String... arguments);

    /**
     * Sends a component message with the specified key and tag resolvers to the player(s) associated with this message handler.
     *
     * @param key the key of the message to send
     * @param arguments the tag resolvers to use for replacing placeholders in the message
     */
    void sendComponentMessage(String key, TagResolver... arguments);

    /**
     * Sends a title and subtitle to the player(s) associated with this message handler.
     *
     * @param titleKey the key of the title message to send
     * @param titleArgs the tag resolvers to use for replacing placeholders in the title message
     * @param messageKey the key of the subtitle message to send
     * @param messageArgs the tag resolvers to use for replacing placeholders in the subtitle message
     * @param fadeIn the duration in ticks for the title to fade in, in seconds
     * @param duration the duration in ticks for the title to display, in seconds
     * @param fadeOut the duration in ticks for the title to fade out, in seconds
     */
    void sendTitle(String titleKey, List<TagResolver> titleArgs, String messageKey, List<TagResolver> messageArgs, int fadeIn, int duration, int fadeOut);

    /**
     * Sends an action bar message with the specified key and tag resolvers to the player(s) associated with this message handler.
     *
     * @param key the key of the message to send
     * @param arguments the tag resolvers to use for replacing placeholders in the message
     */
    void sendActionBar(String key, TagResolver... arguments);

}
