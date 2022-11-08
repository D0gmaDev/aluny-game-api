package fr.aluny.gameapi.world;

import java.util.function.Consumer;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public interface Schematic {

    void paste(Location location);

    void paste(Location location, Consumer<Block> blockConsumer);

    void paste(Location location, Consumer<Block> blockConsumer, boolean withEntities);

    void paste(Location location, Consumer<Block> blockConsumer, boolean withEntities, Consumer<Entity> entityConsumer);

    Schematic rotateBlocks(int quart);

    Schematic flip(Axis axis);

    Schematic flipX();

    Schematic flipY();

    Schematic flipZ();

    short getWidth();

    short getLength();

    short getHeight();

    void setPasteAir(boolean pasteAir);

    boolean isPasteAir();
}
