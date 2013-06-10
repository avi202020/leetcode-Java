public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> ans = new ArrayList<String[]>();
		int[] queen = new int[n];
		dfs( ans, queen, n, 0 );
		return ans;
	}

	public void dfs( ArrayList<String[]> ans, int[] queen, int maxd, int depth )
	{
		if( depth >= maxd )
		{
			String[] board = new String[maxd];
			for( int i = 0; i < maxd; ++i )
			{
				StringBuffer sb = new StringBuffer();
				for( int j = 0; j < maxd; ++j )
				{
					if( queen[i] == j )
						sb.append('Q');
					else 
						sb.append('.');
				}
				board[i] = sb.toString();
			}
			ans.add(board);
		}
		for( int i = 0; i < maxd; ++i )
		{
			if( check( queen, depth, i ) )
			{
				queen[depth] = i;
				dfs( ans, queen, maxd, depth + 1 );
			}
		}
	}

	public boolean check( int[] queen, int x, int y )
	{
		for( int i = 0; i < x; ++i )
		{
			if( queen[i] == y ) 
				return false;
			else if( Math.abs( queen[i] - y ) == Math.abs( x - i ) )
				return false;
		}
		return true;
	}
}
