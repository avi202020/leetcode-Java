public class Solution {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("1");
    char pre;
    int num;
    for (int i = 2; i <= n; ++i) {
      StringBuilder newStr = new StringBuilder();
      pre = sb.charAt(0);
      num = 1;
      for (int j = 1; j < sb.length(); ++j) {
        if (sb.charAt(j) == pre) {
          num++;
        } else {
          newStr.append((char)(num + '0'));
          newStr.append(pre);
          pre = sb.charAt(j);
          num = 1;
        }
      }
      newStr.append((char)(num + '0'));
      newStr.append(pre);
      sb = newStr;
    }
    return sb.toString();
  }
}
