/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    if (points.length <= 2) {
      return points.length;
    }

    Map<Slope, Integer> slopes = new HashMap<Slope, Integer>();
    int max = 2;
    for (int i = 0; i < points.length; i++) {
      int duplicate = 1;
      for (int j = i + 1; j < points.length; j++) {

        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          duplicate++;
        } else {
          Slope slope = new Slope(points[j].x - points[i].x, points[j].y - points[i].y);

          if (slopes.get(slope) != null) {
            slopes.put(slope, slopes.get(slope) + 1);
          } else {
            slopes.put(slope, 1);
          }
        }
      }
      max = Math.max(max, duplicate);
      for (Integer count : slopes.values()) {
        if (count + duplicate > max) {
          max = count + duplicate;
        }
      }
      slopes.clear();
    }
    return max;
  }

  class Slope {
    int x;
    int y;

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (!(other instanceof Slope)) {
        return false;
      }
      Slope otherSlope = (Slope) other;
      return otherSlope.x == x && otherSlope.y == y;
    }

    @Override
    public int hashCode() {
      return (Integer.toString(x) + "," + Integer.toString(y)).hashCode();
    }

    public Slope(int x, int y) {
      this.x = x / gcd(x,y);
      this.y = y / gcd(x,y);
    }
    private int gcd(int x, int y) {
      return y == 0 ? x : gcd(y, x % y);
    }
  }
}
