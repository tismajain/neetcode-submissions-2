class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m= matrix.length;
        int n=matrix[0].length;
        List<Integer> result=new ArrayList<>();

        int re=m-1;
        int ce=n-1;
        int rs=0;
        int cs=0;

         while (rs <= re && cs <= ce) {
            // Traverse from left to right
            for (int j = cs; j <= ce; j++) {
                result.add(matrix[rs][j]);
            }
            rs++;
            
            // Traverse from top to bottom
            for (int i = rs; i <= re; i++) {
                result.add(matrix[i][ce]);
            }
            ce--;
            
            // Traverse from right to left
            if (rs <= re) {
                for (int j = ce; j >= cs; j--) {
                    result.add(matrix[re][j]);
                }
                re--;
            }
            
            // Traverse from bottom to top
            if (cs <= ce) {
                for (int i = re; i >= rs; i--) {
                    result.add(matrix[i][cs]);
                }
                cs++;
            }
        }
        
       
  /*      for(i=0,j=0;j<n;j++)
        {
            l.add(matrix[i][j]);
        }
        for(i=1,j=j-1;i<m;i++)
        {
            l.add(matrix[i][j]);
        }
*/
        return result;
    }
}