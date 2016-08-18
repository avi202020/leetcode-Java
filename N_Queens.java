public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<List<String>>();
    int[] queen = new int[n];
    solveNQueensHelper(ans, queen, 0);
    return ans;
  }
  private void solveNQueensHelper(List<List<String>> ans, int[] queen, int depth) {
    if (depth >= queen.length) {
      List<String> one = new ArrayList<String>();
      for (int i = 0; i < queen.length; ++i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < queen.length; ++j) {
          if (queen[i] == j) {
            sb.append("Q");
          } else {
            sb.append(".");
          }
        }
        one.add(sb.toString());
      }
      ans.add(one);
    }
    for (int i = 0; i < queen.length; ++i) {
      if (check(queen, depth, i)) {
        queen[depth] = i;
        solveNQueensHelper(ans, queen, depth + 1);
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
