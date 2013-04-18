public class Solution {
	int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if( matrix.length == 0 ) return ans;
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		dfs( matrix, visit, 0, 0, 0, ans );
		return ans;
	}
	public void dfs( int[][] matrix, boolean[][] visit, int x, int y, int curdir, ArrayList<Integer> ans )
	{
		if( ans.size() >= matrix.length * matrix[0].length )
			return;
		ans.add( matrix[x][y] );
		visit[x][y] = true;
		int nx = x + dir[curdir][0];
		int ny = y + dir[curdir][1];
		if( nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && visit[nx][ny] == false )
			dfs( matrix, visit, nx, ny, curdir, ans );
		curdir = ( curdir + 1 ) % 4;
		nx = x + dir[curdir][0];
		ny = y + dir[curdir][1];
		dfs( matrix, visit, nx, ny, curdir, ans );
	}
}

