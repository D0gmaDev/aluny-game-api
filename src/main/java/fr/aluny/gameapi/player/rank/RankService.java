package fr.aluny.gameapi.player.rank;

import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;

public interface RankService extends Service {

    /**
     * Gets every rank registered. The list is not sorted in any way.
     * The list is guaranteed to have no repetitions.
     *
     * @return an immutable list of the ranks.
     */
    List<Rank> getRanks();

    /**
     * Gets the rank with a specific id.
     *
     * @param id the unique id of the rank
     * @return a rank if such a rank exists.
     */
    Optional<Rank> getRankById(int id);

}
