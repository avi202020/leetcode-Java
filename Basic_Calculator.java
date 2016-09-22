public class Solution {
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int curNum = 0;
    int sign = 1;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        continue;
      } else if (Character.isDigit(c)) {
        curNum = curNum * 10 + (int) (c - '0');
      } else if (c == '+') {
        result += sign * curNum;
        curNum = 0;
        sign = 1;
      } else if (c == '-') {
        result += sign * curNum;
        curNum = 0;
        sign = -1;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        curNum = 0;
        sign = 1;
        result = 0;
      } else if (c == ')') {
        result += sign * curNum;
        curNum = 0;
        if (!stack.isEmpty()) {
          result *= stack.pop();
        }
        if (!stack.isEmpty()) {
          result += stack.pop();
        }
      }
    }
    if (curNum != 0) {
      result += sign * curNum;
    }
    return result;
  }
}
