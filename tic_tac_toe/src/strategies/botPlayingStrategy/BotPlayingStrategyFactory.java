package strategies.botPlayingStrategy;

import enums.DifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(DifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }

}
