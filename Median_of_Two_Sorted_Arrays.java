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
public class Solution {
  public double findMedianSortedArrays(int A[], int B[]) {
    int len = A.length + B.length;
    if( len % 2 == 0 ) {
      return ( findKth(A, 0, B, 0, len/2) + findKth(A, 0, B, 0, len/2 + 1) ) / 2.0;
    }
    return findKth(A, 0, B, 0, len/2 + 1);
  }
  public double findKth(int[] A, int startA, int[] B, int startB, int k) {
    if( startA >= A.length )
      return B[startB + k - 1];
    if( startB >= B.length )
      return A[startA + k - 1];

    if( k == 1 ) {
      return Math.min(A[startA], B[startB]);
    }

    int keyA = startA + k/2 - 1 < A.length ? A[startA + k/2 - 1] : Integer.MAX_VALUE;
    int keyB = startB + k/2 - 1 < B.length ? B[startB + k/2 - 1] : Integer.MAX_VALUE;
    if( keyA < keyB ) {
      return findKth(A, startA + k/2, B, startB, k - k/2 );
    } else {
      return findKth(A, startA, B, startB + k/2, k - k/2 );
    }
  }
}
