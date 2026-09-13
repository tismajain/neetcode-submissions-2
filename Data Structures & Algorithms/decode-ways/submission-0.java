class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!= '0')
            {
                dp[i+1]+=dp[i];
            }  
            if(i>=1)
            {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (num >= 10 && num <= 26) 
                    {
                        dp[i + 1] += dp[i - 1];
                    }
            }  
            System.out.print(dp[i]+" ");
        }
        
        return dp[s.length()];
    }
}
