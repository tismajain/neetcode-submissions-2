class Solution {
    int find(int x, int[] parent)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return find(parent[x], parent);
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<=points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int[] p1=points[i];
                int[] p2=points[j];
                int distance=Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
                pq.add(new int[]{distance,i,j});
            }
        }
        int[] parent=new int[points.length];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
        }
        int total=0;
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int i=curr[1];
            int j=curr[2];
            int u=find(i, parent);
            int v=find(j, parent);

            if(u==v)
            {
                continue;
            }
            total+=curr[0];
            parent[v]=u;


        }
        return total;
    }
}
