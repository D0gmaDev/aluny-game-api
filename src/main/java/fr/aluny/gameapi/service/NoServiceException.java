package fr.aluny.gameapi.service;

public class NoServiceException extends IllegalArgumentException {

    public NoServiceException(String service) {
        super("Service not found: " + service);
    }
}
