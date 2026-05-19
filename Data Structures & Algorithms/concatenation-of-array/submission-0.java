class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[]=new int[nums.length*2];
        int i;int j=0;
        for(i=0;i<ans.length/2;i++)
        {
            ans[i]=nums[i];
            ans[i+nums.length]=nums[j++];
        }
        return ans;

    }
}