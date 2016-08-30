// Solution 1. DP 
public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    boolean[] dp = new boolean[s.length()];
    for (int i = 0; i < s.length(); ++i) {
      if (wordDict.contains(s.substring(0, i + 1))) {
        dp[i] = true;
      } else {
        dp[i] = false;
        for (int j = 0; j < i; ++j) {
          if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
            dp[i] = true;
            break;
          }
        }
      }
    }
    return dp[s.length() - 1];
  }
} 


// Solution 2. DFS but got TLE
public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    return wordBreakHelper(s, wordDict, 0);
  }
  private boolean wordBreakHelper(String s, Set<String> wordDict, int depth) {
    if (depth >= s.length()) {
      return true;
    }
    for (int i = depth + 1; i <= s.length(); ++i) {
      String prefix = s.substring(depth, i);
      if (wordDict.contains(prefix)) {
        boolean success = wordBreakHelper(s, wordDict, i);
        if (success) {
          return true;
        }
      }
    }
    return false;
  }
} 
