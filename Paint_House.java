public class Solution {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length <= 0) {
      return 0;
    }
    int[][] totalCost = new int[costs.length][3];
    totalCost[0][0] = costs[0][0];
    totalCost[0][1] = costs[0][1];
    totalCost[0][2] = costs[0][2];
    for (int i = 1; i < costs.length; ++i) {
      totalCost[i][0] = Math.min(totalCost[i-1][1], totalCost[i-1][2]) + costs[i][0];
      totalCost[i][1] = Math.min(totalCost[i-1][0], totalCost[i-1][2]) + costs[i][1];
      totalCost[i][2] = Math.min(totalCost[i-1][0], totalCost[i-1][1]) + costs[i][2];
    }
    int n = costs.length;
    int res = Math.min(totalCost[n-1][0], Math.min(totalCost[n-1][1], totalCost[n-1][2]));
    return res;
  }
}
