class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length,col=matrix[0].length;
        int low=0,high=row*col-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int r=mid/col;
            int c=mid%col;
                    if(matrix[r][c]==target)
                    {
                        return true;
                    }
                    else if(matrix[r][c]<target)
                    {
                        low=mid+1;
                    }
                    else
                    {
                        high=mid-1;
                    }
                
        }
        return false;
    }
}
