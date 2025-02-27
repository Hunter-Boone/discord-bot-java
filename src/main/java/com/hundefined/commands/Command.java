package com.hundefined.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public interface Command {
    String getName();

    String getDescription();

    void executeSlash(SlashCommandInteractionEvent event);
    
    default CommandData getCommandData() {
        return Commands.slash(getName(), getDescription());
    }
}