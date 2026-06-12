class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        int sum=0;
        while(sum!=1)
        {
            sum=0;
            int x=n;
            while(x!=0)
            {
                sum+=((x%10)*(x%10));
                x=x/10;
            }
            if(set.contains(sum)) return false;
            

            if(sum==1)
            {
                return true;
            }
            set.add(sum);
            n=sum;
        }
        return true;
    }
}
