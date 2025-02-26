package com.hundefined.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

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
