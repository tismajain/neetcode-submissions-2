class Solution {

    public void dfs(int row, int col, boolean[][] ocean, int n, int m, int[][] directions, int[][] heights)
    {
        
            ocean[row][col]=true;
         for(int[] dir: directions)
         {
            int nr=row+dir[0];
            int nc=col+dir[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }

            if (ocean[nr][nc]) {
                continue;
            }

            if (heights[nr][nc] >= heights[row][col]) {
                dfs(nr, nc, ocean,n, m, directions,  heights);
            }
        
         }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for(int i=0;i<n;i++)
        {
            dfs(i,0,pacific, n, m, directions, heights);
        }
        for(int i=0;i<m;i++)
        {
            dfs(0,i,pacific, n, m, directions, heights);
        }
        for(int i=0;i<n;i++)
        {
            dfs(i, m-1, atlantic,n ,m, directions, heights);
        }
        for(int i=0;i<m;i++)
        {
            dfs(n-1, i, atlantic,n, m, directions, heights);
        }

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pacific[i][j]&&atlantic[i][j])
                {
                     ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}
