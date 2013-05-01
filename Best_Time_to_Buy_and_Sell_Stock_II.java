public class Solution {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( prices.length == 0 ) return 0;
		int profit = 0;
		for( int i = 0; i < prices.length - 1; ++i )
		{
			if( prices[i] < prices[i+1] )
				profit += prices[i+1] - prices[i];
		}
		return profit;
	}
}
