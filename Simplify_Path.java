public class Solution {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<String> stack = new Stack<String>();
		String[] dirs = path.split("/");
		for (int i = 0; i < dirs.length; ++i) {
			if (dirs[i].equals(".") || dirs[i].equals(""))
				continue;
			else if (dirs[i].equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.add(dirs[i]);
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<String> tmp = new ArrayList<String>();
		while (!stack.isEmpty()) {
			tmp.add(stack.pop());
		}
		for (int i = tmp.size() - 1; i >= 0; --i) {
			sb.append("/");
			sb.append(tmp.get(i));
		}
		if (sb.length() == 0)
			sb.append("/");
		return sb.toString();
	}
}
