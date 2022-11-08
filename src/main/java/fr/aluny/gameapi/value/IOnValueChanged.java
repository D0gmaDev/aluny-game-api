package fr.aluny.gameapi.value;

public interface IOnValueChanged<T> {
    void valueChanged(T oldValue, T newValue);
}
