public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> line = new ArrayList<Integer>();
		dfs( n, k, 1, ans, line );
		return ans;
	}
	public void dfs( int n, int k, int depth, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> line )
	{
		if( depth > n )
		{
			if( line.size() == k )
			{
				ArrayList<Integer> tmp = new ArrayList<Integer>(line);
				ans.add(tmp);
			}
			return;
		}
		//take this element
		line.add( depth );
		dfs( n, k, depth + 1, ans, line );
		line.remove( line.size() - 1 );
		//do not take this element
		dfs( n, k, depth + 1, ans, line );
	}
}

