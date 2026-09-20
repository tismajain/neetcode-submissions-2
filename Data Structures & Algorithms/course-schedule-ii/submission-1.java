class Solution {
    boolean dfs(List<List<Integer>> graph, int[] state, List<Integer> ans,int idx)
    {
        if(state[idx]==2)
        {
            return false;
        }
        if(state[idx]==1)
        {
            return true;
        }
        state[idx]=1;
        for(int neigh: graph.get(idx))
        {
            System.out.println(neigh);
                if(dfs(graph,state, ans, neigh))
                {
                    return true;
                }
            
        }
        state[idx]=2;
        ans.add(idx);
        return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] c:prerequisites)
        {
            graph.get(c[1]).add(c[0]);
        }
        int[] state=new int[numCourses];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(dfs(graph,state,ans,i))
            {
                return new int[0];
            }
        }
        Collections.reverse(ans);
        int[] res=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            res[i]=ans.get(i);
        }
        return res;

    }
}
