class Solution {
    public boolean helper(char[][] board, String word, int i, int j, int idx, boolean[][] visited)
    {
        if(idx==word.length())
        {
            return true;
        }
        if(i<0 || j<0 || i==board.length || j==board[0].length || visited[i][j]==true)
        {
            return false;
        }
        
        if(board[i][j]!=word.charAt(idx))
        {
            return false;
        }
        boolean found=false;
        if(board[i][j]==word.charAt(idx))
        {
            visited[i][j]=true;
            idx++;
            found= helper(board, word, i-1, j,idx, visited) || helper(board, word, i, j-1, idx, visited) || helper(board, word, i+1, j, idx, visited) || helper(board, word, i, j+1, idx, visited);
            idx--;
            visited[i][j]=false;
        }
        return found;
    }
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean[][] visited=new boolean[board.length][board[0].length];
                    if(helper(board, word, i, j, 0, visited))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
}
