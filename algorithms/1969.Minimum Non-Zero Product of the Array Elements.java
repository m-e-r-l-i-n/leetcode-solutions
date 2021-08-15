class Solution {
    public int minNonZeroProduct(int p) {
        long ans=(1l<<p)-1;
        long pow=power(ans-1,(ans+1)/2-1);
        ans=ans%M*pow%M;
        return (int)ans;
    }
    
    long M=(int)1e9+7;
    long power(long a,long b)
    {
        long res=1; a%=M;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
