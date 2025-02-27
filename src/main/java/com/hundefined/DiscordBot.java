package com.hundefined;

import com.hundefined.config.BotConfig;
import com.hundefined.listeners.CommandListener;
import com.hundefined.commands.Command;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

public class DiscordBot {
    private static final Logger logger = LoggerFactory.getLogger(DiscordBot.class);
    private static JDA jda;

    public static void main(String[] args) {
        String botToken = BotConfig.getBotToken();

        if (botToken == null || botToken.isEmpty()) {
            logger.error("Bot token not found in config.properties. Please provide a valid token.");
            return; // Exit if no token is found
        }

        try {
            // Build JDA instance
            jda = JDABuilder.createDefault(botToken)
                    .enableIntents(EnumSet.allOf(GatewayIntent.class))
                    .addEventListeners(new CommandListener())
                    .build();

            jda.awaitReady();
            logger.info("Bot is online and ready!");

            registerSlashCommands();
        } catch (Exception e) {
            logger.error("Error starting the bot: ", e);
        }
    }

    private static void registerSlashCommands() {
        if (jda == null) {
            logger.error("JDA instance is not initialized. Cannot register slash commands.");
            return;
        }

        logger.info("Registering Slash Commands...");
        
        // Get command listener instance to access commands map
        CommandListener commandListener = null;
        for (Object listener : jda.getEventManager().getRegisteredListeners()) {
            if (listener instanceof CommandListener) {
                commandListener = (CommandListener) listener;
                break;
            }
        }
        
        if (commandListener == null) {
            logger.error("CommandListener not found. Cannot register slash commands.");
            return;
        }
        
        // Get command data from each command in the map
        jda.updateCommands()
                .addCommands(commandListener.getCommands().values().stream()
                        .map(Command::getCommandData)
                        .toList())
                .queue(success -> logger.info("Slash commands registered successfully!"),
                        failure -> logger.error("Failed to register slash commands: ", failure));
    }

}