public class Solution {
  public List<String> wordBreak(String s, Set<String> wordDict) {
    Map<String, List<String>> memo = new HashMap<String, List<String>>();
    return wordBreak2Helper(s, wordDict, memo);
  }
  private List<String> wordBreak2Helper(String s, Set<String> dict, Map<String, List<String>> memo) {
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    List<String> ans = new ArrayList<String>();
    int len = s.length();
    if (len <= 0) {
      return ans;
    }
    for (int i = 1; i <= len; ++i) {
      String prefix = s.substring(0, i);
      if (dict.contains(prefix)) {
        if (prefix.length() == s.length()) {
          ans.add(s);
        } else {
          String subfix = s.substring(i);
          List<String> tmp = wordBreak2Helper(subfix, dict, memo);
          for (String item : tmp) {
            item = prefix + " " + item;
            ans.add(item);
          }
        }
      }
    }
    memo.put(s, ans);
    return ans;
  }
}
