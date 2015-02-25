public class Solution {
  public void rotate(int[] nums, int k) {
    if( nums.length == 1 ) return;
    k = k % nums.length;
    rotateHelper( nums, 0, nums.length - 1 );
    rotateHelper( nums, 0, k - 1 );
    rotateHelper( nums, k, nums.length - 1 );
  }
  public void rotateHelper( int[] num, int start, int end ) {
    int left = start;
    int right = end;
    while( left < right ) {
      int tmp = num[left];
      num[left] = num[right];
      num[right] = tmp;
      left++;
      right--;
    }
  }
}
