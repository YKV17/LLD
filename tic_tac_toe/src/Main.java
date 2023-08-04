import controller.GameController;
import enums.DifficultyLevel;
import enums.GameStatus;
import enums.PlayerType;
import models.Bot;
import models.Game;
import models.Player;
import models.Symbol;
import strategies.winningStrategy.ColumnWinningStrategy;
import strategies.winningStrategy.DiagonalWinningStrategy;
import strategies.winningStrategy.RowWinningStrategy;

import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        Game game = null;
        int DIMENSION = 3;
        List<Player> players = List.of(new Player("Yogesh", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Bot", new Symbol('O'), DifficultyLevel.EASY)
        );

        try {
            game = gameController.createGame(
                    DIMENSION,
                    players,
                    List.of(new ColumnWinningStrategy(DIMENSION, players),
                            new DiagonalWinningStrategy(DIMENSION, players),
                            new RowWinningStrategy(DIMENSION, players)
                    )
            );
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return;
        }

        System.out.printf("--------------------------------------- Game is starting ---------------------------------------");

        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is how the board looks like.");
            gameController.displayBoard(game);
            System.out.println("Do you want to undo? (y/n)");
            String input = scanner.next();

            if (input.equalsIgnoreCase("y")) {
                gameController.undo(game);
            } else {
                gameController.makeMove(game);
            }
        }

        gameController.printResult(game);
    }
}