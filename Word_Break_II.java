public class Solution {
  public List<String> wordBreak(String s, Set<String> dict) {
    HashMap<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
    return _wordBreak(s,dict,memo);
  }
  public ArrayList<String> _wordBreak(String s, Set<String> dict, HashMap<String, ArrayList<String>> memo) {
    if( memo.containsKey(s) )
      return memo.get(s);
    ArrayList<String> ans = new ArrayList<String>();
    int len = s.length();
    if( len <= 0 )
      return ans;
    for( int i = 1; i <= len; ++i ) {
      String prefix = s.substring(0, i);
      if( dict.contains(prefix) ) {
        if( prefix.length() == s.length() ) {
          ans.add(s);
        } else {
          String subfix = s.substring(i);
          ArrayList<String> tmp = _wordBreak(subfix, dict, memo);
          for( String item : tmp ) {
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
