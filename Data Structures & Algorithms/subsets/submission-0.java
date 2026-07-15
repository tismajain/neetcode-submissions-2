class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> current, int[] nums, int idx)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        helper(ans, current, nums, idx+1);        
        current.add(nums[idx]);
        helper(ans, current, nums, idx+1);
        current.remove(current.size()-1);
        

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        helper(ans, current, nums, 0);
        return ans;
    }
}
