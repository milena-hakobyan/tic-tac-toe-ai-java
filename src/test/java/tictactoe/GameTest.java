package tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("Test valid start commands with different player types")
    void testValidStart() {
        assertTrue(Game.isValidStart("start", "user", "easy"));
        assertTrue(Game.isValidStart("start", "medium", "hard"));
        assertTrue(Game.isValidStart("start", "easy", "user"));
    }

    @Test
    @DisplayName("Test invalid start command")
    void testInvalidStartCommand() {
        assertFalse(Game.isValidStart("play", "user", "easy"));
        assertFalse(Game.isValidStart("begin", "medium", "hard"));
    }

    @Test
    @DisplayName("Test invalid player types")
    void testInvalidPlayerTypes() {
        assertFalse(Game.isValidStart("start", "bot", "easy"));
        assertFalse(Game.isValidStart("start", "user", "expert"));
        assertFalse(Game.isValidStart("start", "pro", "legend"));
    }

    @Test
    @DisplayName("Test too few arguments provided")
    void testTooFewArguments() {
        assertFalse(Game.isValidStart("start", "user", ""));
    }
}
