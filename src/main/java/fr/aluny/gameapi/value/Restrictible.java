package fr.aluny.gameapi.value;

import fr.aluny.gameapi.value.ValueRestriction.RestrictionType;

public interface Restrictible<T> {

    void addRestriction(String key, RestrictionType type, T value);

    void addRestriction(String key, ValueRestriction<T> restriction);

    void removeRestriction(String key);

    boolean isLocked();

}
