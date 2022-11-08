package fr.aluny.gameapi.value;

public interface EnumValue<T extends Enum<T>> extends GeneralValue<T> {

    void increment();

    void decrement();

    String getSelectedDescriptionKey();

    int getValueIndex();

    String[] getDescriptionKeys();

    T[] getEnumeration();

    void setIndexValue(int index);

    int getDefaultValueIndex();
}
