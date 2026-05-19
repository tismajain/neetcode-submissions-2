class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int[] ans=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(i=0;i<nums.length;i++)
        {
            int diff=target-nums[i];
            if(map.containsKey(diff))
            {
                ans[0]=map.getOrDefault(diff,0);
                ans[1]=i;
            }
            map.put(nums[i],i);

        }
        return ans;
    }
}
