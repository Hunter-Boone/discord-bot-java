# Discord Bot Tutorial

A simple Discord bot built as a learning project using Java. This bot demonstrates fundamental JDA (Java Discord API) concepts and provides a foundation for building more complex bots.

There is a video tutorial that goes with this repository explaining every line of code in detail. You can find that at https://youtu.be/Whnl-5fXN5c

## Features

- Command handling system with slash commands
- Modular command implementation
- Event-based responses
- Configuration management

## Prerequisites

- Java 11 or higher
- Maven or Gradle build system
- A Discord account and access to the Developer Portal

## Installation

1. Clone this repository

   ```
   git clone https://github.com/Hunter-Boone/discord-bot.git
   cd discord-bot
   ```

2. Build the project

   ```
   mvn clean package
   ```

   or with Gradle:

   ```
   gradle build
   ```

3. Configure your bot token in `src/main/resources/config.properties`
   ```properties
   botToken=your_bot_token_here
   ```

## Configuration

1. Get a bot token from the [Discord Developer Portal](https://discord.com/developers/applications)
2. Create a new application and add a bot user
3. Enable necessary intents in the bot settings
4. Invite the bot to your server using the OAuth2 URL generator with appropriate scopes (bot, applications.commands)

## Usage

Run the bot with:

```
java -jar target/discord-bot-1.0-SNAPSHOT.jar
```

## Commands

This bot uses Discord's slash commands:

- `/ping` - Checks the bot's latency to Discord's gateway
- `/info` - Displays information about the bot
- `/echo [text]` - Responds back with your message

## Project Structure

- `DiscordBot.java` - Main entry point that initializes the bot
- `CommandListener.java` - Handles incoming slash commands
- `BotConfig.java` - Manages configuration and environment variables
- `commands/` - Contains command implementations

## Dependencies

- JDA (Java Discord API)
- SLF4J for logging
- Other standard Java libraries

## Contributing

Feel free to fork this project

## License

[MIT](https://choosealicense.com/licenses/mit/)
