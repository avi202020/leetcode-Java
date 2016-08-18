public class Solution {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    String[] strs = s.split(" ");
    if (strs.length == 0) {
      return 0;
    }
    int num = strs.length;
    return strs[num - 1].length();
  }
}
