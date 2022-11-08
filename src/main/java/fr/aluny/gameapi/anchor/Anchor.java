package fr.aluny.gameapi.anchor;

import org.bukkit.Location;

public record Anchor(String key, String[] args, Location location) {

    public Location getBlockLocation() {
        return location.getBlock().getLocation();
    }

    @Override
    public String toString() {
        return "Anchor (" + key + ") [" + String.join(",", args) + "]: " + location;
    }
}
