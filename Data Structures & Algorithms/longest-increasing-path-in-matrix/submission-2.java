class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] indegree = new int[rows][cols];

        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        // Build indegrees:
        // smaller cell -> larger cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 ||
                        nr >= rows || nc >= cols) {
                        continue;
                    }

                    // current -> neighbor
                    if (matrix[nr][nc] > matrix[r][c]) {
                        indegree[nr][nc]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        // All source nodes
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (indegree[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        int levels = 0;

        // Topological BFS
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 ||
                        nr >= rows || nc >= cols) {
                        continue;
                    }

                    // Edge: smaller -> larger
                    if (matrix[nr][nc] > matrix[r][c]) {

                        indegree[nr][nc]--;

                        if (indegree[nr][nc] == 0) {
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            levels++;
        }

        return levels;
    }
}