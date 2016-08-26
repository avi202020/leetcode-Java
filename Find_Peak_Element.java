// Solution 1. binary search
public class Solution {
  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= nums[mid + 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}


// Solution 2. linear search
public class Solution {
  public int findPeakElement(int[] num) {
    if( num.length == 1 )
      return 0;
    for( int i = 0; i < num.length; ++i ) {
      if( i == 0 ) {
        if( num[0] > num[1] )
          return 0;
      }
      else if( i == num.length - 1 && num[i] > num[i-1] )
        return i;
      else if( num[i] > num[i-1] && num[i] > num[i+1] )
        return i;
    }
    return 0;
  }
}
