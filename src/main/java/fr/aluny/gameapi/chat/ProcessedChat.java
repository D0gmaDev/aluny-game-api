package fr.aluny.gameapi.chat;

import fr.aluny.gameapi.player.GamePlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.UnaryOperator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

public class ProcessedChat {

    private TextComponent messageContent;

    private final GamePlayer           sender;
    private final Map<UUID, Component> contentForPlayer = new HashMap<>();

    private boolean cancelled = false;

    public ProcessedChat(GamePlayer sender, TextComponent messageContent) {
        this.sender = sender;
        this.messageContent = messageContent;
    }

    public TextComponent getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(UnaryOperator<TextComponent> operator) {
        this.messageContent = operator.apply(this.messageContent);
    }

    public void setMessageContentForPlayer(UUID uuid, Component message) {
        this.contentForPlayer.put(uuid, message);
    }

    public Component getMessageContentForPlayer(UUID uuid) {
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
