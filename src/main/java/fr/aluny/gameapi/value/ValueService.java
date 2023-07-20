package fr.aluny.gameapi.value;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface ValueService extends Service {

    <T extends Number & Comparable<T>> NumericValue<T> registerNumericValue(String key, String nameKey, String descriptionKey, T defaultValue, T minValue, T maxValue, T smallStep, T mediumStem, T largeStep);

    BooleanValue registerBooleanValue(String key, String nameKey, String trueDescriptionKey, String falseDescriptionKey, boolean defaultValue);

    TimeValue registerTimeValue(String key, String nameKey, String descriptionKey, long defaultValue, long minValue, long maxValue, long smallStep, long mediumStem, long largeStep, TimeUnit timeUnit);

    <T extends Enum<T>> EnumValue<T> registerEnumValue(String key, String nameKey, Class<T> enumerationClass, T defaultValue, String... descriptionKeys);

    StringValue registerStringValue(String key, String nameKey, String descriptionKey, String defaultValue, int minLength, int maxLength);

    <T extends Number & Comparable<T>> NumericValue<T> createNumericValue(String nameKey, String descriptionKey, T defaultValue, T minValue, T maxValue, T smallStep, T mediumStem, T largeStep);

    BooleanValue createBooleanValue(String nameKey, String trueDescriptionKey, String falseDescriptionKey, boolean defaultValue);

    TimeValue createTimeValue(String nameKey, String descriptionKey, long defaultValue, long minValue, long maxValue, long smallStep, long mediumStem, long largeStep, TimeUnit timeUnit);

    <T extends Enum<T>> EnumValue<T> createEnumValue(String nameKey, Class<T> enumerationClass, T defaultValue, String... descriptionKeys);

    StringValue createStringValue(String nameKey, String descriptionKey, String defaultValue, int minLength, int maxLength);

    <T extends Number & Comparable<T>> Optional<NumericValue<T>> getNumericValue(Class<T> numericType, String key);

    Optional<BooleanValue> getBooleanValue(String key);

    Optional<TimeValue> getTimeValue(String key);

    <T extends Enum<T>> Optional<EnumValue<T>> getEnumValue(Class<T> enumClass, String key);

    Optional<StringValue> getStringValue(String key);

    void removeValue(String key);

}
