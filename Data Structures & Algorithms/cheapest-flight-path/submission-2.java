class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] f:flights)
        {
            int s=f[0];
            int d=f[1];
            int p=f[2];
            graph.get(s).add(new int[]{d,p});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<k+1;i++)
        {
            int[] temp=dist.clone();
            for(int node[]:flights)
            {
                
                int u=node[0];
                int v=node[1];
                int w=node[2];
                if(dist[u]==Integer.MAX_VALUE)
                {
                    continue;
                }
                if(dist[v]>dist[u]+w)
                {
                    temp[v]=Math.min(temp[v],dist[u]+w);
                }
            }
            dist=temp;
        }
        return dist[dst]==Integer.MAX_VALUE? -1:dist[dst];
        

    }
}
