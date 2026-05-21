class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int left=0,right=heights.length-1;
        while(left<right)
        {
            int water=Math.min(heights[left],heights[right])*(right-left);
            max=Math.max(max,water);
            if(heights[left]<heights[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return max;
    }
}
