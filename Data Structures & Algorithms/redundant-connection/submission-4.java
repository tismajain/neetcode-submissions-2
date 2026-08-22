class Solution {
    int find(int x, int[] parent)
    {
        if(parent[x]==x)
        {
            return x;
        }
       
            return find(parent[x], parent);

        
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            graph.add(new ArrayList<>());
        }
        int[] parent=new int[edges.length+1];
        for(int i=1;i<=edges.length;i++)
        {
            parent[i]=i;
        }
        int[] ans=new int[2];
        for(int[] e:edges)
        {
        
            int u=find(e[0],parent);
            int v=find(e[1],parent);
            if(u==v)
            {
                ans[0]=e[0];
                ans[1]=e[1];
                break;
            }
            parent[v]=u;
        }
        
        

        return ans;
    }
}
