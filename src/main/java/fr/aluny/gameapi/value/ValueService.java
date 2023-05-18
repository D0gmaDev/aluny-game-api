package fr.aluny.gameapi.value;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface ValueService extends Service {

    <T extends Number> NumericValue<T> createNumericValue(String key, String nameKey, String descriptionKey, T defaultValue, T minValue, T maxValue, T smallStep, T mediumStem, T largeStep);

    BooleanValue createBooleanValue(String key, String nameKey, String trueDescriptionKey, String falseDescriptionKey, boolean defaultValue);

    TimeValue createTimeValue(String key, String nameKey, String descriptionKey, long defaultValue, long minValue, long maxValue, long smallStep, long mediumStem, long largeStep, TimeUnit timeUnit);

    <T extends Enum<T>> EnumValue<T> createEnumValue(String key, String nameKey, Class<T> enumerationClass, T defaultValue, String... descriptionKeys);

    StringValue createStringValue(String key, String nameKey, String descriptionKey, String defaultValue, int minLength, int maxLength);

    <T extends Number> NumericValue<T> createUnregisteredNumericValue(String nameKey, String descriptionKey, T defaultValue, T minValue, T maxValue, T smallStep, T mediumStem, T largeStep);

    BooleanValue createUnregisteredBooleanValue(String nameKey, String trueDescriptionKey, String falseDescriptionKey, boolean defaultValue);

    TimeValue createUnregisteredTimeValue(String nameKey, String descriptionKey, long defaultValue, long minValue, long maxValue, long smallStep, long mediumStem, long largeStep, TimeUnit timeUnit);

    <T extends Enum<T>> EnumValue<T> createUnregisteredEnumValue(String nameKey, Class<T> enumerationClass, T defaultValue, String... descriptionKeys);

    StringValue createUnregisteredStringValue(String nameKey, String descriptionKey, String defaultValue, int minLength, int maxLength);

    <T extends Number> Optional<NumericValue<T>> getNumericValue(String key);

    Optional<BooleanValue> getBooleanValue(String key);

    Optional<TimeValue> getTimeValue(String key);

    <T extends Enum<T>> Optional<EnumValue<T>> getEnumValue(String key);

    Optional<StringValue> getStringValue(String key);

    void removeValue(String key);

}
