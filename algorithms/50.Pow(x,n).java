class Solution {
    public double myPow(double x, int n) {
        double ans=1; int i,fl=0;
        if(x==1) return x;
        if(x==-1)
        {
            if(n%2==0) return 1;
            else return -1;
        }
        if(n==1) return x;
        if(n<0) {fl=1;n=-n;}
        while(n>0)
        {
            if(n%2==1) ans*=x;
            x*=x;
            n/=2;
        }
        if(fl==1) 
        {if(1.0/ans==ans) ans=0;
        else ans=1.0/ans;}
        return ans;
    }
}
