public class Solution {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( s == null || s.equals("") )
			return 0;
		if( s.length() == 1 )
			return 1;
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		map.put(s.charAt(start), 0);
		int cur = 1;
		while( cur < s.length() ) {
			if( !map.containsKey(s.charAt(cur)) ) {
				map.put(s.charAt(cur), cur);
				if( cur - start + 1 > ans )
					ans = cur - start + 1;
				cur++;
			}
			else {
				int pos = map.get(s.charAt(cur));
				for( int i = start; i <= pos; ++i )
					map.remove(s.charAt(i));
				start = pos + 1;
			}
		}
		return ans;
	}
}
