public class Solution {
  public int coinChange(int[] coins, int amount) {
    int dp[] = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        int value = coins[j];
        if (i - value >= 0 && dp[i - value] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - value] + 1);
        }
      }
    }
    if (dp[amount] == Integer.MAX_VALUE) {
      return -1;
    }
    return dp[amount];
  }
}

