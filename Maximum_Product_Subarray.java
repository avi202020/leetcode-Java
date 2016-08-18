public class Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int ans = nums[0];
    int maxPositive = nums[0];
    int minNegative = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      int nextMax = Math.max(nums[i] * maxPositive, Math.max(nums[i] * minNegative, nums[i]));
      int nextMin = Math.min(nums[i] * minNegative, Math.min(nums[i] * maxPositive, nums[i]));
      maxPositive = nextMax;
      minNegative = nextMin;
      ans = Math.max(ans, maxPositive);
    }
    return ans;
  }
}
