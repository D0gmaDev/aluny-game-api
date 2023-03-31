package fr.aluny.gameapi.inventory;

import de.studiocode.invui.gui.impl.PagedGUI;
import de.studiocode.invui.gui.structure.Markers;
import de.studiocode.invui.gui.structure.Structure;
import de.studiocode.invui.item.ItemProvider;
import de.studiocode.invui.item.builder.ItemBuilder;
import de.studiocode.invui.item.impl.controlitem.PageItem;
import org.bukkit.Material;

public class InventoryHelper {

    /**
     * This method should not be called outside of Game.
     */
    public static void load() {
        Structure.addGlobalIngredient('#', new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setDisplayName("§r"));

        Structure.addGlobalIngredient('<', BackItem::new);
        Structure.addGlobalIngredient('>', ForwardItem::new);

        Structure.addGlobalIngredient('x', Markers.ITEM_LIST_SLOT_HORIZONTAL);
    }

    public static class BackItem extends PageItem {

        public BackItem() {
            super(false);
        }

        @Override
        public ItemProvider getItemProvider(PagedGUI gui) {
            return new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§7Page précédente")
                    .addLoreLines(gui.hasPageBefore() ? "§7Aller à la page §e" + gui.getCurrentPageIndex() + "§7/§e" + gui.getPageAmount() : "§cVous êtes déjà à la première page");

        }

    }

    public static class ForwardItem extends PageItem {

        public ForwardItem() {
            super(true);
        }

        @Override
        public ItemProvider getItemProvider(PagedGUI gui) {
            return new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setDisplayName("§7Page suivante")
                    .addLoreLines(gui.hasNextPage() ? "§7Aller à la page §e" + (gui.getCurrentPageIndex() + 2) + "§7/§e" + gui.getPageAmount() : "§cVous êtes déjà à la dernière page");
        }

    }

}
