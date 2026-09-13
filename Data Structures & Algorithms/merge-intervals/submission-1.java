class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans=0,i=0,flag=0;
        for(int j=1;j<intervals.length;j++)
        {
            int[] curr=intervals[i];
            int[] next=intervals[j];
            if(next[0]<=curr[1])
            {
                intervals[ans][0]=curr[0];
                intervals[ans][1]=Math.max(curr[1],next[1]);
            }
            else
            {
                
                ans++;
                i=j;
                intervals[ans][0]=intervals[i][0];
                intervals[ans][1]=intervals[i][1];
            }
        }
       
        
        
        int[][] res=new int[ans+1][2];
        for(i=0;i<=ans;i++)
        {
            for(int j=0;j<2;j++)
            {
                res[i][j]=intervals[i][j];
            }
        }

        
        return res;
    }
}
