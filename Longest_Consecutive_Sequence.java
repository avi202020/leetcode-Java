public class Solution {
	public int longestConsecutive(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		for( int i = 0; i < num.length; ++i ) {
			if( map.containsKey(num[i]) )
				continue;
			map.put( num[i], 1 );
			if( map.containsKey(num[i]-1) ) {
				int lower = num[i] - 1 - map.get( num[i] - 1 ) + 1;
				int upper = num[i] + map.get(num[i]) - 1;
				int len = upper - lower + 1;
				map.put( lower, len );
				map.put( upper, len );
				max = Math.max(max,len);
			}
			if( map.containsKey(num[i] + 1) ) {
				int lower = num[i] - map.get(num[i]) + 1;
				int upper = num[i] + 1 + map.get(num[i]+1) - 1;
				int len = upper - lower + 1;
				map.put( lower, len );
				map.put( upper, len );
				max = Math.max(max,len);
			}
		}
		return max;
	}
}
