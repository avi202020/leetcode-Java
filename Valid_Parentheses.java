public class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char pre = stack.pop();
        if (ch == ')' && pre != '(') {
          return false;
        } else if (ch == ']' && pre != '[') {
          return false;
        } else if (ch == '}' && pre != '{') {
          return false;
        }
      }
    }
    if (!stack.isEmpty()) {
      return false;
    }
    return true;
  }
}

