package fr.aluny.gameapi.inventory;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import xyz.xenondevs.inventoryaccess.component.i18n.Languages;
import xyz.xenondevs.inventoryaccess.util.AdventureComponentUtils;

public class MiniMessageLocalizer {

    private static MiniMessage miniMessageParser = MiniMessage.miniMessage();

    public static Component localize(String lang, String key, TagResolver resolver) {
        String formatString = Languages.getInstance().getFormatString(lang, key);
        if (formatString == null)
            return Component.text("Missing Translation [" + key + ']');

        return resolver != null ? miniMessageParser.deserialize(formatString, resolver) : miniMessageParser.deserialize(formatString);
    }

    public static Component localizeWithoutPreFormatting(String lang, String key, TagResolver resolver) {
        return AdventureComponentUtils.withoutPreFormatting(localize(lang, key, resolver));
    }

    public static void setMiniMessageParser(MiniMessage parser) {
        miniMessageParser = parser;
    }
}
