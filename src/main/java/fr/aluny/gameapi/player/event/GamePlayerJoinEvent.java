package fr.aluny.gameapi.player.event;

import fr.aluny.gameapi.player.GamePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class GamePlayerJoinEvent extends PlayerEvent {

    private final GamePlayer gamePlayer;

    private static HandlerList handlerList = new HandlerList();

    private boolean hidden = false;

    public GamePlayerJoinEvent(Player player, GamePlayer gamePlayer) {
        super(player);
        this.player = player;
        this.gamePlayer = gamePlayer;
    }

    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
