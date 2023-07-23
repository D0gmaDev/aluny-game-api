package fr.aluny.gameapi.value;

import fr.aluny.gameapi.value.ValueRestriction.RestrictionType;

public interface Restrictible<T> {

    ValueRestriction<T> addRestriction(RestrictionType type, T value);

    void addRestriction(ValueRestriction<T> restriction);

    void removeRestriction(ValueRestriction<T> restriction);

    boolean canApply(ValueRestriction<T> restriction);

    boolean isLocked();

}
