public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    List<Integer> line = new ArrayList<Integer>();
    Arrays.sort(nums);
    subsetsHelper(nums, 0, line, res);
    return res;
  }
  private void subsetsHelper(int[] nums, int depth, List<Integer> line, List<List<Integer>> res) {
    if (depth >= nums.length) {
      List<Integer> subset = new ArrayList<Integer>(line);
      res.add(subset);
      return;
    }
    subsetsHelper(nums, depth + 1, line, res);
    line.add(nums[depth]);
    subsetsHelper(nums, depth + 1, line, res);
    line.remove(line.size() - 1);
  }
}
