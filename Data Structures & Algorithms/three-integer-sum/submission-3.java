class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);int j,k;
        
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            
            int val=-nums[i];
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                if(nums[j]+nums[k]==val)
                {
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                     ans.add(temp);
                     j++;
                     k--;
                     while(j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    
                    while(j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
                else if(nums[j]+nums[k]>val)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
            
           
        }
        return ans;


    }
}
