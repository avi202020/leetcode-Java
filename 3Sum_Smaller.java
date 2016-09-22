public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    int n = nums.length;
    if (n < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < n; i++) {
      int j = i + 1, k = n - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < target) {
          res += (k - j);
          j++;
        } else {
          k--;
        }
      }
    }
    return res;
  }
}
