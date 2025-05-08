package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HumanPlayerTest {
    private GameTable table;
    private HumanPlayer player;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        table = new GameTable();
        scanner = mock(Scanner.class);
        player = new HumanPlayer("user", 'X', scanner);
    }

    @Test
    @DisplayName("Test invalid input followed by a valid move")
    void makeMoveWithInvalidInput() {
        // invalid input first, then valid
        when(scanner.nextInt()).thenReturn(-1, 4, 1, 1);

        player.makeMove(table);

        assertEquals('X', table.getCell(0, 0));
    }

    @Test
    @DisplayName("Test valid input for placing 'X' on the board")
    void makeMoveWithValidInput() {
        when(scanner.nextInt()).thenReturn(2, 2);

        player.makeMove(table);

        assertEquals('X', table.getCell(1, 1));
    }
}
