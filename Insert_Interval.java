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
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> ans = new ArrayList<Interval>();
		boolean flag = false;
		for( int i = 0; i < intervals.size(); ++i )
		{
			if( intervals.get(i).end < newInterval.start )
			{
				ans.add( intervals.get(i) );
				continue;
			}
			if( intervals.get(i).start > newInterval.end )
			{
				if( flag == false )
				{
					ans.add( newInterval );
					flag = true;
					ans.add( intervals.get(i) );
				}
				else if( flag == true )
				{
					ans.add( intervals.get(i) );
				}
				continue;
			}
			if( intervals.get(i).start < newInterval.start )
			{
				newInterval.start = intervals.get(i).start;
			}
			if( intervals.get(i).end > newInterval.end )
			{
				newInterval.end = intervals.get(i).end;
				ans.add( newInterval );
				flag = true;
			}
		}
		if( flag == false )
			ans.add( newInterval );
		return ans;
	}
}
