class Solution {
    int helper(int[] nums, int target, int sum, int idx,int[][] dp, int base)
    {
        if(idx== nums.length && sum==target)
        {
            return 1;
        }
        if(idx== nums.length)
        {
            return 0;
        }
        if(dp[idx][sum+base]!=0)
        {
            return dp[idx][sum+base];
        }
        


        
            
            int plus=helper(nums, target, sum+nums[idx], idx+1, dp, base);
           
            
            int minus=helper(nums, target,sum-nums[idx], idx+1, dp, base);
           
        dp[idx][sum+base]=plus+minus;
        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }

        int[][] dp=new int[nums.length][sum*2+1];
        return helper(nums, target,  0, 0,dp, sum);
    }
}
