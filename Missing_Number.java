// Solution 1.
public class Solution {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = n * (n + 1) / 2;
    for (int i = 0; i < n; ++i) {
      sum = sum - nums[i];
    }
    return sum;
  }
}

// Solution 2.
public class Solution {
  public int missingNumber(int[] nums) {
    int res = 0;
    for (int i = 0; i <= nums.length; ++i) {
      res = res ^ i;
    }
    for (int i = 0; i < nums.length; ++i) {
      res = res ^ nums[i];
    }
    return res;
  }
}
