package strategies.winningStrategy;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    private List<Map<Symbol, Integer>> colMaps;

    public ColumnWinningStrategy(int size, List<Player> players) {
        this.colMaps = new ArrayList<>();
        for(int i = 0; i < size; ++i){
            colMaps.add(new HashMap<>());
            for(Player player: players){
                colMaps.get(i).put(player.getSymbol(), 0);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        colMaps.get(col).put(symbol, 1 + colMaps.get(col).get(symbol));

        return colMaps.get(col).get(symbol) == board.getSize();
    }

    @Override
    public void undo(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        colMaps.get(col).put(symbol, colMaps.get(col).get(symbol) - 1);
    }
}
