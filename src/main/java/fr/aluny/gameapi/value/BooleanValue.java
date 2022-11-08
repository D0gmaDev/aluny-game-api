package fr.aluny.gameapi.value;

public interface BooleanValue extends GeneralValue<Boolean> {

    String getDescriptionKey();

    boolean getBooleanValue();

    void toggle();
}
