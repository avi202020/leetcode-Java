public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0;
    int sum = 0;
    int start = 0;
    for (int i = 0; i < gas.length; ++i) {
      sum = sum + gas[i] - cost[i];
      total = total + gas[i] - cost[i];
      if (sum < 0) {
        start = i + 1;
        sum = 0;
      }
    }
    if (total < 0) {
      return -1;
    }
    return start;
  }
}
