class Solution {
    public void helper(List<String> ans,String s, int n, int open, int close)
    {
        if(open==n && close==n)
        {
            ans.add(s);
            return;
        }
        if(close<open)
        {
            s+=")";
            helper(ans, s, n, open, close+1);
            s=s.substring(0,s.length()-1);
        }
        if(open<n)
        {
            s+="(";
            helper(ans, s,n, open+1, close);
            s=s.substring(0,s.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        String s="";
        helper(ans, s, n, 0, 0);
        return ans;
    }
}
