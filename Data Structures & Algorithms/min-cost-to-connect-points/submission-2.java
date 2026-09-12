class Solution {
    int union(int x,int[] parent)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return union(parent[x],parent);
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int x=Math.abs(points[i][0]-points[j][0]);
                int y=Math.abs(points[i][1]-points[j][1]);
                int dist=(int)(x+y);
                pq.add(new int[]{dist, i, j});

            }
        }
        int[] parent=new int[points.length];
        for(int i=0;i<points.length;i++)
        {
            parent[i]=i;
        }
        int ans=0;
        int x=0;
        while(x<points.length-1)
        {
            int[] conn=pq.poll();
            int a=conn[1];
            int b=conn[2];
            int u=union(a,parent);
            int v=union(b,parent);
            if(u==v)
            {
                continue;
            }
            x++;
            ans+=conn[0];
            if(u<v)
            parent[v]=u;
            else
            parent[u]=v;
        }
        return ans;
    }
}
