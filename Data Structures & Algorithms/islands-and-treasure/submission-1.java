class Solution {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void islandsAndTreasure(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        // Put all treasure cells into queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {
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

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            for (int[] dir : directions) {

                int nr = curr.x + dir[0];
                int nc = curr.y + dir[1];

                // boundary check
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                // Only process INF cells.
                // -1 = water, 0 = treasure,
                // finite value = already visited
                if (grid[nr][nc] == Integer.MAX_VALUE) {

                    grid[nr][nc] = grid[curr.x][curr.y] + 1;

                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}