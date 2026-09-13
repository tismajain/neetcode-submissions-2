class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (i == 0 && j == 0) {
                    continue;
                }

                int fromAbove = 0;
                int fromLeft = 0;

                if (i > 0) {
                    fromAbove = dp[i - 1][j];
                }

                if (j > 0) {
                    fromLeft = dp[i][j - 1];
                }

                dp[i][j] = fromAbove + fromLeft;
            }
        }
        return dp[m-1][n-1];
        
    }
}
