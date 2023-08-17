package fr.aluny.gameapi.inventory;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.inventoryaccess.component.AdventureComponentWrapper;
import xyz.xenondevs.inventoryaccess.component.ComponentWrapper;
import xyz.xenondevs.inventoryaccess.util.AdventureComponentUtils;

public class Translation implements ComponentWrapper {

    private final String      key;
    private final TagResolver tagResolver;

    private final Translation childTranslation;

    public Translation(String key, TagResolver... tagResolvers) {
        this.key = key;
        this.tagResolver = TagResolver.resolver(tagResolvers);
        this.childTranslation = null;
    }

    public Translation(String key, TagResolver tagResolver, Translation childTranslation) {
        this.key = key;
        this.tagResolver = tagResolver;
        this.childTranslation = childTranslation;
    }

    public Translation(String key, Translation childTranslation) {
        this.key = key;
        this.tagResolver = null;
        this.childTranslation = childTranslation;
    }

    public Translation(String key) {
        this.key = key;
        this.tagResolver = null;
        this.childTranslation = null;
    }

    @Override
    public @NotNull String serializeToJson() {
        throw new UnsupportedOperationException("translation cannot be serialized");
    }

    @Override
    public @NotNull AdventureComponentWrapper localized(@NotNull String lang) {
        return new AdventureComponentWrapper(AdventureComponentUtils.withoutPreFormatting(deepLocalized(lang)));
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

    private Component deepLocalized(String lang) {
        Component localizedComponent = MiniMessageLocalizer.localize(lang, key, tagResolver);
        return this.childTranslation != null ? localizedComponent.append(this.childTranslation.deepLocalized(lang)) : localizedComponent;
    }

}

