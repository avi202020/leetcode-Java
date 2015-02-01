public class Solution {
  public int minCut(String s) {
    if( s == null || s.length() <= 1 )
      return 0;
    boolean isPalindrome[][] = _getPalindromeMatrix(s);
    int cut[] = new int[s.length()+1];
    cut[0] = 0;
    for( int i = 1; i <= s.length(); ++i ) {
      cut[i] = Integer.MAX_VALUE;
      for( int j = 1; j <= i; ++j ) {
        if( cut[i-j] == Integer.MAX_VALUE )
          continue;
        if( isPalindrome[i-j][i-1] )
          cut[i] = Math.min( cut[i], cut[i-j] + 1 );
      }
    }
    return cut[s.length()]-1;
  }
  public boolean[][] _getPalindromeMatrix(String s) {
    boolean[][] matrix = new boolean[s.length()][s.length()];
    for( int i = 0; i < s.length(); ++i )
      matrix[i][i] = true;
    for( int i = 0; i < s.length()-1; ++i )
      matrix[i][i+1] = ( s.charAt(i) == s.charAt(i+1) );
    for( int length = 2; length <= s.length(); ++length ) {
      for( int start = 0; start + length < s.length(); ++start ) {
        matrix[start][start+length] = matrix[start+1][start+length-1] && ( s.charAt(start) == s.charAt(start+length) );
      }
    }
    return matrix;
  }
}
