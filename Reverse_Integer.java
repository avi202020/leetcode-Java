public class Solution {
  public int reverse(int x) {
    boolean positive = true;
    if (x < 0) {
      positive = false;
      x = -x;
    }
    long res = 0;
    while (x != 0) {
      int digit = x % 10;
      x = x / 10;
      res = res * 10 + digit;
    }
    if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
      return 0;
    }
    if (!positive) {
      return (int)-res;
    }
    return (int)res;
  }
}
