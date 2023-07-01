package fr.aluny.gameapi.player;

import fr.aluny.gameapi.message.MessageHandler;
import java.time.Instant;
import java.util.Collection;
import java.util.UUID;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Represents a player, whether online or offline.
 */
public interface OfflineGamePlayer {

    UUID getUuid();

    String getPlayerName();

    boolean isOnline();

    Instant getLastConnectedInstant();

    Location getLocation();

    void teleport(Location location);

    Collection<PotionEffect> getPotionEffects();

    void setPotionEffects(Collection<PotionEffect> potionEffects);

    void addPotionEffect(PotionEffect potionEffect);

    void removePotionEffect(PotionEffectType potionEffectType);

    GameMode getGameMode();

    void setGameMode(GameMode gameMode);

    PlayerInventory getInventory();

    void clearInventory();

    int getLevels();

    float getExperience();

    void setLevel(int level);

    void setExperience(float experience);

    double getHealth();

    void setHealth(double health);

    double getMaxHealth();

    AttributeInstance getMaxHealthAttribute();

    int getFoodLevel();

    void setFoodLevel(int foodLevel);

    float getWalkSpeed();

    void setWalkSpeed(float speed);

    boolean isAllowFlight();

    void setAllowFlight(boolean allowFlight);

    MessageHandler getMessageHandler();

}
