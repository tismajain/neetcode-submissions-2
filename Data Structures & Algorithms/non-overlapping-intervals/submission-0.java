class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int ans=0,i=0;
        for(int j=1;j<intervals.length;j++)
        {
            int[] curr=intervals[i];
            int[] next=intervals[j];
            if(next[0]<curr[1])
            {
                intervals[i][1]=Math.min(curr[1],next[1]);
                ans++;
            }
            else
            {
                i=j;
            }
        }
        return ans;
    }
}
