public class Solution {
  public int numTrees(int n) {
    if (n <= 1) {
      return 1;
    }
    int[] dp = new int[n+1];
    dp[0] = 1;
    for (int i = 1; i <= n; ++i) {
      int sum = 0;
      for (int j = 0; j < i; ++j) {
        int left = j;
        int right = i - j - 1;
        sum = sum + dp[left] * dp[right];
      }
      dp[i] = sum;
    }
    return dp[n];
  }
}
