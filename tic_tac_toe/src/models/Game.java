package models;

import enums.CellStatus;
import enums.GameStatus;
import enums.PlayerType;
import strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Move> moves;
    private List<Player> players;
    private int currentPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private List<WinningStrategy> winningStrategies;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.players = players;
        this.currentPlayerIndex = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printResult() {
        if (gameStatus.equals(GameStatus.ENDED)) {
            System.out.println("Game has Ended");
            System.out.println("Winner is :" + winner.getName());
        } else {
            System.out.println("Game is Drawn");
        }
    }

    public void makeMove() {
        Player player = players.get(currentPlayerIndex);

        System.out.println("It is " + player.getName() + "'s turn.");

        Cell proposedCell = player.makeMove(board);

        System.out.println("Move made at row: " + proposedCell.getRow() + "and col: " + proposedCell.getCol());

        if (!isValidCell(proposedCell)) {
            System.out.println("Invalid move! Please try again.");
            return;
        }

        Cell cellInBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInBoard.setCellStatus(CellStatus.FILLED);
        cellInBoard.setPlayer(player);

        Move move = new Move(player, cellInBoard);
        moves.add(move);

        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                gameStatus = GameStatus.ENDED;
                winner = player;
                return;
            }
        }

        if(moves.size() == board.getSize() * board.getSize()){
            gameStatus = GameStatus.DRAW;
            return;
        }

        currentPlayerIndex += 1;
        currentPlayerIndex %= players.size();

    }

    private boolean isValidCell(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if (row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()) {
            return false;
        }

        if (board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.EMPTY)) {
            return true;
        }

        return false;
    }

    public void undo() {
        if(moves.size() == 0){
            throw new IllegalStateException("No Move, Can't Undo.");
        }
        Move lastMove = moves.get(moves.size() - 1);

        for(WinningStrategy winningStrategy: winningStrategies){
            winningStrategy.undo(board, lastMove);
        }

        Cell cell = lastMove.getCell();
        cell.setCellStatus(CellStatus.EMPTY);
        cell.setPlayer(null);

        moves.remove(lastMove);

        currentPlayerIndex -= 1;
        currentPlayerIndex += players.size();
        currentPlayerIndex %= players.size();
    }


    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {

        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private boolean isValid() {
            if (this.players.size() < 2) return false;

            if (this.players.size() != this.dimension - 1) return false;

            int botCount = 0;

            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) botCount++;
            }

            if (botCount >= 2) return false;

            Set<Character> symbols = new HashSet<>();

            for (Player player : players) {
                if (symbols.contains(player.getSymbol().getSymbol())) return false;

                symbols.add(player.getSymbol().getSymbol());
            }

            return true;
        }

        public Game build() {
            if (!isValid()) throw new IllegalArgumentException("Invalid Params for game.");
            return new Game(dimension, players, winningStrategies);
        }
    }
}
