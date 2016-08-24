public class Solution {
  public boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] < nums[mid]) {
        if (target >= nums[left] && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[left] > nums[mid]) {
        if (target <= nums[right] && target >= nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (nums[left] == target) {
          return true;
        }
        while (nums[left] == nums[mid]) {
          left++;
          if (left > right)
            return false;
        }
      }
    }
    return false;
  }
}
