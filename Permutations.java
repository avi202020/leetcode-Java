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
      swap(nums, i, depth);
      permuteHelper(nums, depth + 1, res);
      swap(nums, i, depth);
    }
  }
  private void swap(int[] nums, int i, int j) {
    int save = nums[i];
    nums[i] = nums[j];
    nums[j] = save;
  }
}
