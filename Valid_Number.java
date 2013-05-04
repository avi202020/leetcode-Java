public class Solution {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// finite automata machine: http://discuss.leetcode.com/questions/241/valid-number
		int transitionTable[][] = new int[][]{
			{ -1,  0,  3,  1,  2, -1 },     // next states for state 0 
				{ -1,  8, -1,  1,  4,  5 },     // next states for state 1 
				{ -1, -1, -1,  4, -1, -1 },     // next states for state 2 
				{ -1, -1, -1,  1,  2, -1 },     // next states for state 3 
				{ -1,  8, -1,  4, -1,  5 },     // next states for state 4 
				{ -1, -1,  6,  7, -1, -1 },     // next states for state 5
				{ -1, -1, -1,  7, -1, -1 },     // next states for state 6
				{ -1,  8, -1,  7, -1, -1 },     // next states for state 7
				{ -1,  8, -1, -1, -1, -1 }      // next states for state 8
		};
		int state = 0;
		for( int i = 0; i < s.length(); ++i )
		{
			int input = getInputType( s.charAt(i) );
			state = transitionTable[state][input];
			if( state == -1 ) return false;
		}
		if( state == 1 || state == 4 || state == 7 || state == 8 )
			return true;
		return false;
	}
	public int getInputType( char c )
	{
		if( c == ' ' ) return 1;
		if( c == '+' || c == '-' ) return 2;
		if( c >= '0' && c <= '9' ) return 3;
		if( c == '.' ) return 4;
		if( c == 'e' || c == 'E' ) return 5;
		return 0;
	}
}
