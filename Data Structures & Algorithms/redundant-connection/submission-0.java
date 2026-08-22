class Solution {
    boolean dfs(List<List<Integer>> graph, int u, int v, int parent)
    {
        for(int neigh: graph.get(u-1))
        {
            if(neigh==parent)
            {
                continue;
            }
            if(neigh==v)
            {
                return true;
            }
            if(dfs(graph, neigh, v, u))
            {
                return true;
            }
        }
        return false;

    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            graph.add(new ArrayList<>());
        }
        int[] ans=new int[2];
        for(int[] e:edges)
        {
            if(dfs(graph, e[0], e[1], e[0]))
            {
                ans[0]=e[0];
                ans[1]=e[1];
                break;
            }
            graph.get(e[0]-1).add(e[1]);
            graph.get(e[1]-1).add(e[0]);
        }
        
        

        return ans;
    }
}
