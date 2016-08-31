public class Solution {
  public void moveZeroes(int[] nums) {
    int index = 0;
    int cur = 0;
    while (cur < nums.length) {
      if (nums[cur] != 0) {
        int tmp = nums[index];
        nums[index] = nums[cur];
        nums[cur] = tmp;
        index++;
      }
      cur++;
    }
  }
}
