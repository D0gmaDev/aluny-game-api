package fr.aluny.gameapi.inventory;

import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Material;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.gui.structure.Markers;
import xyz.xenondevs.invui.gui.structure.Structure;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.controlitem.PageItem;

public class InventoryHelper {

    /**
     * This method should not be called outside of Game.
     */
    public static void load() {
        Structure.addGlobalIngredient('#', new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setDisplayName("§r"));

        Structure.addGlobalIngredient('<', BackItem::new);
        Structure.addGlobalIngredient('>', ForwardItem::new);

        Structure.addGlobalIngredient('x', Markers.CONTENT_LIST_SLOT_HORIZONTAL);
    }

    public static class BackItem extends PageItem {

        public BackItem() {
            super(false);
        }

        @Override
        public ItemProvider getItemProvider(PagedGui<?> gui) {
            return new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(new Translation("previous_page"))
                    .addLoreLines(gui.hasPreviousPage()
                            ? new Translation("go_to_page", Placeholder.unparsed("index", String.valueOf(gui.getCurrentPage())), Placeholder.unparsed("total", String.valueOf(gui.getPageAmount())))
                            : new Translation("no_previous_page"));

        }

    }

    public static class ForwardItem extends PageItem {

        public ForwardItem() {
            super(true);
        }

        @Override
        public ItemProvider getItemProvider(PagedGui<?> gui) {
            return new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName(new Translation("next_page"))
                    .addLoreLines(gui.hasNextPage()
                            ? new Translation("go_to_page", Placeholder.unparsed("index", String.valueOf(gui.getCurrentPage() + 2)), Placeholder.unparsed("total", String.valueOf(gui.getPageAmount())))
                            : new Translation("no_next_page"));
        }

    }

}
