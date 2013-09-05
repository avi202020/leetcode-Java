public class Solution {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); ++i) {
			char cur = s.charAt(i);
			if (cur == '(')
				stack.add(cur);
			else if (cur == '[')
				stack.add(cur);
			else if (cur == '{')
				stack.add(cur);
			else if (cur == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (cur == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else if (cur == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}
}
