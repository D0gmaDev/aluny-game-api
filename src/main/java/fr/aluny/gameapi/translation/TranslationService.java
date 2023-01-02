package fr.aluny.gameapi.translation;

import fr.aluny.gameapi.player.PlayerAccount;
import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;
import org.bukkit.plugin.java.JavaPlugin;

public interface TranslationService extends Service {

    void loadTranslations(JavaPlugin plugin, String code, String prefix);

    Optional<Locale> getLocale(String code);

    Locale getDefaultLocale();

    List<Locale> getAllLocales();

    String getTranslation(String key, Locale locale);

    String getTranslation(String key, PlayerAccount playerAccount, String... args);

    String getTranslation(String key, PlayerAccount playerAccount);

    String getTranslation(String key, Locale locale, String... args);

}
