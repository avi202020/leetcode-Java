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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> ans = new ArrayList<Interval>();
        // true for: the newInterval has been inserted.
        boolean flag = false;
        for( int i = 0; i < intervals.size(); ++i ) {
            // process case 1. current interval is totally "before" newInterval
            if( intervals.get(i).end < newInterval.start ) {
                ans.add(intervals.get(i));
                continue;
            }
            // process case 2. current interval is totally "behind" newInterval
            if( intervals.get(i).start > newInterval.end ) {
                if( flag == false ) {
                    ans.add(newInterval);
                    flag = true;
                    ans.add(intervals.get(i));
                }
                else if( flag == true )
                    ans.add(intervals.get(i));
                continue;
            }
            // process case 3. overlap
            if( intervals.get(i).start < newInterval.start ) {
                newInterval.start = intervals.get(i).start;
            }
            if( intervals.get(i).end > newInterval.end ) {
                newInterval.end = intervals.get(i).end;
                // Since there is only one interval to be inserted and others are separated.
                // The insertion is already done here.
                ans.add(newInterval);
                flag = true;
            }
        }
        if( flag == false )
            ans.add(newInterval);
        return ans;
    }
}
