class Solution {
    public int monkeyMove(int num) {
        int M=(int)1e9+7,ans=(int)power(2,num,M);
        ans=(ans-2+M)%M;
        return ans;
    }
    
    long power(long a,int b,long M)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
