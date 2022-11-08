package fr.aluny.gameapi.anchor;

import fr.aluny.gameapi.service.Service;
import java.util.List;
import java.util.Optional;
import org.bukkit.World;

public interface AnchorService extends Service {

    void initializeWorld(World world);

    void unregisterWorld(World world);

    Optional<Anchor> findOne(String key);

    List<Anchor> findMany(String key);

    List<Anchor> findAll();

}
