package fr.aluny.gameapi.translation;

import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * Represents a locale for a particular language, meaning key-value pairs of strings.
 */
public interface Locale {

    /**
     * Adds translations to the locale.
     *
     * @param translations a map of key-value pairs representing translations
     * @see TranslationService#loadTranslations
     */
    void addTranslations(Map<String, String> translations);

    /**
     * Returns the translation for the specified key.
     *
     * @param key the key to search for
     * @return the translation for the specified key
     */
    String translate(String key);

    /**
     * Returns the translation for the specified key and arguments.
     *
     * @param key the key to search for
     * @param arguments the tag resolvers to use for replacing placeholders in the message
     * @return the translation for the specified key
     */
    Component translateComponent(String key, TagResolver... arguments);

    /**
     * Returns whether this locale has a certain key registered.
     *
     * @param key the key to search for
     * @return whether the key exists in this locale
     */
    boolean hasTranslation(String key);

    /**
     * Returns the java {@link java.util.Locale} associated with
     * this locale.
     *
     * @return the java locale
     */
    java.util.Locale getJavaLocale();

    /**
     * Returns the code/tag for the locale.
     * Examples: {@code fr-FR}, {@code en-US}.
     *
     * @return the code for the locale
     */
    String getCode();

    /**
     * Returns whether this is the default locale.
     * The default locale is French.
     *
     * @return true if this is the default locale, false otherwise
     */
    boolean isDefaultLocale();

}
