package fr.aluny.gameapi.chat;

import java.util.function.Consumer;

/**
 * A PreProcessor is called asynchronously when a {@link org.bukkit.event.player.AsyncPlayerChatEvent chat event} is triggered, and can perform mutable operations on
 * the {@link ProcessedChat} such as cancel it or format it (whether globally or individually)
 *
 * @see ProcessedChat
 */
public interface ChatPreProcessor extends Consumer<ProcessedChat> {

}
