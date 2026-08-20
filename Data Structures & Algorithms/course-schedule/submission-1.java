class Solution {

    boolean dfs(int i, int[] state, List<List<Integer>> graph)
    {
        List<Integer> l=graph.get(i);
        state[i]=1;
        for(int j=0;j<l.size();j++)
        {
            if(state[l.get(j)]==1)
            {
                return true;
            }
            if(state[l.get(j)]==0)
            {
                if(dfs(l.get(j),state, graph))
                {
                    return true;
                }
            }
        }
        state[i]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites)
        {
            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
        }

        int[] state=new int[numCourses];
        Arrays.fill(state,0);

        for(int i=0;i<numCourses;i++)
        {
            if(state[i]==0)
            {
                if(dfs(i, state, graph))
                {
                    return false;
                }
            }
        }
        return true;

    }
}
