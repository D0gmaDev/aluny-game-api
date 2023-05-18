package fr.aluny.gameapi.value;

import fr.aluny.gameapi.value.ValueRestriction.RestrictionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValueRestrictionMap extends HashMap<GeneralValue<?>, List<ValueRestriction<?>>> {

    public static <T> ValueRestrictionMap of(GeneralValue<?> generalValue, RestrictionType type, T value) {
        ValueRestrictionMap valueRestrictionMap = new ValueRestrictionMap();
        valueRestrictionMap.addRestriction(generalValue, type, value);
        return valueRestrictionMap;
    }

    public <T> void addRestriction(GeneralValue<?> generalValue, RestrictionType type, T value) {
        List<ValueRestriction<?>> valueRestrictions = containsKey(generalValue) ? get(generalValue) : new ArrayList<>(3);

        valueRestrictions.add(new ValueRestriction<>(type, value));

        if (!containsKey(generalValue))
            put(generalValue, valueRestrictions);
    }

    public void addRestriction(GeneralValue<?> generalValue, ValueRestriction<?>... valueRestrictions) {
        List<ValueRestriction<?>> restrictionList = containsKey(generalValue) ? get(generalValue) : new ArrayList<>(valueRestrictions.length);

        restrictionList.addAll(Arrays.asList(valueRestrictions));

        if (!containsKey(generalValue))
            put(generalValue, restrictionList);
    }
}
