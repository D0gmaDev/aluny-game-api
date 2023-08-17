package fr.aluny.gameapi.utils;

import static java.util.Map.entry;

import fr.aluny.gameapi.player.PlayerAccount;
import java.util.Map;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.DyeColor;

public class ComponentUtils {

    private static final String ARGUMENT_KEY = "arg";
    private static final String ID_KEY       = "id";
    private static final String NAME_KEY     = "name";

    private static final Map<NamedTextColor, DyeColor> NAMED_TEXT_COLOR_DYE_COLOR_MAP = Map.ofEntries(
            entry(NamedTextColor.RED, DyeColor.RED),
            entry(NamedTextColor.YELLOW, DyeColor.YELLOW),
            entry(NamedTextColor.GOLD, DyeColor.ORANGE),
            entry(NamedTextColor.GREEN, DyeColor.LIME),
            entry(NamedTextColor.DARK_GREEN, DyeColor.GREEN),
            entry(NamedTextColor.DARK_AQUA, DyeColor.CYAN),
            entry(NamedTextColor.DARK_BLUE, DyeColor.BLUE),
            entry(NamedTextColor.BLUE, DyeColor.LIGHT_BLUE),
            entry(NamedTextColor.AQUA, DyeColor.LIGHT_BLUE),
            entry(NamedTextColor.LIGHT_PURPLE, DyeColor.PINK),
            entry(NamedTextColor.DARK_PURPLE, DyeColor.PURPLE),
            entry(NamedTextColor.DARK_RED, DyeColor.RED),
            entry(NamedTextColor.DARK_GRAY, DyeColor.GRAY),
            entry(NamedTextColor.GRAY, DyeColor.LIGHT_GRAY),
            entry(NamedTextColor.WHITE, DyeColor.WHITE),
            entry(NamedTextColor.BLACK, DyeColor.BLACK)
    );

    public static TagResolver argument(String argument) {
        return Placeholder.unparsed(ARGUMENT_KEY, argument);
    }

    public static TagResolver id(int id) {
        return Placeholder.unparsed(ID_KEY, String.valueOf(id));
    }

    public static TagResolver name(String name) {
        return Placeholder.unparsed(NAME_KEY, name);
    }

    public static TagResolver name(PlayerAccount account) {
        return Placeholder.unparsed(NAME_KEY, account.getName());
    }

    public static DyeColor getDyeColor(NamedTextColor namedTextColor) {
        return NAMED_TEXT_COLOR_DYE_COLOR_MAP.get(namedTextColor);
    }

}
