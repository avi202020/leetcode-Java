public class Solution {
  public boolean canJump(int[] nums) {
    int max = nums[0];
    int left = 0;
    while (left <= max) {
      max = Math.max(max, left + nums[left]);
      if (max >= nums.length - 1) {
        return true;
      }
      left++;
    }
    return false;
  }
}
