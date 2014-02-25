public class Solution {
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if( n == 0 ) return matrix;
        boolean[][] visit = new boolean[n][n];
        dfsGenerateMatrix(0, 0, 1, 0, visit, matrix);
        return matrix;
    }

    public void dfsGenerateMatrix(int x, int y, int cur, int curdir, boolean[][] visit, int[][] matrix) {
        if (cur > visit.length * visit[0].length)
            return;
        matrix[x][y] = cur;
        visit[x][y] = true;
        int nx = x + dir[curdir][0];
        int ny = y + dir[curdir][1];
        if (nx >= 0 && nx < visit.length && ny >= 0 && ny < visit[0].length && visit[nx][ny] == false) {
            dfsGenerateMatrix(nx, ny, cur + 1, curdir, visit, matrix);
        } else {
            curdir = (curdir + 1) % 4;
            nx = x + dir[curdir][0];
            ny = y + dir[curdir][1];
            dfsGenerateMatrix(nx, ny, cur + 1, curdir, visit, matrix);
        }
    }
}

