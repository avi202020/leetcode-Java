// Solution 1. use stack to remove leaf nodes one by one
public class Solution {
  public boolean isValidSerialization(String preorder) {
    if (preorder == null || preorder.length() == 0) {
      return false;
    }
    String[] strs = preorder.split(",");
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < strs.length; ++i) {
      String cur = strs[i];
      stack.push(cur);
      while (stack.size() >= 3) {
        String last = stack.pop();
        String second = stack.pop();
        String third = stack.pop();
        if (last.equals("#") && second.equals("#") && !third.equals("#")) {
          stack.push(last);
          continue;
        } else {
          stack.push(third);
          stack.push(second);
          stack.push(last);
          break;
        }
      }
    }
    if (stack.size() == 1 && stack.peek().equals("#")) {
      return true;
    }
    return false;
  }
}
