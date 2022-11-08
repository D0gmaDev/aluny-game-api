package fr.aluny.gameapi.world;

import fr.aluny.gameapi.service.Service;
import java.io.InputStream;
import org.bukkit.plugin.Plugin;

public interface SchematicService extends Service {

    Schematic loadSchematic(String name, Plugin plugin);

    Schematic loadSchematic(InputStream inputStream);

    InputStream getSchematicFromRessources(String name, Plugin plugin);
}
