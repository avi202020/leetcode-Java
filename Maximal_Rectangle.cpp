//******************************************************************************
//         O(n^2) solution, same solution using Java cannot pass the test
//******************************************************************************

class Solution {
public:
	int maximalRectangle(vector<vector<char> > &matrix) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		int max = 0;
		if( matrix.size() == 0 ) return max;
		vector< vector<int> > m( matrix.size(), vector<int>( matrix[0].size(), 0 ) );
		for( int i = 0; i < matrix.size(); ++i )
		{
			for( int j = 0; j < matrix[0].size(); ++j )
			{
				if( i == 0 ) 
				{
					if( matrix[i][j] == '1' ) m[i][j] = 1;
					else m[i][j] = 0;
				}
				else 
				{
					if( matrix[i][j] == '1' ) m[i][j] = m[i-1][j] + 1;
					else m[i][j] = 0;
				}
			}
		}
		for( int i = 0; i < matrix.size(); ++i )
		{
			int area = largestRectangleArea( m[i] );
			if( area > max ) max = area;
		}
		return max;
	}
	int largestRectangleArea( vector<int> height )
	{
		int ans = 0;
		stack<int> heights;
		stack<int> indexes;
		for( int i = 0; i < height.size(); ++i )
		{
			if( heights.empty() || height[i] > heights.top() )
			{
				indexes.push(i);
				heights.push(height[i]);
			}
			else if( height[i] < heights.top() )
			{
				int lastIndex = 0;
				while( !heights.empty() && height[i] < heights.top() )
				{
					lastIndex = indexes.top();
					indexes.pop();
					int tmp = heights.top() * ( i - lastIndex );
					heights.pop();
					if( ans < tmp ) ans = tmp;
				}
				heights.push( height[i] );
				indexes.push( lastIndex );
			}
		}
		while( !heights.empty() )
		{
			int tmp = heights.top() * ( height.size() - indexes.top() );
			heights.pop();
			indexes.pop();
			if( ans < tmp ) ans = tmp;
		}
		return ans;
	}
};
