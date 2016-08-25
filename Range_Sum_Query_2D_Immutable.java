public class NumMatrix {

  int[][] sumMatrix;
  boolean empty;
  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) {
      empty = true;
      return;
    } else {
      empty = false;
    }
    int n = matrix[0].length;
    if (n == 0) {
      empty = true;
      return;
    } else {
      empty = false;
    }
    sumMatrix = new int[m+1][n+1];
    for (int i = 0; i < m + 1; i++) {
      sumMatrix[i][0] = 0;
    }
    for (int i = 0; i < n + 1; i++) {
      sumMatrix[0][i] = 0;
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1;j < n + 1; j++) {
        sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i-1][j-1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (empty) {
      return 0;
    }
    return sumMatrix[row2+1][col2+1] - sumMatrix[row2+1][col1] - sumMatrix[row1][col2+1] + sumMatrix[row1][col1];
  }
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
