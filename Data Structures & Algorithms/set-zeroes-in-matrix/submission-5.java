class Solution {

    public void setZeroes(int[][] matrix) {
        boolean[][] v=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(!v[i][j] && matrix[i][j]==0)
                {
                    for(int k=0;k<matrix.length;k++)
                    {
                        if(matrix[k][j]!=0){
                        matrix[k][j]=0;
                        v[k][j]=true;
                        }
                    }
                    for(int k=0;k<matrix[0].length;k++)
                    {
                        if(matrix[i][k]!=0){
                        matrix[i][k]=0;
                        v[i][k]=true;
                        }
                    }

                }
            }
        }
    }
}
