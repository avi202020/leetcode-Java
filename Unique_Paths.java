public class Solution {
	public int uniquePaths(int m, int n) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		int[][] dp = new int[m][n];
		for( int i = 0; i < m; ++i )
		{
			for( int j = 0; j < n; ++j )
			{
				if( 0 == i || 0 == j )
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
}
