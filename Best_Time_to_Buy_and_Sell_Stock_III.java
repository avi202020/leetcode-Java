public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int maxProfit = 0;
    // calculate the max profit of first transaction
    int[] maxProfits1 = new int[prices.length];
    maxProfits1[0] = 0;
    int lowest = prices[0];
    for (int i = 1; i < prices.length; ++i) {
      maxProfits1[i] = Math.max(maxProfits1[i-1], prices[i] - lowest);
      lowest = Math.min(lowest, prices[i]);
    }
    // calculate the max profit of second transaction
    int[] maxProfits2 = new int[prices.length];
    int highest = prices[prices.length - 1];
    maxProfits2[prices.length - 1] = 0;
    for (int i = prices.length - 2; i >= 0; --i) {
      maxProfits2[i] = Math.max(maxProfits2[i+1], highest - prices[i]);
      highest = Math.max(highest, prices[i]);
    }
    // calculate the final max profit
    for (int i = 0; i < prices.length; ++i) {
      maxProfit = Math.max(maxProfit, maxProfits1[i] + maxProfits2[i]);
    }
    return maxProfit;
  }
}
