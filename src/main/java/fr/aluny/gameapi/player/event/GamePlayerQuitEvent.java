package fr.aluny.gameapi.player.event;

import fr.aluny.gameapi.player.GamePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class GamePlayerQuitEvent extends PlayerEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final GamePlayer gamePlayer;
    private final boolean    hidden;

    private boolean save;

    public GamePlayerQuitEvent(Player player, GamePlayer gamePlayer, boolean hidden) {
        super(player);
        this.player = player;
        this.gamePlayer = gamePlayer;
        this.hidden = hidden;
        this.save = !hidden;
    }

    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isSaved() {
        return this.save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
