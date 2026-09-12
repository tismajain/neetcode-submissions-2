class Solution {
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        List<List<int[]>> graph=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0;i<n+1;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] t:times)
        {
            graph.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new int[]{0,k}); 

        while(!pq.isEmpty())
        {
            int[] node=pq.poll();
            if(dist[node[1]]<node[0])
            {
                continue;
            }
            for(int[] x: graph.get(node[1]))
            {
                int next=x[0];
                int time=x[1];
                if(node[0]+time<dist[next])
                {
                    dist[next]=node[0]+time;
                    pq.add(new int[]{dist[next],next});
                }
                
            }
            
        }
        int ans=0;
            for(int i=1;i<n+1;i++)
            {
                if(dist[i]==Integer.MAX_VALUE)
                {
                    return -1;
                }
                ans=Math.max(dist[i],ans);
            }
            return ans;
    }
}

