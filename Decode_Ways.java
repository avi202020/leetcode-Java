public class Solution {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( s.length() == 0 ) return 0;
		if( s.charAt(0) == '0' ) return 0;
		int[] dp = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1; 
		for( int i = 2; i <= s.length(); ++i )
		{
			int tmp = 0;
			if( s.charAt(i-1) != '0' )
				tmp += dp[i-1];
			if( (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0') >= 10 
					&& (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0') <= 26 )
				tmp += dp[i-2];
			dp[i] = tmp;
		}
		return dp[s.length()];
	} 
}
