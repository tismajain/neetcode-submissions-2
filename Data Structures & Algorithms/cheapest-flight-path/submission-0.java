class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)  {
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
        int dist[][]=new int[n][k+2];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
        Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[src][0]=0;
        pq.offer(new int[]{0,src,0});
        while(!pq.isEmpty())
        {
            int[] node=pq.poll();
            int currprice=node[0];
            int state=node[1];
            int stop=node[2];
            if(currprice>dist[state][stop])
            {
                continue;
            }
            if(stop==k+1)
            {
                continue;
            }
            for(int[] u:graph.get(state))
            {
                int nextstate=u[0];
                int nextprice=u[1];
                if(dist[nextstate][stop+1]>currprice+nextprice)
                {
                    dist[nextstate][stop+1]=currprice+nextprice;
                    pq.offer(new int[]{currprice+nextprice,nextstate,stop+1});
                }
            }
        }
        int ans=Integer.MAX_VALUE;

        for(int i=1;i<=k+1;i++)
        {
            ans=Math.min(ans,dist[dst][i]);
        }
        return ans==Integer.MAX_VALUE? -1: ans;



    }
}
