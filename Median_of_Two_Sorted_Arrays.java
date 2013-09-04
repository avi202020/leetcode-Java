//  1. This is a BRUTE FORCE solution
public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int m = B.length;
		double[] C = new double[n+m];
		int index = 0;
		for( int i = 0; i < n; ++i )
			C[index++] = A[i];
		for( int i = 0; i < m; ++i )
			C[index++] = B[i];
		Arrays.sort(C);
		if( C.length % 2 != 0 )
			return C[C.length/2];
		double ans1 = C[C.length/2-1];
		double ans2 = C[C.length/2];
		return ( ans1 + ans2 ) / 2;
	}
}


//  2. Better solution
