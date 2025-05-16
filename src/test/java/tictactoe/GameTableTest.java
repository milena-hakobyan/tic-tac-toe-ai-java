package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTableTest {

    private GameTable table;

    @BeforeEach
    void setUp(){
        table = new GameTable();
    }

    @Test
    @DisplayName("Test placing and undoing a move")
    void testPlaceAndUndoMove() {
        table.placeMove(0, 0, 'X', false);
        assertEquals('X', table.getCell(0,0));

        table.undoMove(0, 0);
        assertTrue(table.isCellEmpty(0, 0));
    }

    @Test
    @DisplayName("Test if cell is empty")
    void testIsCellEmpty() {
        //initally the board is empty, so any cell is empty
        assertTrue(table.isCellEmpty(0,0));
    }

    @Test
    @DisplayName("Test winner detection for horizontal win")
    void testGetWinnerHorizontal() {
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 1, 'X', false);
        table.placeMove(0, 2, 'X', false);

        assertEquals('X', table.getWinner());
    }

    @Test
    @DisplayName("Test winner detection for vertical win")
    void testGetWinnerVertical() {
        table.placeMove(0, 0, 'O', false);
        table.placeMove(1, 0, 'O', false);
        table.placeMove(2, 0, 'O', false);

        assertEquals('O', table.getWinner());
    }

    @Test
    @DisplayName("Test winner detection for diagonal win")
    void testGetWinnerDiagonal() {
        table.placeMove(0, 0, 'X', false);
        table.placeMove(1, 1, 'X', false);
        table.placeMove(2, 2, 'X', false);

        assertEquals('X', table.getWinner());
    }

    @Test
    @DisplayName("Test winner detection for anti-diagonal win")
    void testGetWinnerAntiDiagonall() {
        table.placeMove(0, 2, 'O', false);
        table.placeMove(1, 1, 'O', false);
        table.placeMove(2, 0, 'O', false);

        assertEquals('O', table.getWinner());
    }

    @Test
    @DisplayName("Test isGameOver() when there is a winner")
    void testIsGameOverWithWinner() {
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 1, 'X', false);
        table.placeMove(0, 2, 'X', false);

        assertTrue(table.isGameOver());
    }

    @Test
    @DisplayName("Test isGameOver() when there is a draw")
    void testIsGameOverWithDraw() {
        // Draw situation
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 1, 'O', false);
        table.placeMove(0, 2, 'X', false);
        table.placeMove(1, 0, 'O', false);
        table.placeMove(1, 1, 'X', false);
        table.placeMove(1, 2, 'O', false);
        table.placeMove(2, 0, 'O', false);
        table.placeMove(2, 1, 'X', false);
        table.placeMove(2, 2, 'O', false);

        assertTrue(table.isGameOver());
    }

    @Test
    @DisplayName("Test isDraw() when the game ends in a draw")
    void testIsDraw() {
        table.placeMove(0, 0, 'X', false);
        table.placeMove(0, 1, 'O', false);
        table.placeMove(0, 2, 'X', false);
        table.placeMove(1, 0, 'O', false);
        table.placeMove(1, 1, 'X', false);
        table.placeMove(1, 2, 'O', false);
        table.placeMove(2, 0, 'O', false);
        table.placeMove(2, 1, 'X', false);
        table.placeMove(2, 2, 'O', false);

        assertTrue(table.isDraw());
    }

    @Test
    @DisplayName("Test printBoard()")
    void testPrintBoard() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        table.placeMove(1, 1, 'X', false);
        table.printBoard();

        String expectedOutput =
                        "---------\n" +
                        "|       |\n" +
                        "|   X   |\n" +
                        "|       |\n" +
                        "---------\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
