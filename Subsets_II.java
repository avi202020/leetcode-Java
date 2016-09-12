public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return rst;
    }
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<Integer>();
    subsetsWithDupHelper(rst, list, nums, 0);
    return rst;
  }

  public void subsetsWithDupHelper(List<List<Integer>> rst, List<Integer> list, int[] nums, int pos) {
    List<Integer> tmp = new ArrayList<Integer>();
    for (int num : list) {
      tmp.add(num);
    }
    rst.add(tmp);

    for (int i = pos; i < nums.length; i++) {
      if (i != pos && nums[i] == nums[i-1]) {
        continue;
      }
      list.add(nums[i]);
      subsetsWithDupHelper(rst, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
