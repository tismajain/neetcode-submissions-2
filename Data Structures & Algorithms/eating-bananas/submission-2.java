class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
    
        for(int p:piles)
        {
            max=p>max? p:max;
            
        }
        int low=1;
        int mid=0;
        int ans=0;
        while(low<=max)
        {
            mid=low+(max-low)/2;
            int c=0;
            for(int p:piles)

            {
                c+= (p+mid-1)/mid;
            }
            if(c<=h)
            {
                ans=mid;
                max=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
