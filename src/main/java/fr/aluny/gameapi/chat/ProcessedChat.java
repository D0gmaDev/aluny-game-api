package fr.aluny.gameapi.chat;

import fr.aluny.gameapi.player.GamePlayer;
import io.papermc.paper.chat.ChatRenderer;
import java.util.Set;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;

public final class ProcessedChat {

    private final GamePlayer    sender;
    private final Set<Audience> audience;

    private Component    message;
    private ChatRenderer chatRenderer = ChatRenderer.defaultRenderer();

    private boolean cancelled = false;

    public ProcessedChat(GamePlayer sender, Set<Audience> audience, Component message) {
        this.sender = sender;
        this.audience = audience;
        this.message = message;
    }

    public GamePlayer getSender() {
        return sender;
    }

    public Set<Audience> getAudience() {
        return audience;
    }

    public Component getMessage() {
        return message;
    }

    public void setMessage(Component message) {
        this.message = message;
    }

    public ChatRenderer getRenderer() {
        return chatRenderer;
    }

    public void setRenderer(ChatRenderer chatRenderer) {
        this.chatRenderer = chatRenderer;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
