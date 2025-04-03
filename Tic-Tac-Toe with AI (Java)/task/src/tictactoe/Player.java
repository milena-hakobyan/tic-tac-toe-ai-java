package tictactoe;

public abstract class Player{
    String name;
    char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }
    //human and AI classes will have the concrete implementation of the method based on their logic
    public abstract boolean makeMove(GameTable board);
}