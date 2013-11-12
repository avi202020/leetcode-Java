public class Solution {
	boolean success;
	public void solveSudoku(char[][] board) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][] cub = new boolean[9][10];
		for( int i = 0; i < 9; ++i ) {
			for( int j = 0; j < 10; ++j ) {
				row[i][j] = false;
				col[i][j] = false;
				cub[i][j] = false;
			}
		}
		for( int i = 0; i < board.length; ++i ) {
			for( int j = 0; j < board[0].length; ++j ) {
				if( board[i][j] == '.' )
					continue;
				int digit = (int)(board[i][j] - '0');
				row[i][digit] = true;
				col[j][digit] = true;
				int cubindex = i / 3 * 3 + j / 3;
				cub[cubindex][digit] = true;
			}
		}
		success = false;
		dfs( board, row, col, cub, 0 );
	}
	public void dfs( char[][] board, boolean[][] row, boolean[][] col, boolean[][] cub, int depth ) {
		if( depth >= 81 ) {
			success = true;
			return;
		}
		if( success == true )
			return;
		int x = depth / 9;
		int y = depth % 9;
		int z = x / 3 * 3 + y / 3;
		if( board[x][y] == '.' ) {
			for( int i = 1; i <= 9; ++i ) {
				char digit = (char)('0' + i);
				if( row[x][i] == true ) continue;
				if( col[y][i] == true ) continue;
				if( cub[z][i] == true ) continue;
				row[x][i] = true;
				col[y][i] = true;
				cub[z][i] = true;
				board[x][y] = digit;
				dfs( board, row, col, cub, depth + 1 );
				if( success )
					return;
				board[x][y] = '.';
				row[x][i] = false;
				col[y][i] = false;
				cub[z][i] = false;
			}
		} else {
			dfs( board, row, col, cub, depth + 1 );
		}
	}
}
