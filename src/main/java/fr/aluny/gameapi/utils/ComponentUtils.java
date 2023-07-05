package fr.aluny.gameapi.utils;

import fr.aluny.gameapi.player.PlayerAccount;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * Reduces boilerplate of tag resolvers thanks to static import and commonly used placeholders
 */
public class ComponentUtils {

    private static final String ARGUMENT_KEY = "arg";
    private static final String ID_KEY       = "id";
    private static final String NAME_KEY     = "name";

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

}
