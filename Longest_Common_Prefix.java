public class Solution {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (strs.length == 0)
			return "";
		int num = strs.length;
		int len = strs[0].length();
		for (int j = 0; j < len; ++j) {
			for (int i = 1; i < num; ++i) {
				if ( j >= strs[i].length() || strs[i].charAt(j) != strs[i - 1].charAt(j) )
					return strs[0].substring(0, j);
			}
		}
		return strs[0];
	}
}
