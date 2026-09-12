class triplet {
    int node;
    int time;
    public triplet(int node, int time) {
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new int[] {v, t});
        }
        PriorityQueue<triplet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new triplet(k, 0));
        int[] dis = new int[n + 1];
        Arrays.fill(dis, (int) 1e9);
        dis[k] = 0;
        while (!pq.isEmpty()) {
            triplet cell = pq.poll();
            int node = cell.node;
            int time = cell.time;
            if (dis[node] < time)
                continue;
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (time + weight < dis[nextNode]) {
                    dis[nextNode] = time + weight;
                    pq.offer(new triplet(nextNode, dis[nextNode]));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == (int) 1e9)
                return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}
