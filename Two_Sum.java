public class Solution {
  public int[] twoSum1(int[] nums, int target) {
    int[] res = new int[2];
    Map<Integer, Integer> positions = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; ++i) {
      int diff = target - nums[i];
      if (positions.containsKey(diff)) {
        res[0] = positions.get(diff);
        res[1] = i;
        break;
      }
      if (!positions.containsKey(nums[i])) {
        positions.put(nums[i], i);
      }
    }
    return res;
  }
}
