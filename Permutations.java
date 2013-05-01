public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		dfs( num, 0, ans );
		return ans;
	}
	public void dfs( int[] num, int depth, ArrayList<ArrayList<Integer>> ans )
	{
		if( depth >= num.length )
		{
			ArrayList<Integer> newline = new ArrayList<Integer>();
			for( int i = 0; i < num.length; ++i )
				newline.add( num[i] );
			ans.add( newline );
			return;
		}
		for( int i = depth; i < num.length; ++i )
		{
			swap( num, depth, i );
			dfs( num, depth + 1, ans );
			swap( num, depth, i );
		}
	}
	public void swap( int[] num, int i, int j )
	{
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}
