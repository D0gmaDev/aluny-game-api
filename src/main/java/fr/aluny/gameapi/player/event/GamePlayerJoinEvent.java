package fr.aluny.gameapi.player.event;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.player.PlayerAccount;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class GamePlayerJoinEvent extends PlayerEvent {

    private final GamePlayer gamePlayer;

    private final PlayerAccount playerAccount;

    private static HandlerList handlerList = new HandlerList();

    private boolean hidden = false;

    public GamePlayerJoinEvent(Player player, GamePlayer gamePlayer, PlayerAccount playerAccount) {
        super(player);
        this.gamePlayer = gamePlayer;
        this.playerAccount = playerAccount;
    }

    public GamePlayer getGamePlayer() {
        return this.gamePlayer;
    }

    public PlayerAccount getPlayerAccount() {
        return this.playerAccount;
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
