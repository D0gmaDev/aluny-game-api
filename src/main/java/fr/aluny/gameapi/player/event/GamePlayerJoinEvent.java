package fr.aluny.gameapi.player.event;

import fr.aluny.gameapi.player.GamePlayer;
import fr.aluny.gameapi.player.PlayerAccount;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class GamePlayerJoinEvent extends PlayerEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final GamePlayer    gamePlayer;
    private final PlayerAccount playerAccount;
    private final boolean       hidden;

    public GamePlayerJoinEvent(Player player, GamePlayer gamePlayer, PlayerAccount playerAccount, boolean hidden) {
        super(player);
        this.gamePlayer = gamePlayer;
        this.playerAccount = playerAccount;
        this.hidden = hidden;
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

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
