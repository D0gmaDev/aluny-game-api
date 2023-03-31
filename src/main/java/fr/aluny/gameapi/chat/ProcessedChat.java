package fr.aluny.gameapi.chat;

import fr.aluny.gameapi.player.GamePlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProcessedChat {

    private String messageContent;

    private final GamePlayer        sender;
    private final Map<UUID, String> contentForPlayer = new HashMap<>();

    private boolean cancelled = false;

    public ProcessedChat(GamePlayer sender, String messageContent) {
        this.sender = sender;
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setContentForPlayer(UUID uuid, String message) {
        this.contentForPlayer.put(uuid, message);
    }

    public String getContentForPlayer(UUID uuid) {
        return this.contentForPlayer.getOrDefault(uuid, this.messageContent);
    }

    public GamePlayer getSender() {
        return this.sender;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
