package fr.aluny.gameapi.player.rank;

import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;

public interface RankService extends Service {

    List<Rank> getRanks();

    Optional<Rank> getRankById(int id);

}
