public class Solution {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = Integer.MIN_VALUE;
		for( int i = 0; i < height.length - 1; ++i )
		{
			int j = height.length - 1;
			while( i < j )
			{
				int area = Math.min( height[i], height[j] ) * ( j - i );
				if( area > max ) max = area;
				j--;
				if( height[i] <= height[j] )
					break;
			}
			int area = height[i] * ( j - i );
			if( area > max ) max = area;
		}
		return max;
	}
}
