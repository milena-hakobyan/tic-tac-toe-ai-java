package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {
    private GameTable table;

    @BeforeEach
    void setUp() {
        table = new GameTable();
    }

    @Test
    @DisplayName("Test easy AI makes a move")
    void makeMoveEasy() {
        AIPlayer aiPlayer = new AIPlayer("easy",'O');

        table.placeMove(0, 2, 'X', false);

        int before = table.getNumMovesLeft();
        aiPlayer.makeMove(table);
        int after = table.getNumMovesLeft();

        assertEquals(before, 8);
        assertEquals(after, 7);
        assertTrue(boardContainsSymbol('O'));
    }

    private boolean boardContainsSymbol(char symbol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table.getCell(i, j) == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    @DisplayName("Test medium AI blocks opponent's winning move")
    void makeMoveMediumBlocking() {
        /*
            AI should play the blocking move (0,0)
            ---------
            |   X X |
            | X     |
            | 0 0   |
            ---------
         */
        AIPlayer aiPlayer = new AIPlayer("medium",'O');
        table.placeMove(0, 2, 'X', false);
        table.placeMove(2 ,1, '0', false);
        table.placeMove(1, 0, 'X', false);
        table.placeMove(2 ,0, '0', false);
        table.placeMove(0, 1, 'X', false);

        aiPlayer.makeMove(table);

        assertEquals('O', table.getCell(0,0));
    }

    @Test
    @DisplayName("Test medium AI makes a winning move")
    void makeMoveMediumWinning() {
        /*
            AI should play the winning move (0,0)
            ---------
            |       |
            |   X   |
            | 0 0 X |
            ---------
        */
        AIPlayer aiPlayer = new AIPlayer("medium",'X');
        table.placeMove(1, 1, 'X', false);
        table.placeMove(2 ,0, '0', false);
        table.placeMove(2, 2, 'X', false);
        table.placeMove(2 ,1, '0', false);

        aiPlayer.makeMove(table);

        assertTrue(table.isGameOver());
        assertEquals('X', table.getCell(0,0));
    }

    @Test
    @DisplayName("Test medium AI falls back to easy move when no blocking or winning move is available")
    void testAiMoveMediumFallbackToEasy() {
        AIPlayer ai = new AIPlayer("medium", 'X');

        // Fill board such that no win/blocking move is possible but some cells are empty
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 1, 'O', false);

        int before = table.getNumMovesLeft();
        ai.makeMove(table);
        int after = table.getNumMovesLeft();

        assertEquals(before - 1, after);
    }

    @Test
    @DisplayName("Test hard AI makes the winning move")
    void testHardAIMakesWinningMove() {
        AIPlayer ai = new AIPlayer("hard", 'X');

        // X can win by playing (0, 2)
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 1, 'X', false);
        table.placeMove(1, 0, 'O', false);
        table.placeMove(1, 1, 'O', false);

        boolean gameOver = ai.makeMove(table);

        assertEquals('X', table.getCell(0, 2));
        assertTrue(gameOver);
        assertEquals('X', table.getWinner());
    }

    @Test
    @DisplayName("Test hard AI blocks opponent's win")
    void testHardAIBlocksOpponentWin() {
        AIPlayer ai = new AIPlayer("hard", 'X');

        // O is about to win at (2, 2), X must block
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 2, 'X', false);
        table.placeMove(0, 1, 'O', false);
        table.placeMove(1, 1, 'O', false);

        boolean gameOver = ai.makeMove(table);

        assertEquals('X', table.getCell(2, 1)); // block move
        assertFalse(gameOver);
    }


    @Test
    @DisplayName("Test hard AI blocks opponent's win")
    void testHardAIWinInTwoMoves() {
        /*
            AI should play the move (2,0), so it wins in two moves
            ---------
            | O O X |
            | X   O |
            |     X |
            ---------
        */
        AIPlayer ai = new AIPlayer("hard", 'X');

        table.placeMove(1, 0, 'X', false);
        table.placeMove(0, 0, 'O', false);
        table.placeMove(2, 2, 'X', false);
        table.placeMove(0, 1, 'O', false);
        table.placeMove(0, 2, 'X', false);
        table.placeMove(1, 2, 'O', false);

        boolean gameOver = ai.makeMove(table);

        assertEquals('X', table.getCell(2, 0));
        assertFalse(gameOver);
    }
}
