//Made by Regina Bi (rbi287)
/* A functional Meowdoku game where you must guess the positions of cats hidden on a board.
   Features a score system depending on player performance and different possible boards.
 */

public class A1 {
    public static void main(String[] args) {
        Player player = new HumanPlayer("Bob", 4);
        MeowdokuGame game = new MeowdokuGame(player, 4);
        game.play();
    }
}

enum Colour {
    BLUE, RED, GREEN, YELLOW;
}

enum CellState {
    HIDDEN('_'), FOUND_CAT('C'), WRONG_GUESS('X');

    private final char symbol;
    private CellState(final char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }
}

enum GuessResult {
    CORRECT(10, "Correct!"), WRONG(-1, "No cat there!"), ALREADY_GUESSED(0, "Position already guessed!");

    private final int score;
    private final String message;
    private GuessResult(int score, String message) {
        this.score = score;
        this.message = message;
    }
    public int getScore() {
        return score;
    }
    public String getMessage() {
        return message;
    }
}
