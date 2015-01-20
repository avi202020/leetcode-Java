public class Solution {
  public int titleToNumber(String s) {
    int ret = 0;
    for( int i = 0; i < s.length(); ++i ) {
      char cur = s.charAt(i);
      int idx = (int)(cur - 'A' + 1);
      ret = ret * 26 + idx;
    }
    return ret;
  }
}
