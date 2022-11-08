package fr.aluny.gameapi.translation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Locale {


    private static final Random RANDOM = new Random();

    private final String              code;
    private final boolean             defaultLocale;
    private final Map<String, String> translations;

    private final TranslationService translationService;

    public Locale(String code, boolean defaultLocale, TranslationService translationService, Map<String, String> translations) {
        this.code = code;
        this.defaultLocale = defaultLocale;
        this.translations = translations;
        this.translationService = translationService;
    }

    public List<TranslationPair> getAllTranslationsStartingWith(String prefix) {
        List<TranslationPair> translations = new ArrayList<>();
        this.translations.forEach((s, s2) -> {
            if (s.startsWith(prefix))
                translations.add(new TranslationPair(s, s2));
        });

        return translations.stream().sorted(Comparator.comparing(TranslationPair::key)).collect(Collectors.toList());
    }

    public String getRandomTranslationsStartingWith(String prefix) {
        List<TranslationPair> list = getAllTranslationsStartingWith(prefix);
        if (list.isEmpty())
            return "Missing translation [" + prefix + "]";

        return list.get(RANDOM.nextInt(list.size())).value();
    }

    public String getRandomTranslationsStartingWith(String prefix, Object... arguments) {
        List<TranslationPair> list = getAllTranslationsStartingWith(prefix);
        if (list.isEmpty())
            return "Missing translation [" + prefix + "]";

        return String.format(list.get(RANDOM.nextInt(list.size())).value(), arguments);
    }

    public String translate(String key) {
        if (this.translations.containsKey(key))
            return this.translations.get(key);

        if (this.defaultLocale)
            return "Missing translation [" + key + "]";
        else
            return translationService.getDefaultLocale().translate(key);
    }

    public String translate(String key, Object... arguments) {
        if (this.translations.containsKey(key))
            return String.format(this.translations.get(key), arguments);

        if (this.defaultLocale)
            return "Missing translation [" + key + "]";
        else
            return translationService.getDefaultLocale().translate(key, arguments);
    }

    public String getCode() {
        return code;
    }

    public boolean isDefaultLocale() {
        return defaultLocale;
    }

    public record TranslationPair(String key, String value) {

    }
}
