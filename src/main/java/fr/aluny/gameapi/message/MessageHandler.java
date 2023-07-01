package fr.aluny.gameapi.message;

import java.time.Duration;
import net.kyori.adventure.bossbar.BossBar;
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
     * @param titleKey the key of the title message to send, can be null
     * @param titleArgs the tag resolver to use for replacing placeholders in the title message, can be null
     * @param messageKey the key of the subtitle message to send, can be null
     * @param messageArgs the tag resolver to use for replacing placeholders in the subtitle message, can be null
     * @param fadeIn the duration for the title to fade in
     * @param stay the duration for the title to display
     * @param fadeOut the duration for the title to fade out
     */
    void sendTitle(String titleKey, TagResolver titleArgs, String messageKey, TagResolver messageArgs, Duration fadeIn, Duration stay, Duration fadeOut);

    /**
     * Sends a title and subtitle to the player(s) associated with this message handler.
     *
     * @param titleKey the key of the title message to send, can be null
     * @param titleArgs the tag resolver to use for replacing placeholders in the title message, can be null
     * @param messageKey the key of the subtitle message to send, can be null
     * @param messageArgs the tag resolver to use for replacing placeholders in the subtitle message, can be null
     * @param fadeIn the duration for the title to fade in, in seconds
     * @param stay the duration for the title to display, in seconds
     * @param fadeOut the duration in for the title to fade out, in seconds
     */
    void sendTitle(String titleKey, TagResolver titleArgs, String messageKey, TagResolver messageArgs, int fadeIn, int stay, int fadeOut);

    /**
     * Sends an action bar message with the specified key and tag resolvers to the player(s) associated with this message handler.
     *
     * @param key the key of the message to send
     * @param arguments the tag resolvers to use for replacing placeholders in the message
     */
    void sendActionBar(String key, TagResolver... arguments);

    void showBossBar(String titleKey, TagResolver arguments, BossBar.Color color, BossBar.Overlay overlay, Duration duration);

}
