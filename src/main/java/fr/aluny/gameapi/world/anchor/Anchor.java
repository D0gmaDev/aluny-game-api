package fr.aluny.gameapi.world.anchor;

import java.util.Objects;
import org.bukkit.Location;

public record Anchor(String key, String[] args, Location location) {

    public Anchor {
        Objects.requireNonNull(key);
        Objects.requireNonNull(args);
        Objects.requireNonNull(location);
    }

    public Location blockLocation() {
        return location.getBlock().getLocation();
    }

    @Override
    public String toString() {
        return "Anchor (" + key + ") [" + String.join(",", args) + "]: " + location;
    }
}
