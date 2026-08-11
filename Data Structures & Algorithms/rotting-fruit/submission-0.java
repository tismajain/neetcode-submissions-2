class Solution {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int o=0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Put all treasure cells into queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==1)
                {
                    o++;
                }
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int min=0;

        while (!q.isEmpty() && o>0) {

            int level=q.size();

            for(int i=0;i<level;i++){

            Pair curr = q.poll();

            for (int[] dir : directions) {

                int nr = curr.x + dir[0];
                int nc = curr.y + dir[1];

                // boundary check
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                
                if (grid[nr][nc] == 1) {

                    grid[nr][nc] = 2;
                    o--;

                    q.add(new Pair(nr, nc));
                }
            }
            }
            min++;
        }

        return o==0?min:-1;
    }
}