#include <vector>
using namespace std;

class Solution {
public:
	void solve(vector< vector<char> > &board) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if( board.size() == 0 ) return;
		int m = board.size();
		int n = board[0].size();
		vector< vector<bool> > visit( m, vector<bool>( n, false ) );
		int dir[4][2] = { {0,1}, {1,0}, {0,-1}, {-1,0} };
		for( int i = 0; i < m; ++i )
		{
			for( int j = 0; j < n; ++j )
			{
				if( i == 0 || j == 0 || i == m - 1 || j == n - 1 )
				{
					if( board[i][j] == 'O' )
						dfs( board, visit, dir, i, j );
				}
			}
		}
		for( int i = 0; i < m; ++i )
		{
			for( int j = 0; j < n; ++j )
			{
				if( visit[i][j] == false )
					board[i][j] = 'X';
			}
		}
	}
	void dfs( vector< vector<char> >& board, vector< vector<bool> >& visit, int dir[4][2], int x, int y )
	{
		visit[x][y] = true;
		for( int i = 0; i < 4; ++i )
		{
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if( nx < 0 || nx >= board.size() )
				continue;
			if( ny < 0 || ny >= board[0].size() )
				continue;
			if( visit[nx][ny] == true )
				continue;
			if( board[nx][ny] == 'X' )
				continue;
			dfs( board, visit, dir, nx, ny );
		}
	}
};
