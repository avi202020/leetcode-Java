public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
    sums.put(0, 0);
    int sum = 0;
    int max = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum = sum + nums[i];
      if (!sums.containsKey(sum)) {
        sums.put(sum, i + 1);
      }
      int diff = sum - k;
      if (sums.containsKey(diff)) {
        int position = sums.get(diff);
        max = Math.max(max, i - position + 1);
      }
    }
    return max;
  }
}
