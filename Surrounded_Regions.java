//******************************************************
//          get a TLE in the big test
//******************************************************

public class Solution {
	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( board.length == 0 ) return;
		int m = board.length;
		int n = board[0].length;
		boolean[][] visit = new boolean[m][n];
		int[][] dir = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0} };
		for( int i = 0; i < m; ++i )
			for( int j = 0; j < n; ++j )
				visit[i][j] = false;
		for( int i = 0; i < m; ++i )
		{
			for( int j = 0; j < n; ++j )
			{
				if( i == 0 || j == 0 || i == m - 1 || j == n - 1 )
				{
					if( board[i][j] == 'O' )
						dfs( board, visit, dir, i, j );
				}
			}
		}
		for( int i = 0; i < m; ++i )
		{
			for( int j = 0; j < n; ++j )
			{
				if( visit[i][j] == false )
					board[i][j] = 'X';
			}
		}
	}
	public void dfs( char[][] board, boolean[][] visit, int[][] dir, int x, int y )
	{
		visit[x][y] = true;
		for( int i = 0; i < 4; ++i )
		{
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if( nx < 0 || nx >= board.length )
				continue;
			if( ny < 0 || ny >= board.length )
				continue;
			if( visit[nx][ny] == true )
				continue;
			if( board[nx][ny] == 'X' )
				continue;
			dfs( board, visit, dir, nx, ny );
		}
	}
}
