// Solution 1.
public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int x = 0;
    int y = n - 1;
    while (true) {
      if (x < 0 || x >= m || y < 0 || y >= n) {
        break;
      }
      if (matrix[x][y] == target) {
        return true;
      } else if (matrix[x][y] < target) {
        x++;
      } else {
        y--;
      }
    }
    return false;
  }
}



// Solution 2. totally a Binary Search, because "The first integer of each row is greater than the last integer of the previous row."
public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int row = mid / n;
      int col = mid % n;
      if (target > matrix[row][col]) {
        left = mid + 1;
      } else if (target < matrix[row][col]) {
        right = mid - 1;
      } else if (target == matrix[row][col]) {
        return true;
      }
    }
    return false;
  }
}
