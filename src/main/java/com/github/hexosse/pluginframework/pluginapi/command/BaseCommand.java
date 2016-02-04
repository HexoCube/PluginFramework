package com.github.hexosse.pluginframework.pluginapi.command;


import org.apache.commons.lang.Validate;
import org.bukkit.command.CommandSender;

import java.lang.annotation.Annotation;

/**
 * @author <b>hexosse</b> (<a href="https://github.comp/hexosse">hexosse on GitHub</a>))
 */

public class BaseCommand implements BaseCmd
{
    private final String name;
    private String description;
    private final String permission;
    private boolean allowConsole = true;
    private SubCommandHandler handler = null;

    /**
     * Create a new SubCommand.
     * @param name The text of this subcommand.
     * @param permission The permission to check for this command. If null, don't use permissions.
     */
    public BaseCommand(String name, String permission)
    {
        Validate.notEmpty(name);
        this.name = name;
        this.permission = permission;
    }

    /**
     * Returns the annotation type of this annotation.
     */
    @Override
    public Class<? extends Annotation> annotationType() {
        return BaseCmd.class;
    }

    /**
     * Get the command's name.
     * @return The command's name.
     */
    public String name() {
        return name;
    }

    /**
     * Set the command's description.
     *
     * Command description should be a short blurb (one line) explaining what
     * the command does. Long descriptions will probably wrap poorly.
     * .
     * @param description Description text.
     * @return the SubCommand, useful for chaining.
     */
    public BaseCommand description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the command's description.
     * @return The command's description.
     */
    public String description() {
        return description;
    }

    /**
     * Get the permission node this command is required to use.
     * @return permission node, or null if no permission.
     */
    public String permission() {
        return permission;
    }

    /**
     * Allow this command to be used on the console.
     * If this is not set, then the command only works for players.
     */
    public BaseCommand allowConsole(boolean allowConsole) {
        this.allowConsole = allowConsole;
        return this;
    }

    /** If true, console access is allowed. */
    public boolean allowConsole() {
        return this.allowConsole;
    }

    /**
     * Set the SubCommandHandler.
     * @param handler A SubCommandHandler which is called when this command executes.
     * @return the SubCommand, useful for chaining.
     */
    public BaseCommand setHandler(SubCommandHandler handler) {
        Validate.notNull(handler);
        this.handler = handler;
        return this;
    }

    /**
     * Get the currently set SubCommandHandler.
     * @return the SubCommandHandler which is called when this command executes.
     */
    public SubCommandHandler getHandler() {
        return handler;
    }

    /**
     * Check if a Player/CommandSender has the requisite permission for this command.
     * @param sender a ConsoleSender or Player.
     * @return True if the user has the permission or the command has no permission set, false otherwise.
     */
    public boolean checkPermission(CommandSender sender)
    {
        if (permission == null) return true;
        return sender.hasPermission(permission);
    }
}
