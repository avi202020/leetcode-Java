public class Solution {
  public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    char[] ss = s.toCharArray();
    char[] tt = t.toCharArray();
    while (i < ss.length && j < tt.length) {
      if (ss[i] == tt[j]) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }
}
