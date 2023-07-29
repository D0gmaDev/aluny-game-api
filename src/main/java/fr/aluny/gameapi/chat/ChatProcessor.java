package fr.aluny.gameapi.chat;

import java.util.function.Consumer;

/**
 * A PreProcessor is called after every {@link ChatPreProcessor pre-processors}, and has
 * the responsibility to handle the audience and the rendering of a message.
 *
 * @see ProcessedChat
 */
public interface ChatProcessor extends Consumer<ProcessedChat> {

}
