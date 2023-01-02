package fr.aluny.gameapi.player.rank;

import java.util.Set;

public interface Rank {

    int getId();

    String getName();

    int getImportanceIndex();

    String getPrefix();

    Set<String> getPermissions();

    boolean hasPermission(String permission);

    boolean isHigherOrEqualThan(Rank other);

}
