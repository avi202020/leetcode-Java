public class Solution {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean positive = true;
		if( n == 0 ) return 1;
		if( n < 0 ) {
			positive = false;
			n = -n;
		}
		double power = x;
		double ans = 1;
		while( n > 0 ) {
			if( n % 2 == 1 ) {
				ans = ans * power;
			}
			power = power * power;
			n = n / 2;
		}
		if( !positive )
			return 1/ans;
		return ans;
	}
}
