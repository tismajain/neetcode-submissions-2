class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> current, int start, int sum, int[] nums, int target)
    {
        if(sum==target)
        {
            ans.add(new ArrayList<>(current));
        }
        if(sum>target)
        {
            return;
        }

        for(int i=start; i<nums.length; i++)
        {
            current.add(nums[i]);
            helper(ans, current, i, sum+nums[i], nums, target);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> current =new ArrayList<>();
        helper(ans, current, 0, 0, nums, target);
        return ans;
    }
}
