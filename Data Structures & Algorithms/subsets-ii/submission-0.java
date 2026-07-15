class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> current, int[] nums, int idx, HashSet<List<Integer>> set )
    {
        if(idx==nums.length)
        {
            if(set.contains(current))
            return;
            ans.add(new ArrayList<>(current));
            set.add(current);
            return;
        }

        helper(ans, current, nums , idx+1, set);
        current.add(nums[idx]);
        helper(ans, current, nums, idx+1, set);
        current.remove(current.size()-1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        helper(ans, current, nums, 0, set);
        return ans;
    }
}
