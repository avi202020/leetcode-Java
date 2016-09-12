// Solution 1. recursive solution
public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ans;
    }
    permute(ans, nums, 0);
    return ans;
  }

  private void permute(List<List<Integer>> ans, int[] nums, int index) {
    if (index == nums.length) {
      List<Integer> temp = new ArrayList<>();
      for (int num : nums) {
        temp.add(num);
      }
      ans.add(temp);
      return;
    }
    Set<Integer> appeared = new HashSet<>();
    for (int i = index; i < nums.length; ++i) {
      if (appeared.add(nums[i])) {
        swap(nums, index, i);
        permute(ans, nums, index + 1);
        swap(nums, index, i);
      }
    }
  }
  private void swap(int[] nums, int i, int j) {
    int save = nums[i];
    nums[i] = nums[j];
    nums[j] = save;
  }
}

// Solution 2. iterative solution
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
