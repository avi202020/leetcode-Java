public class Solution {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int maxsum = 0;
		for( int i = 0; i < A.length; ++i )
		{
			if( A[i] > max ) max = A[i];
			sum += A[i];
			if( sum < 0 ) sum = 0;
			if( sum > maxsum ) maxsum = sum;
		}
		if( max < 0 ) return max;
		return maxsum;
	}
}
