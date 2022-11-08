package fr.aluny.gameapi.chat;

public interface ChatPreProcessor {

    ProcessedChat accept(ProcessedChat event);

}
