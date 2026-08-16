public abstract class Player {
    private String name;
    private int guesses;
    private int catsFound;
    private int score;
    protected int size;
    public Player(String name, int size) {
        this.name = name;
        this.size = size;
        guesses = 0;
        catsFound = 0;
        score = 0;
    }
    public int getScore() {
        return score;
    }
    public void recordGuess(GuessResult result) {
        guesses += 1;
        score += result.getScore();
        if (result == GuessResult.CORRECT) {
            catsFound += 1;
        }
    }
    public boolean allCatsFound(int numberOfCats) {
        return (numberOfCats == catsFound);
    }
    public void printStatistics() {
        System.out.printf("Player: %s\nNumber of guesses: %d\nCats found: %d\nScore: %d\n", name, guesses, catsFound, score);
    }
    abstract Position makeGuess();
    public String toString() {
        return String.format("%s (Score: %d)", name, score);
    }
}
