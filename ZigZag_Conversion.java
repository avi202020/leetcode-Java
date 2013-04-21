public class Solution {
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if( nRows == 1 ) return s;
		ArrayList<StringBuffer> row = new ArrayList<StringBuffer>();
		for( int i = 0; i < nRows; ++i )
		{
			StringBuffer sb = new StringBuffer();
			row.add(sb);
		} 
		int cur = 0;
		boolean dir = true;
		for( int i = 0; i < s.length(); ++i )
		{
			row.get(cur).append(s.charAt(i));
			if( cur == nRows - 1 ) 
				dir = false;
			else if( cur == 0 )
				dir = true;
			if( dir == true ) 
				cur++;
			else if( dir == false ) 
				cur--;
		}
		StringBuffer ans = new StringBuffer();
		for( int i = 0; i < nRows; ++i )
			ans.append( row.get(i).toString() );
		return ans.toString();
	}
}
