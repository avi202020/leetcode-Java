public class Solution {
	public final int[][] dir = { {1,0},{0,1} ,{-1,0},{0,-1}};
	public void solve(char[][] board) {
    	// Start typing your Java solution below
    	// DO NOT write main() function
    	int row = board.length;
    	if( row == 0 ) return;
    	int col = board[0].length;
    	for( int i = 0; i < row; ++i )
    	{
    		for( int j = 0; j < col; ++j )
    		{
    			if( board[i][j] == 'O' )
    			{
    				boolean[][] visit = new boolean[row][col];
    				boolean ok = dfs( board, visit, i, j );
    				if( ok ) color( board, visit );
    			}
    		}
    	}
    }
	public boolean dfs( char[][] board, boolean[][] visit, int x,int y )
	{
		if( x < 0 || x >= board.length ) return false;
		if( y < 0 || y >= board[0].length ) return false;
		if( board[x][y] == 'X' ) return true;
		if( visit[x][y] == true ) return true;
		if( board[x][y] == 'O' )
		{
			visit[x][y] = true;
			for( int i = 0; i < 4; ++i )
			{
				int cx = x + dir[i][0];
				int cy = y + dir[i][1];
				boolean tmp = dfs( board, visit, cx, cy );
				if( tmp == false ) return false;
			}
		}
		return true;
	}
	public void color( char[][] board, boolean[][] visit )
	{
		for( int i = 0; i < board.length; ++i )
			for( int j = 0; j < board[0].length; ++j )
				if( visit[i][j] ) board[i][j] = 'X';
	}
}



public int minSwap(int[] array) {
	if (array == null || array.length < 2)
		return 0;

	int minSwap = 0;
	int target = 1, index = 0;
	while (index < array.length) {
		if (array[index] == target) {
			index++;
			target++;
		} else {
			minSwap++;
			index++;
		}
	}

	return minSwap;
}
