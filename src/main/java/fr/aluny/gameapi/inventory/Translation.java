package fr.aluny.gameapi.inventory;

import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.inventoryaccess.component.AdventureComponentWrapper;
import xyz.xenondevs.inventoryaccess.component.ComponentWrapper;

public class Translation implements ComponentWrapper {

    private final String        key;
    private final TagResolver[] tagResolvers;

    public Translation(String key, TagResolver... tagResolvers) {
        this.key = key;
        this.tagResolvers = tagResolvers;
    }

    public Translation(String key, String... arguments) {
        this.key = key;

        this.tagResolvers = new TagResolver[arguments.length];

        for (int i = 0; i < arguments.length; i++) {
            this.tagResolvers[i] = Placeholder.unparsed("s" + (i + 1), arguments[i]);
        }
    }

    public Translation(String key) {
        this(key, new TagResolver[0]);
    }

    @Override
    public @NotNull String serializeToJson() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull AdventureComponentWrapper localized(@NotNull String lang) {
        return new AdventureComponentWrapper(MiniMessageLocalizer.getInstance().localize(lang, key, tagResolvers));
    }

    @Override
    public @NotNull ComponentWrapper withoutPreFormatting() {
        return this;
    }

    @Override
    public @NotNull Translation clone() {
        try {
            return (Translation) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}

