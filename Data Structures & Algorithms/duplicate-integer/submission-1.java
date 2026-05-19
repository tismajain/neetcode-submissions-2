class Solution {
    public boolean hasDuplicate(int[] nums) {
        // int i;
        // Arrays.sort(nums);
        // for(i=1;i<nums.length;i++)
        // {
        //     if(nums[i]==nums[i-1])
        //     return true;
        // }
        // return false;
        int i;
        HashSet<Integer> set=new HashSet<>();
        for(i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            
        }
        return false;
    
    }
}