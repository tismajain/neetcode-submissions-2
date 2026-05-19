class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int i;
        int count=0;
        for(i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int temp=1;
        
        for(i=0;i<nums.length;i++)
        {   
           temp=1;
            if(!set.contains(nums[i]-1))
            {
                
                int k=1;
                while(set.contains(nums[i]+k))
                {
                    temp++;
                    k++;
                }
                                
            }

            count= Math.max(count,temp);
        }
        return count;
        
    }
}
