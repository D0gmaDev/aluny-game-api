package fr.aluny.gameapi.value;


import fr.aluny.gameapi.value.ValueRestriction.RestrictionType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ValueRestrictionMap extends HashMap<GeneralValue<?>, ValueRestriction<?>[]> {

    public <T> ValueRestrictionMap addRestriction(GeneralValue<?> generalValue, RestrictionType type, T value) {
        ValueRestriction<T> restriction = new ValueRestriction<>(type, value);

        ValueRestriction<?>[] restrictions;
        if (containsKey(generalValue)) {
            List<ValueRestriction<?>> oldRestrictions = Arrays.asList(get(generalValue));
            oldRestrictions.add(restriction);
            restrictions = oldRestrictions.toArray(new ValueRestriction<?>[]{ });
        } else {
            restrictions = new ValueRestriction<?>[]{restriction};
        }

        put(generalValue, restrictions);
        return this;
    }

    public ValueRestrictionMap addRestriction(GeneralValue<?> generalValue, ValueRestriction<?>... valueRestrictions) {
        ValueRestriction<?>[] restrictions;
        if (containsKey(generalValue)) {
            List<ValueRestriction<?>> oldRestrictions = Arrays.asList(get(generalValue));
            oldRestrictions.addAll(Arrays.stream(valueRestrictions).collect(Collectors.toList()));
            restrictions = oldRestrictions.toArray(new ValueRestriction<?>[]{ });
        } else {
            restrictions = valueRestrictions;
        }

        put(generalValue, restrictions);
        return this;
    }
}
