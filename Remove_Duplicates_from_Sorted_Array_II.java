public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int cur = 1;
    int dup = 1;
    int last = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] != last) {
        last = nums[i];
        dup = 1;
        nums[cur] = nums[i];
        cur++;
      } else if (nums[i] == last && dup < 2) {
        dup++;
        nums[cur] = nums[i];
        cur++;
      }
    }
    return cur;
  }
}
