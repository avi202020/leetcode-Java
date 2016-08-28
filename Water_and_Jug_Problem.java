ipublic class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y < z) {
      return false;
    }
    if (z == 0) {
      return true;
    }
    return (z % gcd(x, y) == 0);
  }
  private int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }
}
