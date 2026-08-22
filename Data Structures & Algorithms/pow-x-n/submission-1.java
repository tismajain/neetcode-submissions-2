class Solution {
    double pow(double x, int n)
    {
        if(n==1)
        {
            return x;
        }
        double half=pow(x,n/2);
        if(n%2==0)
        return half*half;
        else
        return x*half*half;

    }
    double pow(double x, long n)
    {
        if(n==1)
        {
            return x;
        }
         double half=pow(x,n/2);
        if(n%2==0)
        return half*half;
        else
        return x*half*half;
    }
    public double myPow(double x, int n) {
        if(x==0)
        {
            return 0;

        }
        if(n==0)
        {
            return 1;
        }
        double res;
        if(n>0)
        {
            res=pow(x,n);
            return res;
        }
        else
        {
            long a=n;
            a=Math.abs(a);
           res=pow(x,a);
           return 1/res;


        }
        
        
        


    }
}
