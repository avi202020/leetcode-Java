// Naive method using DFS. Got a TLE
public class Solution {
	public int ans;
	public int numDistinct(String S, String T) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if( S.length() < T.length() ) return 0;
		else if( S.equals(T) ) return 1;
		StringBuilder sb = new StringBuilder();
		ans = 0;
		dfs( S, T, sb, 0 );
		return ans;
	}
	public void dfs( String S, String T, StringBuilder sb, int depth ) {
		if( depth >= S.length() ) {
			if( sb.toString().equals(T) )
				ans++;
			return;
		}
		// go on to next position
		if( sb.length() < T.length() ) {
			sb.append( S.charAt(depth) );
			dfs( S, T, sb, depth + 1 );
			sb.deleteCharAt( sb.length() - 1 );
		}
		// delete S.charAt(depth)
		dfs( S, T, sb, depth + 1 );
	}
}


// Solution 2. DP
public class Solution {
    public int numDistinct(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if( S.length() < T.length() ) return 0;
        else if( S.equals(T) ) return 1;
        int m = T.length();
        int n = S.length();
        int dp[][] = new int[m+1][n+1];
        for( int i = 0; i < m; ++i )
            dp[i][0] = 0;
        for( int i = 0; i < n; ++i )
            dp[0][i] = 1;
        for( int i = 1; i <= m; ++i ) {
            for( int j = 1; j <= n; ++j ) {
                dp[i][j] = dp[i][j-1];
                if( T.charAt(i-1) == S.charAt(j-1) )
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[T.length()][S.length()];
    }
}
