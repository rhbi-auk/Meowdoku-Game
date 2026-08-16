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
            //Store returned enum GuessResult
            GuessResult playerGuessResult = board.checkGuess(player.makeGuess());
            //Record the guess
            player.recordGuess(playerGuessResult);
            //Print playerGuessResult message
            System.out.println(playerGuessResult.getMessage());
            //Display current score
            System.out.println("Score: " + player.getScore());
        }
        System.out.println("Congratulations!");
        player.printStatistics();
    }
}
