package fr.aluny.gameapi.player;

import fr.aluny.gameapi.player.rank.Rank;
import fr.aluny.gameapi.translation.Locale;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

public interface PlayerAccount {

    UUID getUuid();

    String getName();

    Locale getLocale();

    Set<Rank> getRanks();

    OffsetDateTime getCreationDate();

    Rank getHighestRank();

}
