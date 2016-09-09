public class Solution {
  public String decodeString(String s) {
    Stack<Character> strstk = new Stack<Character>();
    Stack<Integer> numstk = new Stack<Integer>();
    int sum = 0;
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        strstk.push(ch);
      } else if (ch >= '0' && ch <= '9') {
        sum = sum * 10 + ch - '0';
      } else if (ch == '[') {
        numstk.push(sum);
        sum = 0;
        strstk.push(ch);
      } else if (ch == ']') {
        int repeat = numstk.pop();
        StringBuilder sb = new StringBuilder();
        while (strstk.peek() != '[') {
          sb.insert(0, strstk.pop());
        }
        strstk.pop();
        StringBuilder newstr = new StringBuilder();
        for (int j = 0; j < repeat; ++j) {
          newstr.append(sb.toString());
        }
        for (int j = 0; j < newstr.length(); ++j) {
          strstk.push(newstr.charAt(j));
        }
      }
    }
    StringBuilder ans = new StringBuilder();
    while (!strstk.isEmpty()) {
      ans.insert(0, strstk.pop());
    }
    return ans.toString();
  }
}
