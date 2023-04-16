package fr.aluny.gameapi.translation;

import java.util.List;
import java.util.Map;

public interface Locale {

    void addTranslations(Map<String, String> translations);

    List<TranslationPair> getAllTranslationsStartingWith(String prefix);

    String getRandomTranslationsStartingWith(String prefix);

    String getRandomTranslationsStartingWith(String prefix, Object... arguments);

    String translate(String key);

    String translate(String key, Object... arguments);

    String getCode();

    boolean isDefaultLocale();

    record TranslationPair(String key, String value) {

    }
}
