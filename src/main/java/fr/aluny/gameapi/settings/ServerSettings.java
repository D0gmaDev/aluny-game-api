package fr.aluny.gameapi.settings;

public interface ServerSettings {

    boolean doesShowRank();

    void setShowRank(boolean show);

    boolean doesAllowSpectators();

    void setAllowSpectators(boolean allow);

}
