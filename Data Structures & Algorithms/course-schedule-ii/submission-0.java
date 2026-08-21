class Solution {

    boolean dfs(int i, int[] state, List<List<Integer>> graph, List<Integer> ans)
    {
        List<Integer> l=graph.get(i);
        state[i]=1;
        for(int neighbour : graph.get(i))
        {
            if(state[neighbour] == 1)
                return true;

            if(state[neighbour] == 0)
            {
                if(dfs(neighbour, state, graph, ans))
                {
                    return true;
                }
            }
            
        }
        state[i]=2;
        ans.add(i);
        
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(state[i]==0)
            {
                if(dfs(i, state, graph, ans))
                {
                    return new int[0];
                }
            }
        }
        Collections.reverse(ans);
        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
        {
            result[i] = ans.get(i);
        }

        return result;
            }
}

