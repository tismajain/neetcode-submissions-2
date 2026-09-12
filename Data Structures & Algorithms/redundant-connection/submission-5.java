class Solution 
{
    int parent(int x, int[] p)
    {
        if(p[x]==x)
        return x;
        return parent(p[x],p);

    }
    public int[] findRedundantConnection(int[][] edges) 
    {
        int[] ans= new int[2];
        int[] p=new int[edges.length+1];
        for(int i=0;i<edges.length;i++)
        {
            p[i]=i;
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=parent(edges[i][0],p);
            int v=parent(edges[i][1],p);
            if(u==v)
            {
                
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];
                return ans;
            }
            else
            {
                p[v]=u;
            }
        }
        return ans;
    }
}
