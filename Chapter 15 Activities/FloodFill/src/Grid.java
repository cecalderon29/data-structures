import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    private Stack<Pair> pair = new Stack<>();
    private  int count = 0;
    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        
        Pair pair1 = new Pair(row, column);
        pair.push(pair1);

        if (row > 0 && pixels[row][pair1.getUpper()] == 0)
        {
            floodfill(row, pair1.getUpper());
        }
        if (row < 10 && pixels[row][pair1.getLower()] == 0)
        {
            floodfill(row, pair1.getLower());
        }
        if(column > 0 && pixels[pair1.getLeft()][column] == 0)
        {
            floodfill( pair1.getLeft(), row);
        }
        if (column < 10 && pixels[pair1.getRight()][column] == 0)
        {
            floodfill(pair1.getRight(), column);
        }
       
        
        Pair pair2 = pair.pop();

        int row1 = pair2.getRow();
        int column1 = pair2.getColumn();
        if ( pixels[row1][column1] == 0)
        {
            pixels[row1][column1] = ++count;
        }
        
        if (pair.size() == 0)
        {
            return;
        }

    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
