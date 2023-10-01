package fr.aluny.gameapi.utils;

import fr.aluny.gameapi.inventory.Translation;
import fr.aluny.gameapi.value.BooleanValue;
import fr.aluny.gameapi.value.EnumValue;
import fr.aluny.gameapi.value.NumericValue;
import fr.aluny.gameapi.value.StringValue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.xenondevs.inventoryaccess.component.ComponentWrapper;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.Click;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.item.impl.SuppliedItem;
import xyz.xenondevs.invui.window.AnvilWindow;
import xyz.xenondevs.invui.window.Window;

public class ItemUtils {

    public static Item getBooleanValueItem(BooleanValue booleanValue, Material icon) {
        return new BooleanValueItem(booleanValue, icon);
    }

    public static Item getStringValueItem(StringValue stringValue, Material icon, Consumer<Player> returnConsumer) {
        return new StringValueItem(stringValue, icon, returnConsumer);
    }

    public static Item getEnumValueItem(EnumValue<?> enumValue, Material icon, String selectedKey, String unselectedKey) {
        return new EnumValueItem<>(enumValue, icon, selectedKey, unselectedKey);
    }

    public static Item getNumericValueItem(NumericValue<?> numericValue, Material icon, Consumer<Player> returnConsumer) {
        return new NumericValueItem(numericValue, icon, returnConsumer);
    }

    private static class BooleanValueItem extends SuppliedItem {

        public BooleanValueItem(BooleanValue booleanValue, Material icon) {
            super(() -> new ItemBuilder(icon).setDisplayName(new Translation(booleanValue.getNameKey())).addLoreLines(new Translation(booleanValue.getDescriptionKey())), click -> {
                booleanValue.toggle();
                return true;
            });
        }
    }

    private static class EnumValueItem<T extends Enum<T>> extends SuppliedItem {

        public EnumValueItem(EnumValue<T> enumValue, Material icon, String selectedKey, String unselectedKey) {
            super(() -> enumItem(enumValue, icon, selectedKey, unselectedKey), enumClick(enumValue));
        }

        private static ItemProvider enumItem(EnumValue<?> enumValue, Material icon, String selectedKey, String unselectedKey) {
            ItemBuilder itemBuilder = new ItemBuilder(icon).setDisplayName(new Translation(enumValue.getNameKey()));

            return IntStream.range(0, enumValue.getEnumeration().length)
                    .mapToObj(i -> new Translation(enumValue.getValueIndex() == i ? selectedKey : unselectedKey, new Translation(enumValue.getDescriptionKeys()[i])))
                    .collect(Collectors.collectingAndThen(Collectors.<ComponentWrapper>toList(), itemBuilder::setLore));
        }

        private static Function<Click, Boolean> enumClick(EnumValue<?> enumValue) {
            return click -> {
                if (click.getClickType().isLeftClick())
                    enumValue.increment();
                else if (click.getClickType().isRightClick())
                    enumValue.decrement();
                return true;
            };
        }
    }

    private static class StringValueItem extends SimpleItem {

        public StringValueItem(StringValue stringValue, Material icon, Consumer<Player> returnConsumer) {
            super(stringItem(stringValue, icon), click -> stringClick(stringValue, icon, click.getPlayer(), () -> returnConsumer.accept(click.getPlayer())));
        }

        private static ItemProvider stringItem(StringValue stringValue, Material icon) {
            return new ItemBuilder(icon).setDisplayName(new Translation(stringValue.getNameKey()))
                    .addLoreLines(new Translation(stringValue.getDescriptionKey(), Placeholder.unparsed("value", stringValue.getValue())));
        }

        private static void stringClick(StringValue stringValue, Material icon, Player player, Runnable returnRunnable) {
            Gui gui = Gui.normal().setStructure("p.q")
                    .addIngredient('p', new ItemBuilder(icon).setDisplayName(stringValue.getValue()))
                    .addIngredient('q', new SimpleItem(new ItemBuilder(Material.LIME_DYE).setDisplayName("Quit"), click -> click.getPlayer().closeInventory()))
                    .build();

            AnvilWindow.single().setTitle(new Translation(stringValue.getNameKey())).setGui(gui)
                    .addRenameHandler(stringValue::setValue)
                    .addCloseHandler(returnRunnable)
                    .open(player);
        }
    }

    private static class NumericValueItem extends SimpleItem {

        public NumericValueItem(NumericValue<?> numericValue, Material icon, Consumer<Player> returnConsumer) {
            super(numericItem(numericValue, icon), click -> numericClick(numericValue, icon, click.getPlayer(), () -> returnConsumer.accept(click.getPlayer())));
        }

        private static ItemProvider numericItem(NumericValue<?> numericValue, Material icon) {
            return new ItemBuilder(icon).setDisplayName(new Translation(numericValue.getNameKey()))
                    .addLoreLines(new Translation(numericValue.getDescriptionKey(), Placeholder.unparsed("value", numericValue.getStringValue())));
        }

        private static void numericClick(NumericValue<?> numericValue, Material icon, Player player, Runnable returnRunnable) {
            Gui gui = Gui.normal().setStructure("6 5 4 . i . 1 2 3")
                    .addIngredient('i', new ItemBuilder(icon).setDisplayName(numericValue.getStringValue()))
                    .addIngredient('6', numericItem("-" + numericValue.getLargeStep().toString(), numericValue::largeDecrement))
                    .addIngredient('5', numericItem("-" + numericValue.getMediumStep().toString(), numericValue::mediumDecrement))
                    .addIngredient('4', numericItem("-" + numericValue.getSmallStep().toString(), numericValue::smallDecrement))
                    .addIngredient('1', numericItem("+" + numericValue.getSmallStep().toString(), numericValue::smallIncrement))
                    .addIngredient('2', numericItem("+" + numericValue.getMediumStep().toString(), numericValue::mediumIncrement))
                    .addIngredient('3', numericItem("+" + numericValue.getLargeStep().toString(), numericValue::largeIncrement))
                    .build();

            Window.single().setTitle(new Translation(numericValue.getNameKey())).setGui(gui)
                    .addCloseHandler(returnRunnable)
                    .open(player);
        }

        private static Item numericItem(String name, Runnable clickRunnable) {
            return new SimpleItem(new ItemBuilder(Material.DARK_OAK_BUTTON).setDisplayName(name), click -> clickRunnable.run());
        }
    }

}
