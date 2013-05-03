//************************************************************************
//       1. naive method O(n^3)
//       C++ code can pass both tests, Java code cannot pass big test
//************************************************************************

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0;
		if( matrix.length == 0 ) return max;
		int[][] m = new int[matrix.length][matrix[0].length];
		for( int i = 0; i < matrix.length; ++i )
		{
			for( int j = 0; j < matrix[0].length; ++j )
			{
				if( i == 0 ) m[i][j] = ( matrix[i][j] == '1' ? 1 : 0 );
				else m[i][j] = ( matrix[i][j] == '1' ? m[i-1][j] + 1 : 0 );
			}
		}
		for (int i = 0; i < matrix.length; ++i)  
		{  
			for (int j = 0; j < matrix[0].length; ++j)  
			{  
				int minWidth = m[i][j];    
				for (int k = j; k < matrix[0].length; ++k)  
				{  
					minWidth = minWidth <  m[i][k] ? minWidth : m[i][k];  
					max = max > minWidth*(k-j+1) ? max : minWidth*(k-j+1);  
				}  
			}  
		}
		return max;
	}
}


//************************************************************************
//       2. better method O(n^2)
//       C++ code can pass both tests, Java code cannot pass big test
//       I don't know what the hell is going on.
//************************************************************************

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0;
		if( matrix.length == 0 ) return max;
		int[][] m = new int[matrix.length][matrix[0].length];
		for( int i = 0; i < matrix.length; ++i )
		{
			for( int j = 0; j < matrix[0].length; ++j )
			{
				if( i == 0 ) m[i][j] = ( matrix[i][j] == '1' ? 1 : 0 );
				else m[i][j] = ( matrix[i][j] == '1' ? m[i-1][j] + 1 : 0 );
			}
		}
		for( int i = 0; i < matrix.length; ++i )
		{
			int area = largestRectangleArea( m[i] );
			if( area > max ) max = area;
		}
		return max;
	}
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int ans = 0;
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		for( int i = 0; i < height.length; ++i )
		{
			if( heights.isEmpty() || height[i] > heights.peek() )
			{
				indexes.push(i);
				heights.push( height[i] );
			}
			else if( height[i] < heights.peek() )
			{
				int lastIndex = 0;
				while( !heights.isEmpty() && height[i] < heights.peek() )
				{
					lastIndex = indexes.pop();
					int tmp = heights.pop() * ( i - lastIndex );
					if( ans < tmp ) ans = tmp;
				}
				heights.push( height[i] );
				indexes.push( lastIndex );
			}
		}
		while( !heights.isEmpty() )
		{
			int tmp = heights.pop() * ( height.length - indexes.pop() );
			if( ans < tmp ) ans = tmp;
		}
		return ans;
	}
}
