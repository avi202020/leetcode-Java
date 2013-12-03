
// Solution 1. naive method. time complexity O(n^2) 
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


//Solution 2. Manacher algorithm. time complexity O(n)
public class Solution {
    public String longestPalindrome(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int id = 0;
    	int maxid = 0;
    	int ans = 1;
    	int anscenter = 0;
    	StringBuilder sb = new StringBuilder();
    	sb.append("$#");
    	for( int i = 0; i < str.length(); ++i ) {
    		sb.append(str.charAt(i));
    		sb.append('#');
    	}
    	String s = sb.toString();
    	int[] p = new int[s.length()];
    	for( int i = 1; i < s.length(); ++i ) {
    		if( maxid > i ) {
    			p[i] = Math.min( p[2*id-i], maxid - i );
    		}
    		else {
    			p[i] = 1;
    		}
    		while( i + p[i] < s.length() && s.charAt(i+p[i]) == s.charAt(i-p[i]) )
    			p[i]++;
    		if( i + p[i] > maxid ) {
    			id = i;
    			maxid = i + p[i];
    		}
    		if( p[i] > ans ) { 
    			ans = p[i];
    			anscenter = i;
    		}
    	}
    	s = s.substring( anscenter - ans + 1,  anscenter + ans );
    	s = s.replaceAll("#","");
    	return s;
    }
}
