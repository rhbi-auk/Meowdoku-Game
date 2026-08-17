public class SequentialPlayer extends Player {
    private int nextPosition;
    public SequentialPlayer(String name, int size) {
        super(name, size);
        nextPosition = 0;
    }

    @Override
    public Position makeGuess() {
        //modulus division of size
        //remainder = column value
        int newRow = nextPosition / size;
        if (newRow >= size) {
            nextPosition = 0;
            newRow = 0;
        }
        int newColumn = nextPosition % size;
        nextPosition += 1;
        return(new Position(newRow, newColumn));
    }
}
