public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> line = new ArrayList<Integer>();
		Arrays.sort(S);
		dfs( S, 0, ans, line );
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for( int i = 0; i < ans.size(); ++i )
		{
			if( !set.contains(ans.get(i)) )
			{
				set.add( ans.get(i) );
				result.add( ans.get(i) );
			}
		}
		return result;
	}
	public void dfs( int[] arr, int depth, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> line )
	{
		if( depth >= arr.length )
		{
			ArrayList<Integer> tmp = new ArrayList<Integer>(line);
			ans.add(tmp);
			return;
		}
		//take this element
		line.add( arr[depth] );
		dfs( arr, depth + 1, ans, line );
		line.remove( line.size() - 1 );
		//do not take this element
		dfs( arr, depth + 1, ans, line );
	}
}
