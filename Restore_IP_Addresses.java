public class Solution {
  public List<String> restoreIpAddresses(String s) {
    ArrayList<String> ans = new ArrayList<String>();
    ArrayList<String> path = new ArrayList<String>();
    _restoreIpAddress(ans, path, s, 0 );
    return ans;
  }
  public void _restoreIpAddress(ArrayList<String> ans, ArrayList<String> path, String s, int depth) {
    if( path.size() == 4 ) {
      if( depth >= s.length() ) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < path.size(); ++i ) {
          sb.append(path.get(i));
          sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        ans.add(sb.toString());
      }
      return;
    }
    for( int i = 1; i <= 3; ++i ) {
      if( depth + i > s.length() )
        break;
      String nextNum = s.substring(depth, depth + i);
      if( checkAvailable(nextNum) ) {
        path.add(nextNum);
        _restoreIpAddress(ans, path, s, depth + i);
        path.remove(path.size()-1);
      }
    }
  }
  public boolean checkAvailable(String s) {
    if( s.charAt(0) == '0' )
      return s.equals("0");
    int num = Integer.parseInt(s);
    return num >= 0 && num <= 255;
  }
}
