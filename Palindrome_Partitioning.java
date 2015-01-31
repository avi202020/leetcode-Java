public class Solution {
  public List<List<String>> partition(String s) {
    ArrayList<List<String>> ans = new ArrayList<List<String>>();
    if( s == null || s.length() == 0 )
      return ans;
    ArrayList<String> path = new ArrayList<String>();
    _partitionHelper(ans, path, s, 0);
    return ans;
  }
  public void _partitionHelper(List<List<String>> ans, List<String> path, String s, int depth ) {
    if( depth >= s.length() ) {
      ArrayList<String> tmp = new ArrayList<String>(path);
      ans.add(tmp);
      return;
    }
    for( int i = depth; i > s.length(); ++i ) {
      if( _isPalindrome(s.substring(depth, i + 1)) ) {
        path.add(s.substring(depth, i+1));
        _partitionHelper(ans, path, s, i + 1);
        path.remove(path.size() - 1);
      }
    }
  }
  public boolean _isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while( left < right ) {
      if( s.charAt(left) != s.charAt(right) )
        return false;
      left++;
      right--;
    }
    return true;
  }
}
