package fr.aluny.gameapi.world;

import fr.aluny.gameapi.service.Service;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

public interface LootModifierService extends Service {

    void register(ModifierPriority modifierPriority, Material blockType, LootModifier lootModifier);

    void register(ModifierPriority modifierPriority, Material blockType, LootModifier lootModifier, int expToDrop);

    void register(ModifierPriority modifierPriority, Material blockType, LootModifier lootModifier, int expToDrop, boolean allowBlockPlaced);

    void applyLootModifiers(BlockBreakEvent event);
}
