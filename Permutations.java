public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    permuteHelper(nums, 0, res);
    return res;
  }
  private void permuteHelper(int[] nums, int depth, List<List<Integer>> res) {
    if (depth >= nums.length) {
      List<Integer> line = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; ++i) {
        line.add(nums[i]);
      }
      res.add(line);
      return;
    }
    for (int i = depth; i < nums.length; ++i ) {
      int tmp = nums[depth];
      nums[depth] = nums[i];
      nums[i] = tmp;
      permuteHelper(nums, depth + 1, res);
      tmp = nums[depth];
      nums[depth] = nums[i];
      nums[i] = tmp;
    }
  }
}
