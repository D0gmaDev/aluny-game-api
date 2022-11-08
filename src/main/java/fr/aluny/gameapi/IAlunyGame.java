package fr.aluny.gameapi;

import fr.aluny.gameapi.service.ServiceManager;
import fr.aluny.gameapi.settings.ServerSettings;

public interface IAlunyGame {

    ServiceManager getServiceManager();

    ServerSettings getServerSettings();

}
