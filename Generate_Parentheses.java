public class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    generateParenthesisHelper(n, 0, 0, sb, res);
    return res;
  }
  public void generateParenthesisHelper(int max, int depth, int left, StringBuilder sb, List<String> res) {
    if (depth >= max * 2) {
      if (left == 0) {
        res.add(sb.toString());
      }
      return;
    }
    if (left < max) {
      sb.append("(");
      generateParenthesisHelper(max, depth + 1, left + 1, sb, res);
      sb.deleteCharAt( sb.length() - 1 );
    }
    if (left > 0) {
      sb.append(")");
      generateParenthesisHelper(max, depth + 1, left - 1, sb, res);
      sb.deleteCharAt( sb.length() - 1 );
    }
  }
}
