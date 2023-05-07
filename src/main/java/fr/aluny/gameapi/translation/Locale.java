package fr.aluny.gameapi.translation;

import java.util.List;
import java.util.Map;

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
     * Returns a list of translation pairs whose keys start with the specified prefix.
     *
     * @param prefix the prefix to search for
     * @return a list of translation pairs whose keys start with the prefix
     */
    List<TranslationPair> getAllTranslationsStartingWith(String prefix);

    /**
     * Returns a random translation whose key starts with the specified prefix.
     * This operation can be heavy.
     *
     * @param prefix the prefix to search for
     * @return a random translation whose key starts with the prefix
     */
    String getRandomTranslationsStartingWith(String prefix);

    /**
     * Returns a random translation whose key starts with the specified prefix, formatted with the specified arguments.
     * This operation can be heavy.
     *
     * @param prefix the prefix to search for
     * @param arguments the arguments to include in the translation
     * @return a random translation whose key starts with the prefix
     */
    String getRandomTranslationsStartingWith(String prefix, Object... arguments);

    /**
     * Returns the translation for the specified key.
     *
     * @param key the key to search for
     * @return the translation for the specified key
     */
    String translate(String key);

    /**
     * Returns the translation for the specified key, formatted with the specified arguments.
     *
     * @param key the key to search for
     * @param arguments the arguments to include in the translation
     * @return the translation for the specified key
     */
    String translate(String key, Object... arguments);

    /**
     * Returns the code for the locale.
     * Examples: {@code fr-fr}, {@code en-us}.
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

    /**
     * Represents a key-value pair for a translation.
     */
    record TranslationPair(String key, String value) {

    }
}
