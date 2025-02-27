package com.hundefined.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class EchoCommand implements Command {

    @Override
    public String getName() {
        return "echo";
    }

    @Override
    public String getDescription() {
        return "Echoes back the text you provide.";
    }

    @Override
    public CommandData getCommandData() {
        return Commands.slash(getName(), getDescription())
                .addOption(OptionType.STRING, "text", "The text to echo", true);
    }

    @Override
    public void executeSlash(SlashCommandInteractionEvent event) {
        OptionMapping textOption = event.getOption("text");
        String textToEcho = "";
        if (textOption != null) {
            textToEcho = textOption.getAsString();
        } else {
            textToEcho = "You didn't provide any text to echo!"; // Default message if no text provided
        }

        event.reply(textToEcho).setEphemeral(false).queue();
    }
}