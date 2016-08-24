// Solution 1.
public class Solution {
  public boolean isPowerOfThree(int n) {
    int num = n;
    while (num > 0 && num % 3 == 0) {
      num /= 3;
    }
    return num == 1;
  }
}

// Solution 2.
public class Solution {
  public boolean isPowerOfThree(int n) {
    double logAns = Math.log10(n) / Math.log10(3);
    if (logAns - (int)(logAns) == 0) {
      return true;
    }
    return false;
  }
}
