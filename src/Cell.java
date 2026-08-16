public class Cell {
    private Colour colour;
    private CellState state;
    public Cell(Colour colour) {
        this.colour = colour;
        this.state = CellState.HIDDEN;
    }
    public CellState getState() {
        return state;
    }
    public void setState(CellState state) {
        this.state = state;
    }
    public String toString() {
        if (state == CellState.HIDDEN) {
            return "" + colour.toString().charAt(0);
        }
        else{
            return String.valueOf(state.getSymbol());
        }
    }
}


