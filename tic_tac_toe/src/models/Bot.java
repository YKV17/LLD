package models;

import enums.DifficultyLevel;
import enums.PlayerType;
import strategies.botPlayingStrategy.BotPlayingStrategy;
import strategies.botPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, DifficultyLevel difficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Cell makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
