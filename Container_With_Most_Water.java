//************************************************************
//                  1. naive method
//************************************************************
public class Solution {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int maxarea = Integer.MIN_VALUE;
		int maxheight = Integer.MIN_VALUE;
		for( int i = 0; i < height.length - 1; ++i )
		{
			int j = height.length - 1;
			if( maxheight < height[i] )
				maxheight = height[i];
			else continue;
			while( i < j )
			{
				int area = Math.min( height[i], height[j] ) * ( j - i );
				if( area > maxarea ) maxarea = area;
				j--;
				if( height[i] <= height[j] )
					break;
			}
			int area = height[i] * ( j - i );
			if( area > maxarea ) maxarea = area;
		}
		return maxarea;
	}
}

//************************************************************
//                  2. better method
//************************************************************
public class Solution {
  public int maxArea(int[] height) {
    int maxarea = Integer.MIN_VALUE;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      maxarea = Math.max(maxarea, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxarea;
  }  
}
