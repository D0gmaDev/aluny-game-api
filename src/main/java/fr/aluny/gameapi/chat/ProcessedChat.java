package fr.aluny.gameapi.chat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;

public class ProcessedChat {

    private Player sender;
    private String globalMessage;
    private Map<UUID, String> messageByPlayer = new HashMap<>();
    private boolean cancelled = false;

    public ProcessedChat(Player sender, String globalMessage) {
        this.sender = sender;
        this.globalMessage = globalMessage;
    }

    public String getGlobalMessage() {
        return this.globalMessage;
    }

    public void setGlobalMessage(String globalMessage) {
        this.globalMessage = globalMessage;
    }

    public Map<UUID, String> getMessageByPlayer() {
        return this.messageByPlayer;
    }

    public void addMessageByPlayer(UUID uuid, String message) {
        this.messageByPlayer.put(uuid, message);
    }

    public Player getSender() {
        return this.sender;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
