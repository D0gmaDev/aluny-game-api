package fr.aluny.gameapi.scoreboard.structure;

import java.util.List;

public interface ScoreboardStructure {

    String getTitle();

    List<ScoreboardLine> getLines();

}
