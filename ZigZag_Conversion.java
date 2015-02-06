public class Solution {
  public String convert(String s, int nRows) {
    if( nRows == 0 )
      return "";
    if( nRows == 1 )
      return s;
    ArrayList<StringBuilder> arr = new ArrayList<StringBuilder>();
    for( int i = 0; i < nRows; ++i )
      arr.add(new StringBuilder());
    int dir = 1;
    int cur = 0;
    for( int i = 0; i < s.length(); ++i ) {
      arr.get(cur).append(s.charAt(i));
      cur = cur + dir;
      if( cur == 0 || cur == nRows - 1 )
        dir = dir * (-1);
    }
    StringBuilder ans = new StringBuilder();
    for( int i = 0; i < nRows; ++i )
      ans.append(arr.get(i).toString());
    return ans.toString();
  }
}
