class Solution {
    void dfs(int i, int[] v, List<List<Integer>> graph)
    {
        v[i]=1;
        for(int neigh: graph.get(i))
        {
            if(v[neigh]==0)
            {
                dfs(neigh, v,  graph);
            }
        }
       
        return;
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int c=0;
        int[] v=new int[n];
        Arrays.fill(v,0);
        for(int i=0;i<n;i++)
        {
            if(v[i]==0)
            {
                c++;
                dfs(i, v, graph);
            }
        }
        return c;
    }
}
