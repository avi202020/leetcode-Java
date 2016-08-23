// Solution 1. Naive solution
public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    for (int i = 1; i < nums.length; ++i) {
      dp[i] = 1;
      for (int j = i; j >= 0; j--) {
        if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < dp.length; ++i) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
