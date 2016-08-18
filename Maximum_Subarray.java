public class Solution {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    int maxsum = 0;
    for (int i = 0; i < nums.length; ++i) {
      max = Math.max(max, nums[i]);
      sum += nums[i];
      sum = Math.max(0, sum);
      maxsum = Math.max(maxsum, sum);
    }
    if (max < 0) {
      return max;
    }
    return maxsum;
  }
}
