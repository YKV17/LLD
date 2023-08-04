package strategies.winningStrategy;

import models.Board;
import models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);

    void undo(Board board, Move move);
}
