package fr.aluny.gameapi.value;

@FunctionalInterface
public interface IOnValueChanged<T> {

    void valueChanged(T oldValue, T newValue);
}
