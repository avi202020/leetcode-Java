public class Solution {
	public boolean isValidSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][] cub = new boolean[9][10];
		for( int i = 0; i < 9; ++i )
		{
			for( int j = 0; j < 9; ++j )
			{
				if( board[i][j] == '.' )
					continue;
				int num = (int)(board[i][j] - '0');
				if( false == row[i][num] )
					row[i][num] = true;
				else return false;
				if( false == col[j][num] ) 
					col[j][num] = true;
				else return false;
				int cubindex = i / 3 * 3 + j / 3;
				if( false == cub[cubindex][num] )
					cub[cubindex][num] = true;
				else return false;
			}
		}
		return true;
	}
}
