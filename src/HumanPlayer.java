import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;
    public HumanPlayer(String name, int size) {
        super(name, size);
        scanner = new Scanner(System.in);
    }
    public Position makeGuess() {
        int row =  getValidPosition("Enter Row: ", size);
        int column = getValidPosition("Enter Column: ", size);
        return new Position(row, column);
    }
    private int getValidPosition(String prompt, int size) {
        int userInput;
        do{
            System.out.print(prompt);
            userInput = scanner.nextInt();
        } while (userInput < 0 || userInput >= size);
        return userInput;
    }
}
