package tictactoe;

public class GameTable{
    char[][] board;
    int numMovesLeft;

    public GameTable(){
        board = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        numMovesLeft = 9;
        printArr();
    }

    //after the player makes the move the table should be updated
    //the flag 'print' will indicate whether the table should be printed after placing the move or not
    public void placeMove(int r, int c, char symbol, boolean print) throws IllegalArgumentException{
        board[r][c] = symbol;
        numMovesLeft--;
        if (print)
            printArr();
    }

    //helper method used for undoing a "mock" move
    public void undoMove(int r, int c){
        board[r][c] = ' ';
        numMovesLeft++;
    }


    public boolean isCellEmpty(int r, int c){
        return board[r][c]==' ';
    }


    //checks whether the game is ended
    public boolean isGameOver() {
        char winner = getWinner();
        if (winner != ' ') {
            System.out.println(winner + " wins");
            return true;
        }
        if (numMovesLeft == 0) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }


    public boolean isDraw() {
        return numMovesLeft == 0 && getWinner() == ' ';
    }


    // a method to check whether there's a winner, if so it will return the winner's symbol
    // otherwise, will return ' '
    public char getWinner() {
        //check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
        }
        //check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return board[0][j];
        }
        //check diagonal
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        //check anti-diagonal
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        //no one won, which is
        return ' ';
    }


    //print the arr with the given format
    public void printArr(){
        System.out.println("---------");
        for(int i = 0; i<3;i++){
            System.out.print('|' + " ");
            for (int j = 0; j <3; j++) {
                System.out.print(j==2? board[i][j]: board[i][j] + " ");
            }
            System.out.print(" " + '|');
            System.out.println();
        }
        System.out.println("---------");
    }
}