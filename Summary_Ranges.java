public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<String>();
    if (nums == null || nums.length == 0) {
        return res;
    }
    int cur = 1;
    int left = 0;
    int right = 0;
    while (cur < nums.length) {
      if (nums[cur] == nums[cur - 1] + 1) {
        right = cur;
      } else {
        if (left == right) {
          res.add("" + nums[left]);
        } else {
          res.add(nums[left] + "->" + nums[right]);
        }
        left = cur;
        right = cur;
      }
      cur++;
    }
    if (left == right) {
      res.add("" + nums[left]);
    } else {
      res.add(nums[left] + "->" + nums[right]);
    }
    return res;
  }

}
