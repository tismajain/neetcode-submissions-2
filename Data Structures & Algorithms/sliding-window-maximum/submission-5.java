class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        Deque<Integer> q=new ArrayDeque<>();
        int l=0,r=0,i=0;
        while(r<n)
        {
            while(!q.isEmpty() && nums[q.peekLast()]<nums[r])
            {
                q.pollLast();
            }
            q.offerLast(r);
            if(q.peekFirst()<=r-k)
            {
                q.pollFirst();
            }

            if(r>=k-1)
            {
                ans[i++]=nums[q.peekFirst()];
            }
            
            r++;


        }
        return ans;
    }
}
