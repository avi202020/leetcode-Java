public class Solution {
  public int firstMissingPositive(int[] nums) {
    int index = 0;
    int n = nums.length;
    while (index < n) {
      if (nums[index] < 1 || nums[index] >= n || nums[index] == index + 1) {
        index++;
      } else if (nums[index] != index + 1) {
        if (nums[nums[index]-1] != nums[index]) {
          int pos = nums[index] - 1;
          int tmp = nums[index];
          nums[index] = nums[pos];
          nums[pos] = tmp;
        } else {
          index++;
        }
      }
    }
    for (int i = 0; i < n; ++i) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;
  }
}
