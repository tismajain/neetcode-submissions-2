class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Arrays.fill(ans,0);
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<temperatures.length;i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i])
            {
                int val=st.pop();
                ans[val]=i-val;
            }
            st.push(i);
        }
        return ans;

    }
}
