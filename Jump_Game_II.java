public class Solution {
  public int jump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }
    int count = 0;
    int cur = 0;
    while (cur < nums.length - 1) {
      int maxPosition = cur + nums[cur];
      if (maxPosition >= nums.length - 1) {
        return count + 1;
      }
      int max = 0;
      for (int i = cur + 1; i <= maxPosition; ++i) {
        if (i + nums[i] > max) {
          max = i + nums[i];
          cur = i;
        }
      }
      count++;
    }
    return count;
  }
}
