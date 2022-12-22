package fr.aluny.gameapi.player.event;

import fr.aluny.gameapi.player.GamePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class GamePlayerQuitEvent extends PlayerEvent {

    private final GamePlayer gamePlayer;

    private static HandlerList handlerList = new HandlerList();

    private boolean hidden = false;
    private boolean save   = true;

    public GamePlayerQuitEvent(Player player, GamePlayer gamePlayer) {
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

    public boolean isSaved() {
        return this.save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
