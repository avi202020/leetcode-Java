public class Solution {
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( x == 0 || x == 1 )
			return x;
		double left = 0;
		double right = x;
		double epsilon = 0.01;
		while( true )
		{
			double mid = ( left + right ) / 2;
			double sqare = mid * mid;
			if( Math.abs( sqare - x ) < epsilon )
				return (int) mid;
			else if( sqare > x )
				right = mid;
			else if( sqare < x )
				left = mid;
		}
	}
}
