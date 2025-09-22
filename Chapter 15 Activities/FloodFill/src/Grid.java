import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    
    private  int count = 0;
    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {   
        Stack<Pair> pairs = new Stack<>();
        pairs.push(new Pair(row, column));
        
        while(pairs.size() != 0)
        {
            Pair pair = pairs.pop();
            int r = pair.getRow();
            int c = pair.getColumn();
            
            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE)
            {
                continue;
            }
            
            if (pixels[r][c] == 0)
            {
                pixels[r][c] = ++count;
               
                
                pairs.push(new Pair(r - 1, c)); //up
                pairs.push(new Pair(r, c - 1)); //left
                pairs.push(new Pair(r, c + 1)); //right
                pairs.push(new Pair(r + 1, c)); //down
                
                
                
                
                
                
            }
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
