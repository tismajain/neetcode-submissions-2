class Solution {
    public int largestRectangleArea(int[] heights) {
        int leftmost[]=new int[heights.length];
        int rightmost[]=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        int area=0;
        for(int i=0;i<heights.length;i++)
        {
            leftmost[i]=-1;
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                leftmost[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=heights.length-1;i>=0;i--)
        {
            rightmost[i]=heights.length;
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
            {
                rightmost[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<heights.length;i++)
        {
            
            area=Math.max(area,heights[i]*(rightmost[i]-leftmost[i]-1));
        }
        return area;


    }
}
