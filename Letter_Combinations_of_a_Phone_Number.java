public class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<String>();
    if (digits.length() <= 0) {
      return res;
    }
    List<String> table = new ArrayList<String>();
    table.add("");
    table.add("");
    table.add("abc");
    table.add("def");
    table.add("ghi");
    table.add("jkl");
    table.add("mno");
    table.add("qprs");
    table.add("tuv");
    table.add("wxyz");
    StringBuilder sb = new StringBuilder();
    letterCombinationsHelper(digits, 0, table, res, sb);
    return res;
  }
  public void letterCombinationsHelper(String digits, int depth, List<String> table, List<String> res, StringBuilder path) {
    if (depth >= digits.length()) {
      res.add(path.toString());
      return;
    }
    int digit = digits.charAt(depth) - '0';
    String options = table.get(digit);
    for (int i = 0; i < options.length(); ++i) {
      char ch = options.charAt(i);
      path.append(ch);
      letterCombinationsHelper(digits, depth + 1, table, res, path);
      path.deleteCharAt(path.length() - 1);
    }
  }
}
