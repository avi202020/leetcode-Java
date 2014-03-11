public class Solution {
    public int maxProfit(int[] prices) {
        if( prices.length <= 1 )
            return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        process(prices, left, right);  

        int max = 0;
        for( int i = 0; i < prices.length; ++i ) {
            max = Math.max(max, left[i] + right[i]);
        }

        return max;
    }

    public void process(int[] prices, int[] left, int[] right) {
        left[0] = 0;
        int min = prices[0];
        for( int i = 1; i < prices.length; ++i ) {
            left[i] = Math.max(left[i-1], prices[i] - min);
            if( prices[i] < min )
                min = prices[i];
        }

        int max = prices[prices.length - 1];
        for( int i = prices.length - 2; i >= 0; --i ) {
            right[i] = Math.max(right[i+1], max - prices[i]);
            if( prices[i] > max )
                max = prices[i];
        }
    }
}
