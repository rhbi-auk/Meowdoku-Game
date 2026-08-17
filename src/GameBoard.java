import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private int size;
    private Cell[][] board;
    private int[] solution;
    private Colour[] colours;

    public GameBoard(int size) {
        this.size = size;
        board = new Cell[size][size];

        //random selects ONE OF TWO valid cat solution
        Random random = new Random(30);

        int randomNum = random.nextInt(2);
        if (randomNum == 0) {
            solution = new int[]{2, 0, 3, 1};
        } else {
            solution = new int[]{1, 3, 0, 2};
        }
        colours = new Colour[]{Colour.BLUE, Colour.RED, Colour.GREEN, Colour.YELLOW};
        //colours to be assigned in random order
        List<Colour> list = Arrays.asList(colours);
        Collections.shuffle(list, random);
        colours = list.toArray(new Colour[0]);
        initialiseBoard();
    }

    private void initialiseBoard() {
        placeInitialColours();
        for (int i = 0; i < size; i++) {
            expandRegion(i, solution[i], colours[i]);
        }
    }

    private void placeInitialColours() {
        for (int i = 0; i < size; i++) {
            board[i][solution[i]] = new Cell((colours[i]));
        }
    }

    private void expandRegion(int row, int column, Colour colour) {
        //fill cell itself and its eight neighbouring positions
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < size && j >= 0 && j < size) {
                    if (board[i][j] == null) {
                        board[i][j] = new Cell(colour);
                    }
                }
            }
        }
    }

    public GuessResult checkGuess(Position position) {
        //if guessed, return already_guessed
        //if position matches solution, change
        //cell state to found_cat and return correct
        //else, change to wrong_guess and return wrong
        Cell guessedCell = board[position.getRow()][position.getColumn()];

        //All cells initialise with state HIDDEN
        if (guessedCell.getState() != CellState.HIDDEN) {
            return GuessResult.ALREADY_GUESSED;
            //compare using solution array where:
            //row = index; column = position.getColumn
        } else if (solution[position.getRow()] == position.getColumn()) {
            guessedCell.setState(CellState.FOUND_CAT);
            return GuessResult.CORRECT;
        } else {
            guessedCell.setState(CellState.WRONG_GUESS);
            return GuessResult.WRONG;
        }
    }
    @Override
    public String toString() {
        //"RBBB\nRBBB\nRRGG\nYYGG"
        //Cell object toString() returns char
        StringBuilder gameBoardString = new StringBuilder();
        for (Cell[] row : board) {
            for (Cell cell : row) {
                gameBoardString.append(cell.toString());
            }
            gameBoardString.append("\n");
        }
        gameBoardString.setLength(gameBoardString.length() - 1);
        return gameBoardString.toString();
    }
}
