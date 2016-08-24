// Solution 1. binary search worst case O(n) time
public class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] >= nums[left]) {
        if (target >= nums[left] && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid] <= nums[left]) {
        if (target >= nums[mid] && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}


// Solution 2.
public class Solution {
  public boolean search(int[] A, int target) {
    for (int i = 0; i < A.length; i ++) {
      if (A[i] == target) {
        return true;
      }
    }
    return false;
  }
}
