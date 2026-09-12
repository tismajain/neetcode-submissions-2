class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        // dist[r][c] = minimum possible maximum elevation
        // encountered on a path from (0,0) to (r,c)
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {cost, row, col}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            // stale PQ entry
            if (cost > dist[r][c]) {
                continue;
            }

            // Dijkstra: first time destination is popped,
            // this is the optimal answer
            if (r == n - 1 && c == n - 1) {
                return cost;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                // KEY DIFFERENCE FROM NORMAL DIJKSTRA
                int newCost = Math.max(
                    cost,
                    grid[nr][nc]
                );

                if (newCost < dist[nr][nc]) {

                    dist[nr][nc] = newCost;

                    pq.add(new int[]{
                        newCost,
                        nr,
                        nc
                    });
                }
            }
        }

        return -1;
    }
}