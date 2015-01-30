public class Solution {
  public int maxProduct(int[] A) {
    if( A == null || A.length == 0 )
      return 0;
    int ans = A[0];
    int maxPositive = A[0];
    int minNegative = A[0];
    for( int i = 1; i < A.length; ++i ) {
      int next_max = Math.max( A[i] * maxPositive, Math.max(A[i] * minNegative, A[i] ) );
      int next_min = Math.min( A[i] * maxPositive, Math.min(A[i] * minNegative, A[i] ) );
      maxPositive = next_max;
      minNegative = next_min;
      ans = Math.max(ans, maxPositive);
    }
    return ans;
  }
}
