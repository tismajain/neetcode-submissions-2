class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> current, int[] nums, boolean[] used)
    {
        if(current.size()==nums.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==false){
            current.add(nums[i]);
            used[i]=true;            
            helper(ans, current, nums, used);            
            current.remove(current.size()-1);
            used[i]=false;
            }
            
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> current= new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used, false);
        helper(ans, current, nums, used);
        return ans;
    }
}
