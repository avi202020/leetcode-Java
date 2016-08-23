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

// Solution 2
public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length+1];
    dp[1] = nums[0];
    int top = 1;
    for (int i = 1; i < nums.length; ++i) {
      int low = 1;
      int high = top;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (dp[mid] == nums[i]) {
          break;
        } else if (dp[mid] < nums[i]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      if (low <= high) {
        continue;
      } else if (high + 1 > top) {
        dp[++top] = nums[i];
      } else {
        dp[high + 1] = nums[i];
      }
    }
    return top;
  }
}
