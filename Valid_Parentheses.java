public class Solution {
  public boolean isValid(String s) {
    Stack<Character> stk = new Stack<Character>();
    for( int i = 0; i < s.length(); ++i ) {
      char cur = s.charAt(i);
      if( cur == '(' ||  cur == '[' || cur == '{' ) {
        stk.push(cur);
      } else {
        if( stk.isEmpty() )
          return false;
        if( cur == ')' && stk.peek() == '(' )
          stk.pop();
        else if ( cur == ']' && stk.peek() == '[' )
          stk.pop();
        else if ( cur == '}' && stk.peek() == '{' )
          stk.pop();
        else
          return false;
      }
    }
    if( !stk.isEmpty() )
      return false;
    return true;
  }
}
