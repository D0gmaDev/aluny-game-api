package fr.aluny.gameapi.moderation;

import fr.aluny.gameapi.service.Service;
import java.time.OffsetDateTime;
import java.util.UUID;

public interface ModerationService extends Service {

    boolean isMuted(UUID uuid);

    OffsetDateTime getUnMuteDate(UUID uuid);

}
