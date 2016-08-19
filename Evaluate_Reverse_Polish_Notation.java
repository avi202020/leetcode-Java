public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens.length == 1) {
      return Integer.parseInt(tokens[0]);
    } else if (tokens.length < 3) {
      return 0;
    }
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(Integer.parseInt(tokens[0]));
    stack.push(Integer.parseInt(tokens[1]));
    for (int i = 2; i < tokens.length; ++i) {
      if (isOperator(tokens[i])) {
        if (tokens[i].equals("+")) {
          int num1 = stack.pop();
          int num2 = stack.pop();
          int num3 = num2 + num1;
          stack.push(num3);
        } else if (tokens[i].equals("-")) {
          int num1 = stack.pop();
          int num2 = stack.pop();
          int num3 = num2 - num1;
          stack.push(num3);
        } else if (tokens[i].equals("*")) {
          int num1 = stack.pop();
          int num2 = stack.pop();
          int num3 = num2 * num1;
          stack.push(num3);
        } else if (tokens[i].equals("/")) {
          int num1 = stack.pop();
          int num2 = stack.pop();
          int num3 = num2 / num1;
          stack.push(num3);
        }
      } else {
        stack.push(Integer.parseInt(tokens[i]));
      }
    }
    int ans = stack.pop();
    return ans;
  }
  public boolean isOperator(String str) {
    if (str.equals("+")) {
      return true;
    } else if (str.equals("-")) {
      return true;
    } else if (str.equals("*")) {
      return true;
    } else if (str.equals("/")) {
      return true;
    }
    return false;
  }
}
