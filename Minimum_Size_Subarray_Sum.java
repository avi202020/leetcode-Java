public class Solution {
   public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int sum = 0;
    int len = nums.length;
    int res = Integer.MAX_VALUE;
    while (right < len) {
      while (sum < s && right < len) {
        sum += nums[right];
        right++;
      }
      while (sum >= s) {
        res = Math.min(res, right - left);
        sum -= nums[left];
        left++;
      }
    }
    if (res >= Integer.MAX_VALUE) {
      return 0;
    }
    return res;
  }
}
