class Solution {
    boolean dfs(int i, int[] v,  int parent, List<List<Integer>> graph)
    {   
        v[i]=1;

        for(int neigh:graph.get(i))
        {
            if(neigh==parent)
            {
                continue;
            }
            if(v[neigh]==1)
            {
                return true;
            }
            if(v[neigh]==0)
            {
                if(dfs(neigh, v, i, graph))
                return true;

            }
        }
        v[i]=2;
        return false;

    }
    public boolean validTree(int n, int[][] edges) {
        int[] v=new int[n];
        Arrays.fill(v,0);
        List<List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);           

        }
        if(dfs(0, v, 0, graph))
        {
            return false;
        }
        for(int i=0;i<n;i++)
        {
            if(v[i]==0)
            {
                return false;
            }
        }
                
        return true;

        
    }
}
