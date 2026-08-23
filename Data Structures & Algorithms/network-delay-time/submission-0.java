class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // graph stores {neighbor, weight}
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] t : times)
        {
            int u = t[0];
            int v = t[1];
            int weight = t[2];

            graph.get(u).add(new int[]{v, weight});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // PriorityQueue stores {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, k});

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();

            int currDist = curr[0];
            int currNode = curr[1];

            // Ignore stale entry
            if(currDist > dist[currNode])
            {
                continue;
            }

            for(int[] edge : graph.get(currNode))
            {
                int nextNode = edge[0];
                int weight = edge[1];

                int newDist = currDist + weight;

                // Relaxation
                if(newDist < dist[nextNode])
                {
                    dist[nextNode] = newDist;

                    pq.add(new int[]{newDist, nextNode});
                }
            }
        }

        // Find when the LAST node receives the signal
        int maxTime = 0;

        for(int i = 1; i <= n; i++)
        {
            // Node cannot be reached
            if(dist[i] == Integer.MAX_VALUE)
            {
                return -1;
            }

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}