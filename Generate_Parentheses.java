public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		dfs( n, 0, 0, sb, ans );
		return ans;
	}
	public void dfs( int n, int depth, int left_num, StringBuffer sb, ArrayList<String> ans )
	{
		if( depth >= 2 * n )
		{
			if( left_num == 0 )
				ans.add( sb.toString() );
			return;
		}
		if( left_num < n )
		{
			sb.append('(');
			dfs( n, depth + 1, left_num + 1, sb, ans );
			sb.deleteCharAt( sb.length() - 1 );
		}
		if( left_num > 0 )
		{
			sb.append(')');
			dfs( n, depth + 1, left_num - 1, sb, ans );
			sb.deleteCharAt( sb.length() - 1 );
		}
	}
}
