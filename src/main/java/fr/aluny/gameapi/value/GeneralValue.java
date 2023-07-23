package fr.aluny.gameapi.value;

public interface GeneralValue<T> extends Restrictible<T> {

    String getNameKey();

    T getValue();

    void setValue(T value);

    boolean isEdited();

    T getDefaultValue();

    void reset();

    IOnValueChanged<T> subscribeOnValueChanged(IOnValueChanged<T> onChanged);

    boolean unsubscribeOnValueChanged(IOnValueChanged<T> onChanged);

}
