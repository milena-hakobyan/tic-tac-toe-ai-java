package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player{
    private Scanner sc;

    public HumanPlayer(String name, char symbol, Scanner sc) {
        super(name, symbol);
        this.sc = sc; //not to create a new Scanner object after each step, pass just one object when the game starts
    }


    @Override
    //the method takes from the console user's desired move coordinates, and places the move on the board if the move is valid
    public boolean makeMove(GameTable board){
        int r,c;
        while(true) {
            try {
                System.out.print("Enter the coordinates: > ");
                //add checks, throw exception if the argument is not an int
                r = sc.nextInt();
                c = sc.nextInt();
                if (r < 1 || r > 3 || c < 1 || c > 3)
                    throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
                if (!board.isCellEmpty(r - 1, c - 1))
                    throw new IllegalArgumentException("This cell is occupied! Choose another one!");
                board.placeMove(r-1,c-1,symbol, true); //the input is fine, place the move
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException m){
                System.out.println("You should enter numbers!");
            }
        }
        //returns true if the game ended after user's move
        return board.isGameOver();
    }
}
