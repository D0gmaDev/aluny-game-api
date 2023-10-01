package fr.aluny.gameapi.item;

import fr.aluny.gameapi.service.Service;
import org.bukkit.inventory.ItemStack;

public interface ItemService extends Service {

    void registerInteractAction(String key, InteractAction action);

    void unregisterInteractAction(String key);

    ItemStack actionItem(ItemStack itemStack, String key);

}
