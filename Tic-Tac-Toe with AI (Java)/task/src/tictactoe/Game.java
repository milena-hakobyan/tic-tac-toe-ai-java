package tictactoe;

import java.util.Scanner;

public class Game {
    private GameTable board;
    private Player player1;
    private Player player2;
    private Scanner sc;

    public Game() {
        this.board = new GameTable();
        sc = new Scanner(System.in);
    }

    public void startGame(){
        //start the game, the user chooses players (user vs ai (easy/medium))
        //input should be of the form "start player1(user/easy/medium/hard) player2(user/easy/medium/hard)"
        while(true) {
            try {
                System.out.print("Input command: > ");
                String start = sc.nextLine();

                if (start.equals("exit"))
                    System.exit(0); //terminate the program when "exit" is typed

                //split the input into words, so we can validate the input
                //while input not valid, prompt for new input
                String[] input = start.split(" ");
                if (input.length<3 || !isValidStart(input[0], input[1], input[2]))
                    throw new IllegalArgumentException("Bad parameters!");

                player1 = createPlayerObjects(input[1], 'X', sc);
                player2 = createPlayerObjects(input[2], 'O', sc);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean gameOver = false;
        while(!gameOver){
            gameOver = player1.makeMove(board);
            if(gameOver)
                break;
            gameOver = player2.makeMove(board);
        }
    }


    public static Player createPlayerObjects(String name, char symbol, Scanner sc){
        switch(name){
            case "user":
                return new HumanPlayer("user", symbol, sc);
            case "easy":
                return new AIPlayer("easy", symbol);
            case "medium":
                return new AIPlayer("medium", symbol);
            case "hard":
                return new AIPlayer("hard", symbol);
        }
        return null;
    }


    public static boolean isValidStart(String start, String p1, String p2){
        if(!start.equals("start") || !(p1.equals("user")||p1.equals("easy")||p1.equals("medium") ||p1.equals("hard"))||
                !(p2.equals("user")||p2.equals("easy")||p2.equals("medium")||p2.equals("hard")))
            return false;
        return true;
    }
}
