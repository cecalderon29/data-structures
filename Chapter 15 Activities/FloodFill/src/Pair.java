public class Pair {
    private int row;
    private int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getUpper(){
        return row - 1;
    }
    public int getLower(){
        return row + 1;
    }
    public int getLeft(){
        return column - 1;
    }
    public int getRight(){
        return column + 1;
    }
    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
