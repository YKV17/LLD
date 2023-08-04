package strategies.botPlayingStrategy;

import enums.CellStatus;
import models.Board;
import models.Cell;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Cell makeMove(Board board) {

        for(List<Cell> row: board.getBoard()){
            for (Cell cell: row){
                if(cell.getCellStatus().equals(CellStatus.EMPTY)) return cell;
            }
        }

        return null;
    }
}
