package tictactoe;

import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(String name, char symbol){
        super(name, symbol);
    }


    @Override
    public boolean makeMove(GameTable board){
        switch(this.name){
            case "easy":
                System.out.println("Making move level \"easy\"");
                return aiMoveEasy(board);
            case "medium":
                System.out.println("Making move level \"medium\"");
                return aiMoveMedium(board);
            case "hard":
                System.out.println("Making move level \"hard\"");
                return aiMoveHard(board, true);
        }
        return false;
    }



    //returns true if the game ended after the move
    private boolean aiMoveEasy(GameTable board){
        Random random = new Random();
        int randRow;
        int randCol;
        while (true) {
            randRow = random.nextInt(3);
            randCol = random.nextInt(3);
            if(board.isCellEmpty(randRow, randCol)){
                board.placeMove(randRow,randCol,symbol, true);
                break;
            }
        }
        return board.isGameOver();
    }


    //returns true if the game ended after the move
    private boolean aiMoveMedium(GameTable board){
        char opponentSymbol = (symbol == 'X'?'O':'X');

        //winning move
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board.isCellEmpty(i,j)){
                    board.placeMove(i,j,symbol, false);
                    if (board.getWinner()==symbol){
                        board.placeMove(i,j,symbol, true);
                        return board.isGameOver();
                    }
                    else
                        board.undoMove(i,j);
                }
            }
        }
        //blocking move
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board.isCellEmpty(i,j)){
                    board.placeMove(i,j,opponentSymbol, false);
                    if (board.getWinner() == opponentSymbol) {
                        board.placeMove(i,j,symbol, true);
                        return board.isGameOver();
                    }
                    else
                        board.undoMove(i,j);
                }
            }
        }
        //fallback move
        return aiMoveEasy(board);
    }


    public boolean aiMoveHard(GameTable board, boolean aiMove){
        int[] optMove = new int[2];
        int maxScore = Integer.MIN_VALUE;
        int cur;
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++){
                if(board.isCellEmpty(i,j)){
                    //ai places a possible move
                    board.placeMove(i, j, symbol,false);
                    //it's the opponent's turn => call minimax with "false"
                    cur = minimax(board,false);
                    board.undoMove(i,j);
                    if(cur > maxScore) {
                        maxScore = cur;
                        optMove[0]=i;
                        optMove[1]=j;
                    }
                }
            }
        }
        //the optimal move (with max score) is found, place it on the board and print the board
        board.placeMove(optMove[0],optMove[1], symbol,true);
        //check if the game ended
        return board.isGameOver();
    }



    public int minimax(GameTable board, boolean aiMove){
        //base cases meaning either a win is found or the game is over with a draw
        //return 1,-1 or 0 correspondingly
        if (board.isDraw())
            return 0;
        if (board.getWinner() == symbol)
            return 1;
        else if(board.getWinner() == (symbol=='X'?'O':'X'))
            return -1;
        if(aiMove) {
            //ai's move
            //should get the max possible value given the next move is played by an optimally-playing opponent
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 3; j++) {
                     if (board.isCellEmpty(i, j)){
                         board.placeMove(i, j, symbol, false);
                         int cur = minimax(board, false);
                         max = Math.max(cur,max);
                         board.undoMove(i, j);
                     }
                 }
            }
            return max;
        }
        else{
            //opponent's move
            // ai assumes opponent plays optimally => should check find the min (the worst case possible)
            char opponent = (symbol=='X')?'O':'X';
            int min = Integer.MAX_VALUE;
            for(int i = 0; i <3; i++){
                for(int j = 0; j < 3; j++) {
                    if(board.isCellEmpty(i,j)) {
                        board.placeMove(i, j, opponent, false);
                        int cur = minimax(board, true);
                        min = Math.min(cur,min);
                        board.undoMove(i, j);
                    }
                }
            }
            return min;
        }
    }
}