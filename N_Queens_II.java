public class Solution {
	public int count;
	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] queen = new int[n];
		this.count = 0;
		dfs( queen, 0 );
		return this.count;
	}

	public void dfs( int[] queen, int depth )
	{
		int maxd = queen.length;
		if( depth >= maxd )
			this.count++;
		for( int i = 0; i < maxd; ++i )
		{
			if( check( queen, depth, i ) )
			{
				queen[depth] = i;
				dfs( queen, depth + 1 );
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
