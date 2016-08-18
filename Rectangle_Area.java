public class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int bottomLeftX = Math.max(A, E);
    int bottomLeftY = Math.max(B, F);
    int topRightX = Math.min(C, G);
    int topRightY = Math.min(D, H);
    // sum of two rectangle area
    int res = (C-A) * (D-B) + (G-E) * (H-F);
    if (bottomLeftX >= topRightX || bottomLeftY >= topRightY) {
      return res;
    }
    // they have common area
    return res - (topRightX - bottomLeftX) * (topRightY - bottomLeftY);
  }
}
