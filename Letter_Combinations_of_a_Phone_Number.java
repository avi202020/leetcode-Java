public class Solution {
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		ArrayList<String> table = new ArrayList<String>();
		table.add("");
		table.add("");
		table.add("abc");
		table.add("def");
		table.add("ghi");
		table.add("jkl");
		table.add("mno");
		table.add("qprs");
		table.add("tuv");
		table.add("wxyz");
		dfs( digits, 0, table, sb, ans );
		return ans;
	}
	public void dfs( String digits, int depth, ArrayList<String> table, StringBuffer sb, ArrayList<String> ans )
	{
		if( depth >= digits.length() )
		{
			ans.add( sb.toString() );
			return;
		}
		int index = digits.charAt(depth) - '0';
		for( int i = 0; i < table.get(index).length(); ++i )
		{
			sb.append( table.get(index).charAt(i) );
			dfs( digits, depth + 1, table, sb, ans );
			sb.deleteCharAt( sb.length() - 1 );
		}
	}
}
