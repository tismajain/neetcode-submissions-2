class Solution {

    boolean dfs(int i, int[] state, List<List<Integer>> graph)
    {
        List<Integer> l=graph.get(i);
        state[i]=1;
        for(int neighbour : graph.get(i))
        {
            if(state[neighbour] == 1)
                return true;

            if(state[neighbour] == 0)
            {
                if(dfs(neighbour, state, graph))
                    return true;
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
