package fr.aluny.gameapi.item;

import fr.aluny.gameapi.player.GamePlayer;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface InteractAction {

    void accept(GamePlayer gamePlayer, Action action, ItemStack itemStack);

}
