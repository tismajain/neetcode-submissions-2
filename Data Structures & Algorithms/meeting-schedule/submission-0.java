/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int i=0;
        for(int j=1;j<intervals.size();j++)
        {
            Interval curr=intervals.get(i);
            Interval next=intervals.get(j);
            if(next.start<curr.end)
            {
                return false;
            }
            else
            {
                i++;
            }
        }
        return true;
    }
}
