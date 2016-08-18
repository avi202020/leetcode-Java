public class Solution {
  private int totalSolutions;
  public int totalNQueens(int n) {
    int[] queen = new int[n];
    totalSolutions = 0;
    totalNQueensHelper(queen, 0);
    return totalSolutions;
  }
  private void totalNQueensHelper(int[] queen, int depth) {
    if (depth >= queen.length) {
      totalSolutions++;
      return;
    }
    for (int i = 0; i < queen.length; ++i) {
      if (check(queen, depth, i)) {
        queen[depth] = i;
        totalNQueensHelper(queen, depth + 1);
        queen[depth] = 0;
      }
    }
  }
  private boolean check(int[] queen, int x, int y) {
    for (int i = 0; i < x; ++i) {
      if (queen[i] == y) {
        return false;
      } else if (Math.abs(queen[i] - y) == Math.abs(x - i)) {
        return false;
      }
    }
    return true;
  }
}
