public class Solution {
  public int[] singleNumber(int[] nums) {
    int[] res = new int[2];
    int temp = 0;
    for (int i = 0; i < nums.length; ++i) {
      temp = temp ^ nums[i];
    }
    temp = temp & -temp;  // the lowest different bit
    for (int i = 0; i < nums.length; ++i){
      if ((nums[i] & temp) == 0) {
        res[0] ^= nums[i];
      } else {
        res[1] ^= nums[i];
      }
    }
    return res;
  }
}
