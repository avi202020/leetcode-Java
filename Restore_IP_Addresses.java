public class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    if(s == null || s.length() < 4 || s.length() > 12) {
      return res;
    }
    List<String> path = new ArrayList<>();
    restoreIpAddressesHelper(s, 0, path, res);
    return res;
  }
  private void restoreIpAddressesHelper(String s, int depth, List<String> path, List<String> res) {
    if (path.size() == 4) {
      if (depth != s.length()) {
        return;
      }
      StringBuilder sb = new StringBuilder();
      for (String tmp : path) {
        sb.append(tmp);
        sb.append(".");
      }
      sb.deleteCharAt(sb.length()-1);
      res.add(sb.toString());
      return;
    }
    for (int i = 1; i <= 3; ++i) {
      if (depth + i > s.length()) {
        break;
      }
      String nextNum = s.substring(depth, depth + i);
      if (isIpValid(nextNum)) {
        path.add(nextNum);
        restoreIpAddressesHelper(s, depth + i, path, res);
        path.remove(path.size() - 1);
      }
    }
  }
  private boolean isIpValid(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    if (s.charAt(0) == '0') {
      return s.equals("0");
    }
    int ip = Integer.parseInt(s);
    if (ip <= 255 && ip >= 0) {
      return true;
    }
    return false;
  }
}
