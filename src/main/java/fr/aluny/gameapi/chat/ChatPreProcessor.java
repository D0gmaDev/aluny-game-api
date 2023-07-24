package fr.aluny.gameapi.chat;

import java.util.function.Consumer;

/**
 * A PreProcessor is called asynchronously when a {@link io.papermc.paper.event.player.AsyncChatEvent chat event} is triggered, and can perform mutable operations on
 * the {@link ProcessedChat} such as cancel it or modify the content.
 *
 * @see ProcessedChat
 */
public interface ChatPreProcessor extends Consumer<ProcessedChat> {

}
