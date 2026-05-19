class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new  HashMap<>();
        int i;
        for(i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
         List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort((a, b) -> b.getValue() - a.getValue()); // descending
        int ans[]=new int[k];
        i=0;
            for ( i = 0; i < k; i++) {
        ans[i] = list.get(i).getKey();
    }
    return ans;


    }
}
