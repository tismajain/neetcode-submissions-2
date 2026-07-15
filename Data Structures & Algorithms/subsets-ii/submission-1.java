class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> current, int[] nums, int idx)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[idx]);
        helper(ans, current, nums, idx+1);
        current.remove(current.size()-1);
        while(idx<nums.length-1 && nums[idx]==nums[idx+1] )
        {
            
            idx++;
        }
        helper(ans, current, nums , idx+1);
        

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        helper(ans, current, nums, 0);
        return ans;
    }
}
