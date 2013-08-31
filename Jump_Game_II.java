public class Solution {
	public int jump( int A[] ) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int jump = 0;
		int i = 0;
		while( i < A.length - 1 ) {
			int maxpos = i + A[i];
			if( maxpos >= A.length - 1 )
				return jump + 1;
			int maxstep = 0;
			for( int j = i + 1; j <= maxpos; ++j ) {
				if( j + A[j] > maxstep ) {
					maxstep = j + A[j];
					i = j;
				}
			}
			jump++;
		}
		return jump;
	}
}
