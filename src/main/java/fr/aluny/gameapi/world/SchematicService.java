package fr.aluny.gameapi.world;

import fr.aluny.gameapi.service.Service;
import java.io.InputStream;
import org.bukkit.plugin.Plugin;

/**
 * The SchematicService interface provides methods to load Minecraft schematics.
 *
 * @see Schematic
 */
public interface SchematicService extends Service {

    /**
     * Loads a schematic from the given plugin's resources folder.
     *
     * @param name the name of the schematic file
     * @param plugin the plugin to load the schematic from
     * @return the loaded schematic
     */
    Schematic loadSchematic(String name, Plugin plugin);

    /**
     * Loads a schematic from an input stream.
     *
     * @param inputStream the input stream to load the schematic from
     * @return the loaded schematic
     */
    Schematic loadSchematic(InputStream inputStream);

    /**
     * Gets an input stream of a schematic file from the given plugin's resources folder.
     *
     * @param name the name of the schematic file
     * @param plugin the plugin to get the schematic file from
     * @return the input stream of the schematic file
     */
    InputStream getSchematicStreamFromResources(String name, Plugin plugin);

}
