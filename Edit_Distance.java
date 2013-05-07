public class Solution {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1+1][len2+1];
		for( int i = 0; i <= len1; ++i )
			dp[i][0] = i;
		for( int i = 0; i <= len2; ++i )
			dp[0][i] = i;
		for (int i = 1; i <= len1; ++i )
		{
			for (int j = 1; j <= len2; ++j )
			{
				int dist = dp[i-1][j-1] + ( word1.charAt(i-1) != word2.charAt(j-1) ? 1 : 0 );
				int tmp1 = dp[i-1][j] + 1;
				dist = dist < tmp1 ? dist : tmp1;
				int tmp2 = dp[i][j-1] + 1;
				dist = dist < tmp2 ? dist : tmp2;
				dp[i][j] = dist;
			}
		}
		return dp[len1][len2];
	}
}
