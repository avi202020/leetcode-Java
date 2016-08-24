// Solution 1.
public class Solution {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;
    if (len <= 2) {
      return;
    }
    for (int i = 1; i < len - 1; i = i + 2) {
      int temp = nums[i];
      nums[i] = nums[i+1];
      nums[i+1] = temp;
    }
    return;
  }
}

// Solution 2.
public class Solution {
  public void wiggleSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (i % 2 == 1) {
        if (nums[i-1] > nums[i])
            swap(nums, i, i-1);
      } else{
        if (nums[i] > nums[i-1])
            swap(nums, i, i-1);
      } 
    }
  }
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
