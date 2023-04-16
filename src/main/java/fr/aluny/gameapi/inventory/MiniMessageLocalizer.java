package fr.aluny.gameapi.inventory;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import xyz.xenondevs.inventoryaccess.component.i18n.Languages;
import xyz.xenondevs.inventoryaccess.util.AdventureComponentUtils;

public class MiniMessageLocalizer {

    private static final MiniMessageLocalizer INSTANCE = new MiniMessageLocalizer();

    private MiniMessage miniMessageParser = MiniMessage.miniMessage();

    private MiniMessageLocalizer() {
    }

    public static MiniMessageLocalizer getInstance() {
        return INSTANCE;
    }

    public Component localize(String lang, String key, TagResolver... resolvers) {
        var formatString = Languages.getInstance().getFormatString(lang, key);
        if (formatString == null)
            return Component.empty();

        return AdventureComponentUtils.withoutPreFormatting(miniMessageParser.deserialize(formatString, resolvers));
    }

    public void setMiniMessageParser(MiniMessage miniMessageParser) {
        this.miniMessageParser = miniMessageParser;
    }
}
