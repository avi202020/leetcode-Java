public class Solution {
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    if (k >= prices.length / 2) {
      return maxProfitNoLimit(prices);
    }

    int n = prices.length;
    // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
    int[][] mustsell = new int[n][k + 1];
    // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
    int[][] globalbest = new int[n][k + 1];

    for (int i = 1; i < prices.length; ++i) {
      int diff = prices[i] - prices[i-1];
      for (int j = 1; j <= k; ++j) {
        mustsell[i][j] = Math.max(globalbest[i-1][j-1] + diff, mustsell[i-1][j] + diff);
        globalbest[i][j] = Math.max(globalbest[i-1][j], mustsell[i][j]);
      }
    }
    return globalbest[prices.length - 1][k];
  }
  private int maxProfitNoLimit(int[] prices) {
    int res = 0;
    for (int i = 1; i < prices.length; ++i) {
      if (prices[i] - prices[i - 1] > 0) {
        res = res + (prices[i] - prices[i - 1]);
      }
    }
    return res;
  }
}
