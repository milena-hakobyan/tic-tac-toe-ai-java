package tictactoe;

public class GameTable {
    public static final int BOARD_SIZE = 3;

    private char[][] board;
    private int numMovesLeft;

    public GameTable() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = ' ';
        numMovesLeft = BOARD_SIZE * BOARD_SIZE;
        //printArr();
    }

    public char getCell(int r, int c) {
        return board[r][c];
    }

    public int getNumMovesLeft() {
        return numMovesLeft;
    }

    public void placeMove(int r, int c, char symbol, boolean print) throws IllegalArgumentException {
        board[r][c] = symbol;
        numMovesLeft--;
        if (print) {
            printBoard();
        }
    }

    public void undoMove(int r, int c) {
        board[r][c] = ' ';
        numMovesLeft++;
    }

    public boolean isCellEmpty(int r, int c) {
        return board[r][c] == ' ';
    }

    public boolean isGameOver() {
        return getWinner() != ' ' || numMovesLeft == 0;
    }


    public boolean isDraw() {
        return numMovesLeft == 0 && getWinner() == ' ';
    }

    public char getWinner() {
        // check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
        }
        // check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return board[0][j];
        }
        // check diagonal
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        // check anti-diagonal
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return ' ';
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(j == BOARD_SIZE - 1 ? board[i][j] : board[i][j] + " ");
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }
}
