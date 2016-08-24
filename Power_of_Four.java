// Solution 1.
public class Solution {
  public boolean isPowerOfFour(int num) {
    return num > 0 && (num & (num - 1)) == 0  && (num & 0x55555555) !=0;
  }
}

// Solution 2.
public class Solution {
  public boolean isPowerOfFour(int num) {
    double logAns = Math.log10(num) / Math.log10(4);
    if (logAns - (int)(logAns) == 0) {
      return true;
    }
    return false;
  }
}
