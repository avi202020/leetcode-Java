// solution 1.
public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return rst;
    }
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<Integer>();
    subsetsHelper(rst, list, nums, 0);
    return rst;
  }

  public void subsetsHelper(List<List<Integer>> rst, List<Integer> list, int[] nums, int pos) {
    List<Integer> tmp = new ArrayList<Integer>();
    for (int num : list) {
      tmp.add(num);
    }
    rst.add(tmp);

    for (int i = pos; i < nums.length; i++) {
      list.add(nums[i]);
      subsetsHelper(rst, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}


// solution 2.
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
