public class Solution {
  public List<String> findStrobogrammatic(int n) {
    return findStrobogrammaticHelper(n, n);
  }
  private List<String> findStrobogrammaticHelper(int n, int m) {
    if (n == 0) {
      List<String> list = new ArrayList<String>();
      list.add("");
      return list;
    }
    if (n == 1) {
      List<String> list = new ArrayList<String>();
      list.add("0");
      list.add("1");
      list.add("8");
      return list;
    }
    List<String> list = findStrobogrammaticHelper(n - 2, m);
    List<String> result = new ArrayList<String>();
    for (int i = 0; i < list.size(); ++i) {
      String s = list.get(i);
      if (n != m) {
        result.add("0" + s + "0");
      }
      result.add("1" + s + "1");
      result.add("6" + s + "9");
      result.add("8" + s + "8");
      result.add("9" + s + "6");
    }
    return result;
  }
}
