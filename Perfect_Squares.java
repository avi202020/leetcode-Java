public class Solution {
  public int numSquares(int n) {
    if (n < 1) {
      return 0;
    }
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int tmp = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        tmp = Math.min(tmp, dp[i - j * j] + 1);
      }
      dp[i] = tmp;
    }
    return dp[n];
  }
}
