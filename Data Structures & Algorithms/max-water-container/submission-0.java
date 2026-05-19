class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        int left=0,right=heights.length-1;
        while(left<=right)
        {
            int d=(right-left)*(Math.min(heights[right],heights[left]));
            ans=Math.max(ans,d);
            if(heights[right]<heights[left])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return ans;
    }
}
