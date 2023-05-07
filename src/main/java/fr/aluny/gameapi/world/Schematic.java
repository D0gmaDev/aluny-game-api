package fr.aluny.gameapi.world;

import java.util.function.Consumer;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

/**
 * Represents a Minecraft schematic, which is a 3D structure that can be loaded, manipulated, and then pasted into a world.
 * The operations on the schematics such as {@link #flip} or {@link #setPasteAir} mutate this instance.
 *
 * @see SchematicService the service to load schematics
 */
public interface Schematic {

    /**
     * Pastes the schematic at the specified location, without a block or entity consumer.
     *
     * @param location the location to paste the schematic at
     */
    void paste(Location location);

    /**
     * Pastes the schematic at the specified location, with a block consumer to customize block placement.
     *
     * @param location the location to paste the schematic at
     * @param blockConsumer a consumer to customize the placement of each block in the schematic
     */
    void paste(Location location, Consumer<Block> blockConsumer);

    /**
     * Pastes the schematic at the specified location, with a block consumer and an option to include entities.
     *
     * @param location the location to paste the schematic at
     * @param blockConsumer a consumer to customize the placement of each block in the schematic
     * @param withEntities whether to include entities when pasting the schematic
     */
    void paste(Location location, Consumer<Block> blockConsumer, boolean withEntities);

    /**
     * Pastes the schematic at the specified location, with block and entity consumers to customize placement and spawning.
     *
     * @param location the location to paste the schematic at
     * @param blockConsumer a consumer to customize the placement of each block in the schematic
     * @param withEntities whether to include entities when pasting the schematic
     * @param entityConsumer a consumer to customize the spawning of each entity in the schematic
     */
    void paste(Location location, Consumer<Block> blockConsumer, boolean withEntities, Consumer<Entity> entityConsumer);

    /**
     * Returns this schematic, rotated by the specified number of quarters.
     *
     * @param quart the number of quarters to rotate the schematic by (1 to 3)
     * @return this schematic instance after the operation is performed
     */
    Schematic rotateBlocks(int quart);

    /**
     * Returns this schematic, flipped along the specified axis.
     *
     * @param axis the axis to flip the schematic along
     * @return this schematic instance after the operation is performed
     */
    Schematic flip(Axis axis);

    /**
     * Returns this schematic, flipped along the X axis.
     *
     * @return this schematic instance after the operation is performed
     */
    Schematic flipX();

    /**
     * Returns this schematic, flipped along the Y axis.
     *
     * @return this schematic instance after the operation is performed
     */
    Schematic flipY();

    /**
     * Returns this schematic, flipped along the Z axis.
     *
     * @return this schematic instance after the operation is performed
     */
    Schematic flipZ();

    /**
     * Returns the width of the schematic.
     *
     * @return the width of the schematic in blocks
     */
    short getWidth();

    /**
     * Returns the length of the schematic.
     *
     * @return the length of the schematic in blocks
     */
    short getLength();

    /**
     * Returns the height of the schematic.
     *
     * @return the height of the schematic in blocks
     */
    short getHeight();

    /**
     * Sets whether to paste air blocks in the schematic when pasting.
     *
     * @param pasteAir whether to paste air blocks
     */
    void setPasteAir(boolean pasteAir);

    /**
     * Returns whether the schematic paste air blocks.
     */
    boolean isPasteAir();
}
