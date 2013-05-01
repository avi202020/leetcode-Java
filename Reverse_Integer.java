public class Solution {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean pos = true;
		if( x < 0 ) pos = false;
		x = x < 0 ? -x : x;
		int ans = 0;
		while( x != 0 )
		{
			int num = x % 10;
			x = x / 10;
			ans = ans * 10 + num;
		}
		if( pos == false )
			ans = -ans;
		return ans;
	}
}
