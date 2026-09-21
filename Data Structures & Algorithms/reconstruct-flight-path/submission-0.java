class Solution {

    void dfs(HashMap<String, PriorityQueue<String>> map, List<String> ans, String curr )
    {
         PriorityQueue<String> pq = map.get(curr);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();   // use/remove this ticket
            dfs(map, ans, next);
    }
        ans.add(curr);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        // List<List<String>> graph=new ArrayList<>();
        // // HashSet<String> set=new HashSet<>();
        // // for(int i=0;i<tickets.size();i++)
        // // {
        // //     int[] s=tickets.get(i);
        // //     set.add()
        // // }
        // for(int i=0;i<tickets.size();i++)
        // {
        //     graph.add(new ArrayList<>());
        // }
        // for(int i=0;i<tickets.size();i++)
        // {
        //     graph.get(i).add;
        // }

        HashMap<String, PriorityQueue<String>> map=new HashMap<>();
        for(int i=0;i<tickets.size();i++)
        {
            List<String> f=tickets.get(i);

            map.computeIfAbsent(f.get(0), k -> new PriorityQueue<>()).add(f.get(1));
        }

        List<String> ans=new ArrayList<>();
        dfs(map, ans, "JFK");
        Collections.reverse(ans);


       


        return ans;
    }
}
