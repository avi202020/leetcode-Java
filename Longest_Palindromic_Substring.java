public class Solution {
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String lps = s.substring(0,1); 
		for( int i = 0; i < s.length() - 1; ++i )
		{
			String tmp = expand( s, i, i );
			lps = tmp.length() > lps.length() ? tmp : lps;
			tmp = expand( s, i, i + 1 );
			lps = tmp.length() > lps.length() ? tmp : lps;
		}
		return lps;
	}
	public String expand( String str, int c1, int c2 )
	{
		int left = c1;
		int right = c2;
		while( left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right) )
		{
			left--;
			right++;
		}
		return str.substring( left + 1, right );
	}
}
