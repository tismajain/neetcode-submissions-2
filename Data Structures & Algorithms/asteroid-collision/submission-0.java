class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<asteroids.length;i++)
        {
            int current=asteroids[i];
            int flag=1;
            while(!st.isEmpty() && st.peek()>0 && current<0)
            {
                int top=st.poll();
                if(top==Math.abs(current))
                {
                    flag=0;
                    break;
                }
                else if(top>Math.abs(current))
                {
                    flag=0;
                    st.push(top);
                    break;

                }
                
            }
            if(flag==1)
            st.push(current);
        }
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        int[] intArray = new int[ans.size()];
        int k=ans.size()-1;
        for (int i = 0; i < ans.size(); i++) {
            
            intArray[k--] = ans.get(i);
        }
        return intArray;

    }
}