package de.tubeof.tubetils.api.actionbar.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@SuppressWarnings("ALL")
public class ActionBarMessageDurationEvent extends Event {

    private final HandlerList handlers = new HandlerList();
    private final Player player;
    private String message;
    private Boolean cancelled;
    private Integer duration;

    public ActionBarMessageDurationEvent(Player player, String message, Integer duration) {
        this.cancelled = false;
        this.player = player;
        this.message = message;
        this.duration = duration;
    }

    @Override
    public HandlerList getHandlers() {
        return this.handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
