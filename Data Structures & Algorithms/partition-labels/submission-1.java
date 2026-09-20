class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        int left=0,right=0;
        
        int max=map.get(s.charAt(0));
        while(left<=right && right<s.length())
        {
            max=Math.max(max,map.get(s.charAt(right)));
            if(right==max)
            {
                ans.add(right-left+1);
                left=right+1;
                right++;
                
                
                continue;
            }
            
            right++;
           

        }
        return ans;
    }
}
