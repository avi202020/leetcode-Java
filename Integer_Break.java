// Solution 1. 
public class Solution {
  public int integerBreak(int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    if (n == 4) {
      return 4;
    }
    int result = 1;
    while (n > 4) {
      result *= 3;
      n -= 3;
    }
    result *= n;
    return result;
  }
}

// Solution 2. DP
public class Solution {
  public int integerBreak(int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    if (n == 4) {
      return 4;
    }
    int[] dp = new int[n+1];
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 4;
    for (int i = 5; i <= n; ++i) {
      dp[i] = dp[i - 3] * 3;
    }
    return dp[n];
  }
}
