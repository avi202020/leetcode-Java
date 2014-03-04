public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        if( m == 0 ) return false;
        int n = board[0].length;
        int[][] dir = new int[][]{ { -1, 0 },{ 1, 0 },{ 0, 1 }, { 0, -1 } };
        for( int i = 0; i < m; ++i )
        {
            for( int j = 0; j < n; ++j )
            {
                if( board[i][j] == word.charAt(0) )
                {
                    boolean found = false;
                    boolean[][] visit = new boolean[m][n];
                    found = dfs( board, visit, word, dir, i, j, 0 );
                    if( found == true ) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs( char[][] board, boolean[][] visit, String word, int[][] dir, int x, int y, int depth )
    {
        if( board[x][y] == word.charAt(depth) )
        {
            if( depth == word.length() - 1 ) 
                return true;
            visit[x][y] = true;
            for( int i = 0; i < 4; ++i )
            {
                int cx = x + dir[i][0];
                int cy = y + dir[i][1];
                if( cx < 0 || cx >= board.length ) continue;
                if( cy < 0 || cy >= board[0].length ) continue;
                if( true == visit[cx][cy] ) continue;
                boolean flag = dfs( board, visit, word, dir, cx, cy, depth + 1 );
                if( true == flag ) return true;
            }
            visit[x][y] = false;
        }
        return false;
    }
}
