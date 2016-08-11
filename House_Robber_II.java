public class Solution {
  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length + 1];
    // case 1. steal the first house
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 2; i < nums.length; ++i) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
    }
    int value1 = dp[nums.length - 1];
    // case 2. will not steal the first house
    dp[1] = 0;
    for (int i = 2; i <= nums.length; ++i) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
    }
    int value2 = dp[nums.length];
    return Math.max(value1, value2);
  }
}
