class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a, b) ->
            Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval meeting : intervals) {

            // Earliest-ending room is available
            if (!pq.isEmpty() && meeting.start >= pq.peek()) {
                pq.poll();
            }

            // Allocate this meeting to a room
            pq.add(meeting.end);
        }

        return pq.size();
    }
}