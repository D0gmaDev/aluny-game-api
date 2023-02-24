package fr.aluny.gameapi.value;

import java.util.Objects;

public class ValueRestriction<T> {

    private final RestrictionType restrictionType;
    private final T               value;

    public ValueRestriction(RestrictionType restrictionType, T value) {
        this.restrictionType = restrictionType;
        this.value = value;
    }

    public boolean isType(RestrictionType type) {
        return getType() == type;
    }

    public RestrictionType getType() {
        return this.restrictionType;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isAppliableOn(GeneralValue<T> value) {
        if (isType(RestrictionType.LOCKED_VALUE))
            return !value.isLocked() || Objects.equals(getValue(), value.getValue());

        if (!(getValue() instanceof Number) || !(value instanceof NumericValue))
            return true;

        return isType(RestrictionType.MINIMAL_VALUE) && ((Number) getValue()).longValue() <= ((NumericValue<?>) value).getMaxValue().doubleValue() ||
                isType(RestrictionType.MAXIMAL_VALUE) && ((Number) getValue()).longValue() >= ((NumericValue<?>) value).getMinValue().doubleValue();
    }

    public enum RestrictionType {
        MINIMAL_VALUE,
        MAXIMAL_VALUE,
        LOCKED_VALUE
    }
}
