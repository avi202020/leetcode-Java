public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( matrix.length == 0 ) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = n - 1;
		while( x < m && y >= 0 )
		{
			if( matrix[x][y] > target )
				y--;
			else if( matrix[x][y] < target )
				x++;
			else if( matrix[x][y] == target )
				return true;
		}
		return false;
	}
}



// Solution 2. totally a Binary Search
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if( matrix.length == 0 )
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0;
		int right = m * n - 1;
		while( left <= right ) {
			int mid = ( left + right ) / 2;
			int row = mid / n;
			int col = mid % n;
			if( target > matrix[row][col] )
				left = mid + 1;
			else if( target < matrix[row][col] )
				right = mid - 1;
			else if( target == matrix[row][col] )
				return true;
		}
		return false;
	}
}
