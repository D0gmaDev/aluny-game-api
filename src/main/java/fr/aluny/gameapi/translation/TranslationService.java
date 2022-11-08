package fr.aluny.gameapi.translation;

import fr.aluny.gameapi.player.PlayerBean;
import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;
import org.bukkit.plugin.java.JavaPlugin;

public interface TranslationService extends Service {

    void loadTranslations(JavaPlugin plugin, String code, String prefix);

    Optional<Locale> getLocale(String code);

    Locale getLocale(PlayerBean playerBean);

    Locale getDefaultLocale();

    List<Locale> getAllLocales();

    String getTranslation(String key, Locale locale);

    String getTranslation(String key, PlayerBean playerBean, String... args);

    String getTranslation(String key, PlayerBean playerBean);

    String getTranslation(String key, Locale locale, String... args);

}
