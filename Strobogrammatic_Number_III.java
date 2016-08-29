public class Solution {
  public int strobogrammaticInRange(String low, String high) {
    int len1 = low.length();
    int len2 = high.length();
    List<String> res = new ArrayList<String>();
    for (int i = len1; i <= len2; i++) {
      List<String> list = strobogrammaticInRangeHelper(i);
      for (int j = 0; j < list.size(); ++j) {
        if (lessThan(low, list.get(j)) && lessThan(list.get(j), high)) {
          res.add(list.get(j));
        }
      }
    }
    return res.size();
  }
  private List<String> strobogrammaticInRangeHelper(int n) {
    return strobogrammaticInRangeHelper(n, n);
  }
  private List<String> strobogrammaticInRangeHelper(int m, int n) {
    if (m == 0) {
      List<String> res = new ArrayList<String>();
      res.add("");
      return res;
    }
    if (m == 1) {
      List<String> res = new ArrayList<String>();
      res.add("0");
      res.add("1");
      res.add("8");
      return res;
    }
    List<String> list = strobogrammaticInRangeHelper(m - 2, n);
    List<String> res = new ArrayList<String>();
    for (int i = 0; i < list.size(); ++i) {
      if (m != n) {
        res.add("0" + list.get(i) + "0");
      }
      res.add("1" + list.get(i) + "1");
      res.add("6" + list.get(i) + "9");
      res.add("8" + list.get(i) + "8");
      res.add("9" + list.get(i) + "6");
    }
    return res;
  }
  private boolean lessThan(String s1, String s2) {
    if (s1.length() == s2.length()) {
      if (s1.compareTo(s2) <= 0) {
        return true;
      } else {
        return false;
      }
    }
    return true;
  }
}
