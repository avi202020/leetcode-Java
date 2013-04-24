/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> ans = new ArrayList<Interval>();
		if( intervals.size() == 0 )
			return ans;
		Collections.sort( intervals, new mycmp() );
		Interval itv = intervals.get(0);
		for( int i = 1; i < intervals.size(); ++i )
		{
			if( intervals.get(i).start > itv.end )
			{
				ans.add(itv);
				itv = intervals.get(i);
			}
			else if( intervals.get(i).end > itv.end )
				itv.end = intervals.get(i).end;
		}
		ans.add(itv);
		return ans;
	}
	class mycmp implements Comparator
	{
		public int compare( Object o1, Object o2 )
		{
			Interval i1 = (Interval)o1;
			Interval i2 = (Interval)o2;
			if( i1.start > i2.start ) return 1;
			else return -1;
		}
	}
}
