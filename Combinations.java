public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> line = new ArrayList<Integer>();
    combineHelper(n, k, 1, line, res);
    return res;
  }
  private void combineHelper(int n, int k, int depth, List<Integer> line, List<List<Integer>> res) {
    if (depth > n) {
      if (line.size() == k) {
        List<Integer> ans = new ArrayList<Integer>(line);
        res.add(ans);
      }
      return;
    }
    // do not take this element
    combineHelper(n, k, depth + 1, line, res);
    // take this element
    line.add(depth);
    combineHelper(n, k, depth + 1, line, res);
    // backtracking
    line.remove(line.size() - 1);
  }
}
