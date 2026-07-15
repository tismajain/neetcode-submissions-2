class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> current, int start, int sum, int[] c, int target )
    {
        if(sum==target)
        {
            ans.add(new ArrayList<>(current));
            return;

        }
        if(sum>target)
        {
            return;
        }
        for(int i= start; i<c.length;i++)
        {
            if(i>start && c[i]==c[i-1])
            {
                
                continue;
            }
            current.add(c[i]);
            helper(ans, current, i+1, sum+c[i], c, target);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        helper(ans, current, 0, 0, candidates, target);
        return ans;

    }
}
