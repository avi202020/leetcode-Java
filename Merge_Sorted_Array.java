public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int indexA = m - 1;
		int indexB = n - 1;
		int index = m + n - 1;
		while( indexA >= 0 && indexB >= 0 )
			A[index--] = ( A[indexA] >= B[indexB] ? A[indexA--] : B[indexB--] );
		for( int i = 0; i <= indexB; ++i )
			A[i] = B[i];
	}
}
