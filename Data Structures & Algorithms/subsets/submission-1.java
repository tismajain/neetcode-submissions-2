class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        gen(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    private void gen(int idx,int[] nums,List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for (int i=idx;i<nums.length;i++) {
            curr.add(nums[i]);
            gen(i+1,nums,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}
