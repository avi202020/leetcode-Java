public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) {
      return 0;
    }
    if (s.length() == 1) {
      if (s.equals("0")) {
        return 0;
      } else {
        return 1;
      }
    }
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= s.length(); ++i) {
      char cur = s.charAt(i-1);
      char pre = s.charAt(i-2);
      int one = (cur - '0');
      int two = (pre - '0') * 10 + one;
      dp[i] = 0;
      if (two >= 10 && two <= 26) {
        dp[i] += dp[i-2];
      }
      if (one != 0) {
        dp[i] += dp[i-1];
      }
    }
    return dp[s.length()];
  }
}
