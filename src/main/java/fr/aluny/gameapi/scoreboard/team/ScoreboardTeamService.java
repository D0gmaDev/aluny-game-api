package fr.aluny.gameapi.scoreboard.team;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;

public interface ScoreboardTeamService extends Service {

    Optional<ScoreboardTeam> getScoreboardTeam(String name);

    ScoreboardTeam registerScoreboardTeam(String name, String prefix);

    void deleteScoreboardTeam(ScoreboardTeam scoreboardTeam);

}
