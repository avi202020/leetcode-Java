public class Solution {
	public int lengthOfLastWord(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String[] segs = s.split(" ");
		if( segs.length == 0 ) return 0;
		return segs[ segs.length - 1 ].length();
	}
}
