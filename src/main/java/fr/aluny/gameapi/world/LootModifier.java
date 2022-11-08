package fr.aluny.gameapi.world;

import java.util.function.Consumer;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface LootModifier extends Consumer<ItemStack> {


}
