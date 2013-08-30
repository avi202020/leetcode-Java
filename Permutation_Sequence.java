/////////////////////////////////////////////////////////////////////
//            This is the O(kn) solution, TLE in big test
/////////////////////////////////////////////////////////////////////
public class Solution {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; ++i)
			sb.append((char) (i + '0'));
		String next = sb.toString();
		k = k - 1;
		while (k > 0) {
			next = nextPermutation(next);
			k--;
		}
		return next;
	}

	public String nextPermutation(String str) {
		StringBuilder next = new StringBuilder(str);
		int i = next.length() - 1;
		while (i > 0 && next.charAt(i) <= next.charAt(i - 1)) {
			i--;
		}
		if (i == 0) {
			int left = 0;
			int right = next.length() - 1;
			while (left < right) {
				char tmp = next.charAt(left);
				next.setCharAt(left, next.charAt(right));
				next.setCharAt(right, tmp);
				left++;
				right--;
			}
			return next.toString();
		}
		int pos = i - 1;
		int j = next.length() - 1;
		while (str.charAt(j) <= str.charAt(pos))
			j--;
		char tmp = next.charAt(pos);
		next.setCharAt(pos, next.charAt(j));
		next.setCharAt(j, tmp);
		j = next.length() - 1;
		while (i < j) {
			tmp = next.charAt(i);
			next.setCharAt(i, next.charAt(j));
			next.setCharAt(j, tmp);
			i++;
			j--;
		}
		return next.toString();
	}
}
