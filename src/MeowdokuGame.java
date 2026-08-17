public class MeowdokuGame {
    private int numberOfCats;
    private GameBoard board;
    private Player player;

    public MeowdokuGame(Player player, int size) {
        this.player = player;
        board = new GameBoard(size);
        numberOfCats = size;
    }

    public void play() {
        while (!player.allCatsFound(numberOfCats)) {
            //Show the current board
            System.out.println(board);
            GuessResult playerGuessResult = board.checkGuess(player.makeGuess());
            player.recordGuess(playerGuessResult);
            System.out.println(playerGuessResult.getMessage());
            System.out.println("Score: " + player.getScore());
        }
        System.out.println("Congratulations!");
        player.printStatistics();
    }
}
