public class Solution {
  public double myPow(double x, int n) {
    if (n < 0) {
      return 1 / power(x, -n);
    }
    return power(x, n);
  }
  public double power(double x, int n) {
    if (n == 0) {
      return 1;
    }
    double v = power(x, n / 2);
    if (n % 2 == 0) {
      return v * v;
    }
    return v * v * x;
  }
}
