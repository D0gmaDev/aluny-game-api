package fr.aluny.gameapi.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;

public interface ClickableMessageBuilder {

    ClickableMessageBuilder addPart(String key, String... args);

    ClickableMessageBuilder withColor(ChatColor color);

    ClickableMessageBuilder withClickAction(ClickEvent.Action action, String value);

    ClickableMessageBuilder withHoverText(String key, String... args);

}
