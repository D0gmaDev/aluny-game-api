package fr.aluny.gameapi.world.anchor;

import org.bukkit.Location;

public record Anchor(String key, String[] args, Location location) {

    public Location blockLocation() {
        return location.getBlock().getLocation();
    }

    @Override
    public String toString() {
        return "Anchor (" + key + ") [" + String.join(",", args) + "]: " + location;
    }
}
