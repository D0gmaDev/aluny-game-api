package fr.aluny.gameapi.scoreboard.team;

import fr.aluny.gameapi.service.Service;
import java.util.Optional;
import net.kyori.adventure.text.Component;

public interface ScoreboardTeamService extends Service {

    Optional<ScoreboardTeam> getScoreboardTeam(String name);

    ScoreboardTeam registerScoreboardTeam(String name, Component prefix);

    void deleteScoreboardTeam(ScoreboardTeam scoreboardTeam);

}
