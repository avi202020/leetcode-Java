public class Solution {
	public int longestValidParentheses(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if( s.equals("") || s == null || s.length() == 1 )
			return 0;
		int[] dp = new int[s.length()];
		for( int i = 0; i < s.length(); ++i ) {
			dp[i] = 0;
		}
		int n = s.length();
		for (int i = 1; i < n; ++i ) {
			if (s.charAt(i) == ')') {
				int pre = i - 1 - dp[i - 1];
				if ( pre >= 0 && s.charAt(pre) == '(') {
					dp[i] = dp[i - 1] + 2;
					if ( pre - 1 > 0 ) {
						dp[i] += dp[pre - 1];
					}
				}
			}
		}
		int max = 0;
		for( int i = 0; i < s.length(); ++i )
			if( max < dp[i] ) max = dp[i];
		return max;
	}
}
