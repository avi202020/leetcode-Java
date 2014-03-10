public class Solution {
    public int trap(int[] A) {
        if( A.length <= 2 )
            return 0;
        int[] leftHighest = new int[A.length];
        int[] rightHighest = new int[A.length];
        int leftHigh = A[0];
        leftHighest[0] = 0;
        for( int i = 1; i < A.length; ++i ) {
            leftHighest[i] = leftHigh;
            if( A[i] > leftHigh ) {
                leftHigh = A[i];
            }
        }
        int rightHigh = A[A.length-1];
        rightHighest[A.length-1] = 0;
        for( int i = A.length - 2; i >= 0; --i ) {
            rightHighest[i] = rightHigh;
            if( A[i] > rightHigh ) {
                rightHigh = A[i];
            }
        }
        int ans = 0;
        for( int i = 0; i < A.length; ++i ) {
            if( Math.min( leftHighest[i], rightHighest[i] ) > A[i] )
                ans += Math.min( leftHighest[i], rightHighest[i] ) - A[i];
        }
        return ans;
    }
}
