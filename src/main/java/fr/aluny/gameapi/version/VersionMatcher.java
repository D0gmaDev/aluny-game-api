package fr.aluny.gameapi.version;

public class VersionMatcher {

    private static VersionWrapper wrapper;

    public static VersionWrapper getWrapper() {
        return wrapper;
    }

    public static void setWrapper(VersionWrapper wrapper) {
        VersionMatcher.wrapper = wrapper;
    }
}
