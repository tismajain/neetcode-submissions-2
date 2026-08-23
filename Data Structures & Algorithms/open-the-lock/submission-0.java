class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>();
        for(String s:deadends)
        {
            set.add(s);
        }
        HashSet<String> visited=new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add("0000");
        int level=0;
        int flag=0;
        while(!q.isEmpty())
        {
            
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                String curr=q.poll();
                if(set.contains(curr))
                {
                    continue;
                }
                if(curr.equals(target))
                {
                    flag=1;
                    break;
                }
                for(int j = 0; j < 4; j++)
            {
                String before = curr.substring(0, j);
                String after = curr.substring(j + 1);

                int digit = curr.charAt(j) - '0';

                char newdigit;
                newdigit=(char) ((digit+1)%10+ '0');
                String s1=before+newdigit+after;
                newdigit=(char)(((digit+10)-1)%10+ '0');
                String s2=before+newdigit+after;
                if(!visited.contains(s1)&&!set.contains(s1))
                {
                    q.add(s1);
                    visited.add(s1);

                }
                if(!visited.contains(s2)&&!set.contains(s2))
                {
                    q.add(s2);
                    visited.add(s2);

                }

            }


            }
            if(flag==1)
            {
                break;
            }
            level++;
            
        }
        return flag==1 ? level: -1;
    }
}