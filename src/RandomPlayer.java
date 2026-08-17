import java.util.Random;

public class RandomPlayer extends Player {
    private Random random;

    public RandomPlayer(String name, int size, int seed) {
        super(name, size);
        random = new Random(seed);
    }

    @Override
    public Position makeGuess() {
        int row = random.nextInt(size);
        int column = random.nextInt(size);
        return new Position(row, column);
    }
}
