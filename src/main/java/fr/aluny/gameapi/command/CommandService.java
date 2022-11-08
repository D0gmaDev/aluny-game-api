package fr.aluny.gameapi.command;

import fr.aluny.gameapi.service.Service;

public interface CommandService extends Service {

    void registerRuntimeCommand(Command command);

    void unRegisterRuntimeCommand(String commandName);

    boolean isAlreadyRegistered(String command);

}
