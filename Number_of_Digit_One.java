public class Solution {
  public int countDigitOne(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n <= 9) {
      return 1;
    }
    int len = String.valueOf(n).length();
    int base = (int) Math.pow(10, len - 1);
    if (n >= 2 * base) {
      return base + countDigitOne(n % base) + n / base * countDigitOne(base - 1);
    }
    return n % base + 1 + countDigitOne(n % base) + countDigitOne(base - 1);
  }
}
