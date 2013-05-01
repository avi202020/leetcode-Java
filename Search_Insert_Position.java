public class Solution {
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( target <= A[0] ) 
			return 0;
		if( target > A[A.length-1] ) 
			return A.length;
		int left = 0;
		int right = A.length - 1;
		int mid = 0;
		while( left <= right )
		{
			mid = ( left + right ) / 2;
			if( target <= A[mid] && target > A[mid-1] )
				return mid;
			else if( A[mid] < target )
				left = mid + 1;
			else if( A[mid] >= target )
				right = mid - 1;
		}
		return mid;
	}
}
