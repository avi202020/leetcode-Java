//*************************************************************************************
//                   1. naive method, can only pass the small test
//*************************************************************************************

public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> line = new ArrayList<Integer>();
		dfs( candidates, target, 0, 0, ans, line );
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for( int i = 0; i < ans.size(); ++i )
		{
			if( !set.contains( ans.get(i) ) )
				set.add( ans.get(i) );
		}
		ans = new ArrayList<ArrayList<Integer>>(set);
		return ans;
	}
	public void dfs( int[] cand, int target, int depth, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> line )
	{
		if( sum == target )
		{
			ArrayList<Integer> tmp = new ArrayList<Integer>(line);
			Collections.sort(tmp);
			ans.add(tmp);
			return;
		}
		if( sum > target || depth >= cand.length )
			return;
		line.add( cand[depth] );
		dfs( cand, target, depth, sum + cand[depth] , ans, line );
		line.remove( line.size() - 1 );
		//take this element then move to next position
		line.add( cand[depth] );
		dfs( cand, target, depth + 1, sum + cand[depth] , ans, line );
		line.remove( line.size() - 1 );
		//do not take this element
		dfs( cand, target, depth + 1, sum, ans, line );
	}
}
