package fr.aluny.gameapi.chat;

import java.util.function.Consumer;

/**
 * A PreProcessor is called after every {@link ChatPreProcessor pre-processors}, and has
 * the responsibility to send the message to the relevant users.
 *
 * @see ProcessedChat
 */
public interface ChatProcessor extends Consumer<ProcessedChat> {

}
