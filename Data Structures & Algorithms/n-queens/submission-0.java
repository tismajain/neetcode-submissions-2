class Solution {
    public boolean valid(char[][] board, int row, int col, int n) 
    {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    public void helper(char[][] board, int row, int col, List<List<String>> ans, int n)
    {
        if(row==n)
        {
            List<String> s=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                s.add(new String(board[i]));
            }
            ans.add(s);
            return;
        }
            for(int j=col;j<n;j++)
            {
                if(valid(board, row, j, n))
                {
                    board[row][j]='Q';
                    helper(board, row+1, col, ans, n);
                    board[row][j]='.';
                }
            }
        

    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(board[i], '.');
        List<List<String>> ans=new ArrayList<>();
        helper(board, 0, 0, ans, n);
        return ans;
    }
}
