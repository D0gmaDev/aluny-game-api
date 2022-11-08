package fr.aluny.gameapi.value;

public interface StringValue extends GeneralValue<String> {

    String getDescriptionKey();

    int getMinLength();

    int getMaxLength();
}
