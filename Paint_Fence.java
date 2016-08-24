// Solution 1.
public class Solution {
  public int numWays(int n, int k) {
    if (n == 0 || k == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    int[] dp = new int[n + 1];
    dp[1] = k;
    dp[2]= k + k * (k - 1);
    for (int i = 3; i <= n; i++) {
      // (k - 1) * dp[i - 2] means that (i) and (i-1) are same, (i-1) and (i-2) are different 
      // (k - 1) * dp[i - 1] means that (i) and (i-1) are different
      dp[i] = (k - 1) * dp[i - 2] + (k - 1) * dp[i - 1];
    }
    return dp[n];
  }
}

// Solution 2.
public class Solution {
  public int numWays(int n, int k) {
    if (n == 0 || k == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    int sameCount = k;
    int diffCount = k * (k - 1);
    for (int i = 3; i <= n; i++) {
      int temp = diffCount;
      diffCount = diffCount * (k - 1) + sameCount * (k - 1);
      sameCount = temp;
    }
    return sameCount + diffCount;
  }
}
