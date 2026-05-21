class Solution {
    public int maxProfit(int[] prices) {
        int left=0,right=1;
        int max=0;
        while(left<right && right<prices.length)
        {
            int p=prices[right]-prices[left];
            max=Math.max(max,p);
            if(p<0)
            {
                left=right;
                right++;
                continue;
            }
            right++;
        }
        return max;
    }
}
