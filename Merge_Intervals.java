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
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> ans = new ArrayList<Interval>();
    if (intervals == null || intervals.size() == 0) {
      return ans;
    }
    Collections.sort(intervals, new Comparator<Interval>() {
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });
    Interval previous = intervals.get(0);
    for (int i = 1; i < intervals.size(); ++i) {
      Interval current = intervals.get(i);
      if (current.start > previous.end) {
        // case 1. the current interval is completely behind the previous one
        ans.add(previous);
        previous = current;
      } else if (current.end > previous.end) {
        // case 2. overlap and the current interval has longer tail
        previous.end = current.end;
      }
    }
    ans.add(previous);
    return ans;
  }
}
