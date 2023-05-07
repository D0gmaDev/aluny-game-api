package fr.aluny.gameapi.translation;

import fr.aluny.gameapi.player.PlayerAccount;
import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Represents a service for managing translations.
 */
public interface TranslationService extends Service {

    /**
     * Loads translations for the specified plugin and locale code. This method should
     * only be called once for each plugin and each locale.
     *
     * @param plugin the plugin to load translations for
     * @param code the locale code to load translations for
     * @param file the file name to load the translations from
     */
    void loadTranslations(JavaPlugin plugin, String code, String file);

    /**
     * Returns an optional locale with the specified code,
     * empty if no locale with matching code exists.
     *
     * @param code the code for the locale to retrieve
     * @return an optional locale with the specified code
     */
    Optional<Locale> getLocale(String code);

    /**
     * Returns the default locale.
     * The default locale is French.
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
     * Returns the translation for the specified key and player account, formatted with the specified arguments.
     *
     * @param key the key for the translation
     * @param playerAccount the player account for the translation
     * @param args the arguments to include in the translation
     * @return the translation for the specified key and player account, formatted with the specified arguments
     * @see Locale#translate(String, Object...)
     */
    String getTranslation(String key, PlayerAccount playerAccount, String... args);

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
     * Returns the translation for the specified key, locale, and arguments.
     *
     * @param key the key for the translation
     * @param locale the locale for the translation
     * @param args the arguments to include in the translation
     * @return the translation for the specified key, locale, and arguments
     * @see Locale#translate(String, Object...)
     */
    String getTranslation(String key, Locale locale, String... args);

}
