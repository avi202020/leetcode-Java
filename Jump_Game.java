public class Solution {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int cur = 0;
		int max = 0;
		while( cur <= max ) {
			if( cur + A[cur] > max )
				max = cur + A[cur];
			if( max >= A.length - 1 )
				return true;
			cur++;
		}
		return false;
	}
}
