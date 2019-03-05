package nqueens;

import java.util.Arrays;

public class NQueens
{

    public static void main(String[] args)
    {
        new NQueens(8).SolveBacktracking();
    }
    
    private boolean[][] queens;
    private int n; //board dimension

    // initializes the board
    public NQueens(int n)
    {
        queens = new boolean[n][];
        for (int i = 0; i < n; i++)
        {
            queens[i] = new boolean[n];
        }
        this.n = n;
    }

    // driver method
    public void SolveBacktracking()
    {
        solveBacktracking(0);
    }

    private void solveBacktracking(int row)
    {
       
    }

    /**
     * ******** Helper methods *********
     */
    // counts the total number of queens on the board
    int countQueens()
    {
        int total = 0;
        for (int r = 0; r < n; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (queens[r][c])
                    total++;
            }
        }
        return total;
    }

    // check if there is no conflicting situation on the board
    boolean checkBoard()
    {
        // iterate through all rows
        for (int r = 0; r < n; r++)
        {
            int queenCol = -1;
            int nrOfQueens = 0;

            // check horizontally
            for (int c = 0; c < n; c++)
            {
                if (queens[r][c])
                {
                    nrOfQueens++;
                    queenCol = c;
                }
                if (nrOfQueens > 1)
                {
                    return false;
                }
                if (nrOfQueens > 0)
                {
                    // check column
                    for (int qr = r + 1; qr < n; qr++) //start from next row
                    {
                        if (queens[qr][queenCol])
                        {
                            return false; // there is another queen on this column
                        }
                    }

                    // check diagonal -> r
                    int dc = queenCol + 1;
                    for (int qr = r + 1; qr < n && dc < n; qr++) //start from next row
                    {
                        if (queens[qr][dc])
                        {
                            return false; // there is another queen on this column
                        }
                        dc++;
                    }
                    // check diagonal -> l
                    dc = queenCol - 1;
                    for (int qr = r + 1; qr < n && dc >= 0; qr++) //start from next row
                    {
                        if (queens[qr][dc])
                        {
                            return false; // there is another queen on this column
                        }
                        dc--;
                    }
                }
            }
        }
        return true;
    }

    public void print()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                String s = queens[i][j] ? "Q" : "-";
                System.out.print(s);
            }
            System.out.println();
        }
    }

}
