package fr.aluny.gameapi.value;

public interface NumericValue<T extends Number> extends GeneralValue<T> {

    String getDescriptionKey();
    String getStringValue();

    T getMaxValue();
    T getMinValue();
    T getSmallStep();
    T getMediumStep();
    T getLargeStep();

    void smallIncrement();
    void mediumIncrement();
    void largeIncrement();
    void smallDecrement();
    void mediumDecrement();
    void largeDecrement();
}
