package fr.aluny.gameapi.translation;

import fr.aluny.gameapi.player.PlayerAccount;
import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Represents a service for managing translations.
 */
public interface TranslationService extends Service {

    /**
     * Loads translations for the specified plugin and locale. This method should
     * only be called once for each plugin and each locale.
     *
     * @param plugin the plugin to load translations for
     * @param javaLocale the java locale to load translations for
     * @param filePath the file path to load the translations from
     */
    void loadTranslations(JavaPlugin plugin, java.util.Locale javaLocale, String filePath);

    /**
     * Loads translations for the specified plugin and locale code. This method should
     * only be called once for each plugin and each locale.
     *
     * @param plugin the plugin to load translations for
     * @param code the locale code to load translations for
     * @param filePath the file path to load the translations from
     * @deprecated use a java locale instead of a code
     */
    @Deprecated
    default void loadTranslations(JavaPlugin plugin, String code, String filePath) {
        loadTranslations(plugin, java.util.Locale.forLanguageTag(code), filePath);
    }

    /**
     * Loads translations for the specified plugin by looping over every {@code .properties}
     * file directly in this directory. This method should only be called once for each plugin.
     *
     * @param plugin the plugin to load translations for
     * @param directoryPath the directory path to load the translations files from
     * @deprecated not yet implemented, will do nothing
     */
    @Deprecated
    void loadTranslationsFromDirectory(JavaPlugin plugin, String directoryPath);

    /**
     * Returns an optional locale with the specified code,
     * empty if no locale with matching code exists.
     *
     * @param locale the locale to retrieve
     * @return an optional locale with the specified code
     */
    Optional<Locale> getLocale(java.util.Locale locale);

    /**
     * Returns an optional locale with the specified code,
     * empty if no locale with matching code exists.
     *
     * @param code the code for the locale to retrieve
     * @return an optional locale with the specified code
     * @deprecated use a java locale instead of a code
     */
    @Deprecated
    default Optional<Locale> getLocale(String code) {
        return getLocale(java.util.Locale.forLanguageTag(code));
    }

    /**
     * Returns the default locale.
     * The default locale is French, associated to {@code java.util.Locale.FRANCE}.
     *
     * @return the default locale
     */
    Locale getDefaultLocale();

    /**
     * Returns an immutable list of all available locales.
     *
     * @return a list of all locales
     */
    List<Locale> getAllLocales();

    /**
     * Returns the translation for the specified key and locale.
     *
     * @param key the key for the translation
     * @param locale the locale for the translation
     * @return the translation for the specified key and locale
     * @see Locale#translate(String)
     */
    String getTranslation(String key, Locale locale);

    /**
     * Returns the translation for the specified key and player account.
     *
     * @param key the key for the translation
     * @param playerAccount the player account for the translation
     * @return the translation for the specified key and player account
     * @see Locale#translate(String)
     */
    String getTranslation(String key, PlayerAccount playerAccount);

    /**
     * Returns the translation for the specified key and locale.
     *
     * @param key the key for the translation
     * @param locale the locale for the translation
     * @param arguments the tag resolvers to use for replacing placeholders in the message
     * @return the translation for the specified key and locale
     * @see Locale#translateComponent(String, TagResolver...)
     */
    Component getComponentTranslation(String key, Locale locale, TagResolver... arguments);

    /**
     * Returns the translation for the specified key and player account.
     *
     * @param key the key for the translation
     * @param playerAccount the player account for the translation
     * @param arguments the tag resolvers to use for replacing placeholders in the message
     * @return the translation for the specified key and player account
     * @see Locale#translateComponent(String, TagResolver...)
     */
    Component getComponentTranslation(String key, PlayerAccount playerAccount, TagResolver... arguments);

}
