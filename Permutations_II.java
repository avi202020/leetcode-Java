public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    List<Integer> buffer = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; ++i) {
      buffer.add(nums[i]);
    }
    ans.add(buffer);
    while (true) {
      int i = nums.length - 1;
      while (i >= 1 && nums[i] <= nums[i-1]) {
        i--;
      }
      if (i == 0) {
        break;
      }
      int j = nums.length - 1;
      while (nums[j] <= nums[i-1]) {
        j--;
      }
      int tmp = nums[i-1];
      nums[i-1] = nums[j];
      nums[j] = tmp;
      j = nums.length - 1;
      while (i < j) {
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
      }
      buffer = new ArrayList<Integer>();
      for (i = 0; i < nums.length; ++i) {
        buffer.add(nums[i]);
      }
      ans.add(buffer);
    }
    return ans;
  }
}
