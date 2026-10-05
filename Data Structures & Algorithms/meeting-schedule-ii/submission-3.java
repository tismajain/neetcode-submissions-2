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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==1)
        {
            return 1;
        }
        if(intervals.size()==0)
        {
            return 0;
        }
        intervals.sort((a,b)-> a.start-b.start);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(intervals.get(0).end);
        int max=0;
        for(int i=1;i<intervals.size();i++)
        {
            while(!pq.isEmpty() && intervals.get(i).start>=pq.peek())
            {
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
            max=Math.max(max,pq.size());

        }
        return max;
    }
}
