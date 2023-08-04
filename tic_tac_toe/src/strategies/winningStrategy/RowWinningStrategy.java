package strategies.winningStrategy;

import models.Board;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    private List<Map<Symbol, Integer>> rowMaps;

    public RowWinningStrategy(int size, List<Player> players) {
        this.rowMaps = new ArrayList<>();
        for(int i = 0; i < size; ++i){
            rowMaps.add(new HashMap<>());
            for(Player player: players){
                rowMaps.get(i).put(player.getSymbol(), 0);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        rowMaps.get(row).put(symbol, 1 + rowMaps.get(row).get(symbol));

        return rowMaps.get(row).get(symbol) == board.getSize();
    }

    @Override
    public void undo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        rowMaps.get(row).put(symbol, rowMaps.get(row).get(symbol) - 1);
    }
}
