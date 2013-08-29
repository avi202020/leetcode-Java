public class Solution {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( str == null || str.equals("") )
			return 0;
		long ans = 0;
		int index = 0;
		boolean positive = true;
		while( str.charAt(index) == ' ' )
			index++;
		if( str.charAt(index) == '-' ) {
			positive = false;
			index++;
		}
		else if( str.charAt(index) == '+' ) {
			positive = true;
			index++;
		}
		while( index < str.length() ) {
			if( !Character.isDigit( str.charAt(index) ) )
				break;
			int num = (int)( str.charAt(index) - '0' );
			ans = ans * 10 + num;
			index++;
		}
		if( positive == false )
			ans = -ans;
		if( ans > Integer.MAX_VALUE )
			return Integer.MAX_VALUE;
		else if( ans < Integer.MIN_VALUE )
			return Integer.MIN_VALUE;
		return (int)ans;
	}
}
